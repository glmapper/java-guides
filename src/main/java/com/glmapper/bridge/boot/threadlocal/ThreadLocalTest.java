package com.glmapper.bridge.boot.threadlocal;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2021/3/18 11:00 上午
 * @since:
 **/
public class ThreadLocalTest {

    private static ThreadLocal<String> ThreadNames = new ThreadLocal<>();

    public static void main(String[] args) {
        ThreadNames.set(Thread.currentThread().getName());
        for (int i = 0 ; i < 10 ; i ++ ){
            Thread thread = new Thread(new NameTask());
            thread.start();
        }

        System.out.println(ThreadNames.get());
    }

    static class NameTask implements Runnable {
        @Override
        public void run() {
            ThreadNames.set(Thread.currentThread().getName());
        }
    }
}
