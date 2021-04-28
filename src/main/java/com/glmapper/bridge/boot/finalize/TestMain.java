package com.glmapper.bridge.boot.finalize;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2021/3/8 11:16 上午
 * @since:
 **/
public class TestMain {

    private static AtomicInteger COUNT = new AtomicInteger(0);

    public TestMain() {
        COUNT.incrementAndGet();
    }

    /**
     * 重写 finalize 方法测试
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        COUNT.decrementAndGet();
    }

    public static void main(String args[]) {
        for (int i = 0 ;; i++) {
            TestMain item = new TestMain();
            if ((i % 100000) == 0) {
                System.out.format("creating %d objects, current %d are alive.%n", new Object[] {i, COUNT.get() });
            }
        }
    }
}
