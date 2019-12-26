package com.huaji.circle;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName CircleBuffer
 * @Description 循环缓冲
 * @author 滑技工厂
 * @date 2019/12/20
 * @version 1.0
 */
public class CircleBuffer extends JPanel {


    Graphics g;

    public int x = 100;
    public int y = 100;
    public int width = 400;
    public int height = 400;

    int nexti,nextg,current;

    private Buffer[] buffers;
    //大小设为6
    int size = 6;

    static boolean flag;

    public CircleBuffer() {
        this.nexti = 0;
        this.buffers = new Buffer[size];
    }

    /*
     * @Title modifyi
     * @Description 对空缓冲区进行getbuf
     * @author 张佳乐
     * @Date 2019/12/20
     * @param [graphics, i环形队列索引]
     * @return java.awt.Graphics
     * @throws
     */
    public void modifyi(int i) {
        switch (i) {
            case 0:
                g.setColor(Color.RED);
                g.fillOval(x + 200 - 35, y - 35, 50, 50);
                break;
            case 1:
                g.setColor(Color.RED);
                g.fillOval(x - 173 + 200 - 35, y + 100 - 35, 50, 50);
                break;
            case 2:
                g.setColor(Color.RED);
                g.fillOval(x - 173 + 200 - 35, y + 300 - 35, 50, 50);
                break;
            case 3:
                g.setColor(Color.RED);
                g.fillOval(x + 200 - 35, y + 400 - 35, 50, 50);
                break;
            case 4:
                g.setColor(Color.RED);
                g.fillOval(x + 200 + 173 - 35, y + 300 - 35, 50, 50);
                break;
            case 5:
                g.setColor(Color.RED);
                g.fillOval(x + 200 + 173 - 35, y + 100 - 35, 50, 50);
                break;
            default:
                break;
        }

    }

    /*
     * @Title modifyt
     * @Description 对满缓冲区进行getbuf
     * @author 张佳乐
     * @Date 2019/12/20
     * @param [graphics, i环形队列索引]
     * @return java.awt.Graphics
     * @throws
     */
    public void modifyt(int i) {
        g.setColor(Color.YELLOW);
        switch (i) {
            case 0:
                g.fillOval(x + 200 - 35, y - 35, 50, 50);
                break;
            case 1:
                g.fillOval(x - 173 + 200 - 35, y + 100 - 35, 50, 50);
                break;
            case 2:
                g.fillOval(x - 173 + 200 - 35, y + 300 - 35, 50, 50);
                break;
            case 3:
                g.fillOval(x + 200 - 35, y + 400 - 35, 50, 50);
                break;
            case 4:
                g.fillOval(x + 200 + 173 - 35, y + 300 - 35, 50, 50);
                break;
            case 5:
                g.fillOval(x + 200 + 173 - 35, y + 100 - 35, 50, 50);
                break;
            default:
                break;
        }

    }


    /*
     * @Title getBuf
     * @Description getbuf操作
     * @author 张佳乐
     * @Date 2019/12/20
     * @param [type]1为空缓冲区，2为满缓冲区
     * @return int 被操作的缓冲区索引
     * @throws
     */
    public int getBuf(int type) {
        g = getGraphics();

        g.drawString("黄色为正在使用的缓冲区", x + 200 + 250, y + 100 + 20);
        g.drawString("红色为满的缓冲区", x + 200 + 250, y + 100 + 50);
        g.drawString("绿色为已经释放的缓冲区", x + 200 + 250, y + 100 + 80);

        //画缓冲区
        g.drawOval(x + 200 - 35, y - 35, 50, 50);//1号缓冲区
        g.drawString("0号缓冲区", x + 200 - 40, y - 35);
        g.drawOval(x - 173 + 200 - 35, y + 100 - 35, 50, 50);
        g.drawString("1号缓冲区", x - 173 + 200 - 35, y + 100 - 35);
        g.drawOval(x - 173 + 200 - 35, y + 300 - 35, 50, 50);
        g.drawString("2号缓冲区", x - 173 + 200 - 35, y + 300 - 35);
        g.drawOval(x + 200 - 35, y + 400 - 35, 50, 50);
        g.drawString("3号缓冲区", x + 200 - 35, y + 400 - 35);
        g.drawOval(x + 200 + 173 - 35, y + 300 - 35, 50, 50);
        g.drawString("4号缓冲区", x + 200 + 173 - 35, y + 300 - 35);
        g.drawOval(x + 200 + 173 - 35, y + 100 - 35, 50, 50);
        g.drawString("5号缓冲区", x + 200 + 173 - 35, y + 100 - 35);


        switch (type) {
            //获得空的缓冲区进行使用
            case 1:
                this.buffers[nexti] = new Buffer("进程");

                if (flag == false) {
                    nextg = nexti;
                    flag = true;
                }
                modifyi(nexti);
                System.out.println("已经将数据装入缓冲区" + nexti);
                this.nexti = (nexti + 1) % size;

                //追上cpu消耗
                if (nexti == nextg) {
                    System.out.println("所有缓冲区都已经占满，输入进程受到阻塞");
                    return -1;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return this.nexti;
            //消耗缓冲区中的数据
            case 2:
                //追上i/o
                if (flag != false && nextg == nexti) {
                    System.out.println("....数据输入时间太慢，I/O受到限制");
                    return -2;
                }
                if (flag == false) {
                    System.out.println("缓冲区暂时还没有数据");
                    return -2;
                }

                this.current = this.nextg;
                modifyt(nextg);
                try {
                    Thread.sleep(2000);
                    g.setColor(Color.GREEN);
                    switch (current) {
                        case 0:
                            g.fillOval(x + 200 - 35, y - 35, 50, 50);
                            break;
                        case 1:
                            g.fillOval(x - 173 + 200 - 35, y + 100 - 35, 50, 50);
                            break;
                        case 2:
                            g.fillOval(x - 173 + 200 - 35, y + 300 - 35, 50, 50);
                            break;
                        case 3:
                            g.fillOval(x + 200 - 35, y + 400 - 35, 50, 50);
                            break;
                        case 4:
                            g.fillOval(x + 200 + 173 - 35, y + 300 - 35, 50, 50);
                            break;
                        case 5:
                            g.fillOval(x + 200 + 173 - 35, y + 100 - 35, 50, 50);
                            break;
                        default:
                            break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("正在使用缓冲区" + current + "中的数据");
                Releasebuf(this.nextg);


                return this.nextg - 1;
            default:
                break;
        }
        return this.nextg - 1;
    }
    /*
     * @Title Releasebuf
     * @Description releasebuf过程
     * @author 张佳乐
     * @Date 2019/12/20
     * @param [nextg]
     * @return void
     * @throws
     */
    public void Releasebuf(int nextg) {
        System.out.println("正在释放缓冲区" + nextg);
        this.nextg = (nextg + 1) % size;

    }


}
