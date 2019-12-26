package com.huaji.pool;

public class Runnablesin implements Runnable {
    PoolBuffer bufferPool;

    public Runnablesin(PoolBuffer bufferPool) {
        super();
        this.bufferPool = bufferPool;
    }

    @Override
    public void run() {
        while (true) {

            bufferPool.GetBuf(bufferPool.inq);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
