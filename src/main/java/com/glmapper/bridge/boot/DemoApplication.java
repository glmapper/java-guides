package com.glmapper.bridge.boot;


import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
        DemoApplication demoApplication = new DemoApplication();
        System.out.println(ClassLayout.parseInstance(demoApplication).toPrintable());

        System.out.println(ClassLayout.parseClass(DemoApplication.class).toPrintable());
    }
}
