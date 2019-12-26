package com.huaji.pool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 滑技工厂
 * @version 1.0
 * @ClassName PoolFrame
 * @Description 缓冲池框
 * @date 2019/12/22
 */
public class PoolFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("缓冲池");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width / 2, d.height / 2);
        frame.setLocation(800, 100);
        PaintAll bufferPool = new PaintAll();
        JButton hin = new JButton("收容输入");
        hin.setBounds(100, 100, 50, 50);
        bufferPool.add(hin);
        JButton sin = new JButton("提取输出");
        bufferPool.add(sin);
        JButton hout = new JButton("收容输出");
        bufferPool.add(hout);

        JButton sout = new JButton("提取输出");
        bufferPool.add(sout);

        frame.add(bufferPool);
        frame.setVisible(true);
        bufferPool.setGraphic();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //收容输入
        hin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bufferPool.emqlength>0) {
                    bufferPool.modifyemq(0, Color.white);
                    bufferPool.setEmqlength(bufferPool.emqlength - 1);

                    bufferPool.modifyemq(bufferPool.emqlength, Color.white);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    bufferPool.setqueue(bufferPool.emqlength, 100);
                    bufferPool.setpool(137, 197, Color.RED);

                    bufferPool.modifyinq(bufferPool.inqlength, Color.RED);
                    bufferPool.setInqlength(bufferPool.inqlength + 1);

                    bufferPool.setpoolwhite(137, 197);
                }
            }
        });

        //提取输入
        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bufferPool.inqlength>0) {
                    bufferPool.modifyinq(0, Color.white);
                    bufferPool.setInqlength((bufferPool.inqlength-1));
                    bufferPool.setpool(270, 197, Color.RED);
                    bufferPool.setpoolwhite(270, 197);
                    bufferPool.modifyinq(bufferPool.inqlength, Color.white);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    bufferPool.setqueue(bufferPool.inqlength,230);
                    bufferPool.modifyemq(bufferPool.emqlength, Color.RED);
                    bufferPool.setEmqlength(bufferPool.emqlength+1);
                }
            }
        });

        sout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((bufferPool.outqlength)>0) {
                    bufferPool.modifyoutq(0, Color.white);


                    bufferPool.setOutqlength(bufferPool.outqlength-1);
                    bufferPool.setpool(137, 273, Color.RED);

                    bufferPool.setpoolwhite(137, 273);
                    bufferPool.modifyoutq(bufferPool.outqlength, Color.white);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                    bufferPool.setqueue(bufferPool.outqlength,360);
                    bufferPool.modifyemq(bufferPool.emqlength, Color.RED);
                    bufferPool.setEmqlength(bufferPool.emqlength+1);
                }
            }
        });


        hout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((bufferPool.emqlength)>0) {
                    bufferPool.modifyemq(0, Color.white);
                    bufferPool.setEmqlength(bufferPool.emqlength-1);

                    bufferPool.modifyemq(bufferPool.emqlength, Color.white);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    bufferPool.setqueue(bufferPool.emqlength,100);
                    bufferPool.setpool(270,273, Color.RED);

                    bufferPool.modifyoutq(bufferPool.outqlength, Color.RED);
                    bufferPool.setOutqlength(bufferPool.outqlength+1);


                    bufferPool.setpoolwhite(270, 273);
                }

            }
        });
    }
}
