package com.glmapper.bridge.boot.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author guolei.sgl
 * @date 2021/3/26 5:13 下午
 * @since
 **/
public class MyThreadPool {

    static ThreadPoolExecutor POOL = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),Runtime.getRuntime().availableProcessors()+10,60, TimeUnit.SECONDS,new ArrayBlockingQueue(3));

    public static void main(String[] args) {
        POOL.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(111);
            }
        });
    }
}
