package com.huaji.pool;

public class Runnableehin implements Runnable {
    PoolBuffer bufferPool;

    public Runnableehin(PoolBuffer bufferPool) {
        super();
        this.bufferPool = bufferPool;
    }

    @Override
    public void run() {
        while (true) {

            bufferPool.GetBuf(bufferPool.emq);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
