//package com.example.demo;
//
//import java.io.InputStream;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author glmapper_2018@163.com 2021/2/26 5:22 下午
// * @since
// **/
//
//public class LinkageMain {
//    static class MyClassLoader extends ClassLoader {
//        private Set<String> selfFirstClasses;
//        private String label;
//
//        public MyClassLoader(String name, ClassLoader parent, String... selfFirstNames) {
//            super(parent);
//            label = name;
//            selfFirstClasses = new HashSet<>(Arrays.asList(selfFirstNames));
//        }
//
//        @Override
//        public Class<?> findClass(String name) throws ClassNotFoundException {
//            if (selfFirstClasses.contains(name)) {
//                String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
//                try (InputStream is = getClass().getResourceAsStream(filename)) {
//                    byte[] buf = new byte[is.available()];
//                    int len = is.read(buf);
//                    System.out.println(label + ": defining " + name);
//                    return defineClass(name, buf, 0, len);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            throw new ClassNotFoundException(name);
//        }
//
//        @Override
//        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//            if (findLoadedClass(name) != null) {
//                if (!name.startsWith("java.")) {
//                    System.out.println(label + ": already loaded(" + name + ")");
//                }
//                return findLoadedClass(name);
//            }
//
//            if (selfFirstClasses.contains(name)) {
//                return findClass(name);
//            } else {
//                if (!name.startsWith("java.")) {
//                    System.out.println(label + ": super.loadClass(" + name + ")");
//                }
//                System.out.println(label + ": loading " + name);
//                return super.loadClass(name, resolve);
//            }
//        }
//
//        @Override
//        public String toString() {
//            return label;
//        }
//    }
//
//    public static class User {}
//    public static class Login {
//        static {
//            System.out.println("Login loaded");
//        }
//        public static void login(User u) {
//            System.out.println("user loaded by " + u.getClass().getClassLoader());
//        }
//    }
//    public static class Main {
//        public static void doGet() {
//            User u = new User();
//            System.out.println("Logging in with User loaded in " + u.getClass().getClassLoader());
//            Login.login(u);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        MyClassLoader baseCL = new MyClassLoader("Base", LinkageMain.class.getClassLoader(),
//                "com.example.demo.LinkageMain$User",
//                "com.example.demo.LinkageMain$Login");
//        MyClassLoader parentFirstCL = new MyClassLoader("parentFirst", baseCL,
//                "com.example.demo.LinkageMain$Main");
//        MyClassLoader selfFirstCL = new MyClassLoader("selfFirst", baseCL,
//                "com.example.demo.LinkageMain$User",
//                "com.example.demo.LinkageMain$Main");
//
//        try {
////            baseCL.loadClass("com.guaner.happycoding.playground.core.LinkageMain$Login", true).newInstance();
////            parentFirstCL.loadClass("com.guaner.happycoding.playground.core.LinkageMain$Main").getMethod("doGet").invoke(null);
////            System.out.println(".........................");
//
//            selfFirstCL.loadClass("com.example.demo.LinkageMain$Main").getMethod("doGet").invoke(null);
//
//            System.out.println(".........................");
//
////            parentFirstCL.loadClass("com.example.demo.LinkageMain$Main").getMethod("doGet").invoke(null);
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
//}
