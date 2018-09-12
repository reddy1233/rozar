package com.comopt.touchpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
//@EnableScheduling
@EnableAutoConfiguration
@EnableJms
public class TouchPointApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TouchPointApplication.class);
    }
}
