package com.huaji.pool;

import javax.swing.*;
import java.awt.*;

/**
 * @author 张佳乐
 * @version 1.0
 * @ClassName
 * @Description 缓冲池画画
 * @date 2019/12/22
 */
public class PaintAll extends JPanel {
    public int emqlength = 10;
    public int inqlength = 0;
    public int outqlength = 0;


    public int getEmqlength() {
        return emqlength;
    }

    public void setEmqlength(int emqlength) {
        this.emqlength = emqlength;
    }

    public int getInqlength() {
        return inqlength;
    }

    public void setInqlength(int inqlength) {
        this.inqlength = inqlength;
    }

    public int getOutqlength() {
        return outqlength;
    }

    public void setOutqlength(int outqlength) {
        this.outqlength = outqlength;
    }

    public Graphics graphic;

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLUE);

        g.drawRect(120, 170, 250, 170);

        g.drawRect(137, 273, 70, 50);
        g.drawRect(137, 197, 70, 50);
        g.drawRect(270, 197, 70, 50);
        g.drawRect(270, 273, 70, 50);

        g.drawString("收容输入", 147, 190);
        g.drawString("收容输出", 280, 265);
        g.drawString("提取输入", 280, 190);
        g.drawString("提取输出", 147, 265);

        g.drawString("emq 队列", 400, 80);
        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 100, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 100);

        }
        g.drawString("inq 队列", 400, 210);
        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 360, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 360);
        }
        g.drawString("outq 队列", 400, 340);
        for (int i = 0; i < 10; i++) {
            g.drawRect(400 + i * 30, 230, 30, 30);
            g.drawString(String.valueOf(i), 415 + i * 30, 230);
        }
        for (int j = 0; j < 10; j++) {
            g.fillRect(400 + j * 30, 100, 25, 25);
        }

    }

    public void setqueue(int length, int y) {
        for (int j = 0; j < length; j++) {
            graphic.setColor(Color.BLUE);
            graphic.fillRect(400 + j * 30, y, 25, 25);
            try {

                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    public void setGraphic() {
        this.graphic = getGraphics();

    }

    public void modifyemq(int i, Color color) {

        graphic.setColor(color);
        graphic.fillRect(400 + i * 30, 100, 25, 25);
    }

    public void modifyinq(int inq, Color color) {

        graphic.setColor(color);
        graphic.fillRect(400 + inq * 30, 230, 25, 25);
    }

    public void modifyoutq(int outq, Color color) {

        graphic.setColor(color);
        graphic.fillRect(400 + outq * 30, 360, 25, 25);
    }

    public void setpool(int x, int y, Color color) {
        for (int j = 0; j < 7; j++) {
            graphic.setColor(color);
            graphic.fillRect(x, y, 10, 50);
            x = x + 10;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setpoolwhite(int x, int y) {

        graphic.setColor(Color.white);
        graphic.fillRect(x, y, 70, 50);
    }

}
