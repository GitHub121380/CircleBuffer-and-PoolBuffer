package com.huaji.circle;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName CircleFrame
 * @Description frame框显示
 * @author 滑技工厂
 * @date 2019/12/20
 * @version 1.0
 */
public class CircleFrame {

    public static void main(String[] args) {
        CircleBuffer circleBuffer = new CircleBuffer();
        RunnableNexti nexti = new RunnableNexti(circleBuffer);
        RunnableNextg nextg = new RunnableNextg(circleBuffer);

        //画框
        JFrame frame = new JFrame("循环缓冲");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(dimension.width/2,dimension.height/2+200);
        frame.setLocation(50,50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(circleBuffer);
        Thread threadi = new Thread(nexti);
        Thread threadg = new Thread(nextg);
        threadg.setPriority(10);
        threadi.setPriority(1);
        threadi.start();
        threadg.start();

    }
}
