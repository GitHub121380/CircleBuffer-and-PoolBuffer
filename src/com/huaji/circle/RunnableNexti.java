package com.huaji.circle;

/*
 * @ClassName RunnableNexti
 * @Description 输入进程的线程
 * @author 张佳乐
 * @date 2019/12/20
 * @version 1.0
 */
public class RunnableNexti implements Runnable {
    public CircleBuffer circleBuffer;


    public RunnableNexti(CircleBuffer circleBuffer) {
        super();
        this.circleBuffer = circleBuffer;
    }


    @Override
    public void run() {
        while (true) {
            int state = circleBuffer.getBuf(Buffer.Nexti);
            try {
                //让cpu多执行一会
                if (state == -1) {
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
