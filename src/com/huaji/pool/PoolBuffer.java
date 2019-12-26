package com.huaji.pool;

import com.huaji.circle.Buffer;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 滑技工厂
 * @version 1.0
 * @ClassName PoolBuffer
 * @Description 缓冲池 与演示图像无关，纯属代码模拟
 * @date 2019/12/22
 */
public class PoolBuffer extends JPanel {

    public int emqleft = 0;//emq出栈指针
    public int inqletf = 0;//inq出栈指针
    public int outqleft = 0;//out出栈指针
    public int emqright = 14;//emq进栈指针
    public int inqright = 0;//inq进栈指针
    public int outqright = 0;//outq进栈指针

    boolean flag2 = true;

    Queue<Buffer> emq;
    Queue<Buffer> inq;
    Queue<Buffer> outq;

    Graphics g;

    public void setG() {
        this.g = getGraphics();
    }


    public PoolBuffer(int size) {
        this.emq = new LinkedList<>();
        this.inq = new LinkedList<>();
        this.outq = new LinkedList<>();

        Buffer buffer;
        for (int i = 0; i < size; i++) {
            buffer = new Buffer("空");
            emq.add(buffer);
        }
    }

    /*
     * @Title GetBuf
     * @Description 包含收容输入、提取输入、提取输出（无收容输出，在另一个方法里）
     * @author 张佳乐
     * @Date 2019/12/22
     * @param [queue]
     * @return com.huaji.circle.Buffer
     * @throws
     */
    public Buffer GetBuf(Queue<Buffer> queue) {
        Buffer buffer = null;
        if (flag2) {
            flag2 = false;
            //收容输入
            if (queue == emq && queue.size() != 0) {
                    //退出空白缓冲队列
                    buffer = queue.poll();
                    g.setColor(Color.WHITE);
                    g.fillRect(400 + emqleft * 30, 100, 25, 25);

                    emqleft = (emqleft + 1) % 10;

                    putBuf(buffer, inq);

            } else if (queue == inq && queue.size()!=0) {//提取输入
                buffer = inq.poll();

                g.setColor(Color.WHITE);
                //inq队列出
                g.fillRect(400 + inqletf * 30, 230, 25, 25);
                inqletf = (inqletf+1)%10;

                putBuf(buffer, emq);

            } else if (queue == outq && queue.size() != 0) {//提取输出
                buffer = outq.poll();

                g.setColor(Color.white);
                //outq队列出
                g.fillRect(400 + outqleft * 30, 360, 25, 25);

                outqleft = (outqleft+1)%10;
                putBuf(buffer, emq);

            }
            flag2 = true;
        }
        return buffer;
    }
    /*
     * @Title GetBufHout
     * @Description 收容输出
     * @author 张佳乐
     * @Date 2019/12/22
     * @param [queue]
     * @return com.huaji.circle.Buffer
     * @throws
     */
    public Buffer GetBufHout (Queue<Buffer> queue) {
        Buffer buffer = null;
        if (flag2) {
            flag2 = false;
            if (queue == emq && emq.size()!=0) {//收容输出
                buffer = queue.poll();

                g.setColor(Color.WHITE);
                g.fillRect(400 + emqleft * 30, 100, 25, 25);
                emqleft = (emqleft + 1) % 10;

                putBuf(buffer, outq);
            }

        }
        flag2 = true;
        return buffer;
    }

    public void putBuf(Buffer buffer, Queue<Buffer> queue) {
        if (flag2) {
            flag2 = false;
            queue.add(buffer);
            g.setColor(Color.GREEN);
            //提取输入、提取输出，放入空缓冲队列
            if (queue == emq) {
                emqright = (emqright + 1) % 10;
                g.fillRect(400 + emqright * 30, 100, 25, 25);
            } else if (queue == inq) {//收容输入
                g.fillRect(400 + inqright * 30, 230, 25, 25);
                inqright = (inqright + 1) % 10;
            } else if (queue == outq) {//收容输出
                g.fillRect(400 + outqright * 30, 360, 25, 25);
                outqright = (outqright + 1) % 10;
            }
        }
        flag2 = true;
    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.GREEN);

        g.drawRect(100, 170, 250, 170);
        g.drawRect(137, 197, 70, 50);
        g.drawString("收容输入", 167, 227);
        g.drawRect(137, 273, 70, 50);
        g.drawString("收容输出", 300, 307);
        g.drawRect(270, 197, 70, 50);
        g.drawString("提取输入", 300, 227);
        g.drawRect(270, 273, 70, 50);
        g.drawString("提取输出", 167, 307);

        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 100, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 100);
        }

        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 360, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 360);
        }
        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 230, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 230);
        }
        for (int j = 0; j < 10; j++) {
            g.fillRect(400 + j * 30, 100, 25, 25);
        }

    }
}
