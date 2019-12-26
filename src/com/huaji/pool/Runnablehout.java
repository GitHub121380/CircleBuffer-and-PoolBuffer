package com.huaji.pool;

public class Runnablehout implements Runnable {
    PoolBuffer bufferPool;

    public Runnablehout(PoolBuffer bufferPool) {
        super();
        this.bufferPool = bufferPool;
    }

    @Override
    public void run() {
        while (true) {

            bufferPool.GetBufHout(bufferPool.emq);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
