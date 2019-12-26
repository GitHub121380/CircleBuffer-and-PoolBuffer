package com.huaji.circle;

/**
 * @ClassName Buffer
 * @Description 代表一个缓冲区
 * @author 滑技工厂
 * @date 2019/12/20
 * @version 1.0
 */
public class Buffer {
    //指向下个空的缓冲区
    public final static int Nexti=1;
    //指向进程计算下一个可用缓冲区
    public final static int Nextg=2;

    int state;
    String data;

    public Buffer(int state, String data) {
        this.state = state;
        this.data = data;
    }

    public Buffer(int state) {
        this.state = state;
    }

    public Buffer(String data) {
        this.data = data;
    }
}
