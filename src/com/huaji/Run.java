package com.huaji;

import com.huaji.circle.CircleFrame;
import com.huaji.pool.PoolFrame;

/**
 * @ClassName Run
 * @Description 执行类
 * @author 滑技工厂
 * @date 2019/12/22
 * @version 1.0
 */
public class Run {
    public static void main(String[] args) {
        CircleFrame circleFrame = new CircleFrame();
        circleFrame.main(args);
        PoolFrame poolFrame = new PoolFrame();
        poolFrame.main(args);
    }
}
