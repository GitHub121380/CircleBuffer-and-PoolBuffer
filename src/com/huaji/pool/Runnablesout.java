package com.huaji.pool;

public class Runnablesout implements Runnable {
	PoolBuffer bufferPool;
	public Runnablesout(PoolBuffer bufferPool) {
		super();
		this.bufferPool = bufferPool;
	}
	@Override
	public void run() {
		while(true) {
			
				bufferPool.GetBuf(bufferPool.outq);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
