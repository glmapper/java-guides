package com.glmapper.bridge.boot;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;

public class TestMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        accessPublic();
    }

    private static void accessPublic() throws NoSuchFieldException, IllegalAccessException {
        TestModel instance = new TestModel();
        VarHandle handle = MethodHandles.lookup()
                .in(TestModel.class)
                .findVarHandle(TestModel.class, "count", int.class);
        handle.set(instance, 99);
        System.out.println(instance);

        Field field = instance.getClass().getDeclaredField("count");
        field.setAccessible(true);
        field.set(instance, 100);

        System.out.println(instance);
    }

    private static void accessProtected() throws NoSuchFieldException, IllegalAccessException {
        TestModel instance = new TestModel();
        VarHandle handle = MethodHandles.lookup()
                .in(TestModel.class)
                .findVarHandle(TestModel.class, "sum", long.class);
        handle.set(instance, 99999);
        System.out.println(instance);

        Field field = instance.getClass().getDeclaredField("sum");
        field.setAccessible(true);
        field.set(instance, 100000);
        System.out.println(instance);
    }

    private static void accessPrivate() throws IllegalAccessException, NoSuchFieldException {
        TestModel instance = new TestModel();
        // privateLookupIn
        VarHandle handle = MethodHandles.privateLookupIn(TestModel.class, MethodHandles.lookup())
                .findVarHandle(TestModel.class, "name", String.class);
        handle.set(instance, "hello world");
        System.out.println(instance);

        Field field = instance.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(instance, "hello glmapper");
        System.out.println(instance);
    }

    private static void accessArray() throws NoSuchFieldException, IllegalAccessException {
        TestModel instance = new TestModel();
        // arrayElementVarHandle
        VarHandle handle = MethodHandles.arrayElementVarHandle(int[].class);
        handle.compareAndSet(instance.arrayData, 0, 3, 100);
        handle.compareAndSet(instance.arrayData, 1, 5, 300);
        System.out.println(instance);

        Field field = instance.getClass().getDeclaredField("arrayData");
        field.setAccessible(true);
        int[] newArr = new int[]{200, 400, 7};
        field.set(instance, newArr);
        System.out.println(instance);
    }
}
