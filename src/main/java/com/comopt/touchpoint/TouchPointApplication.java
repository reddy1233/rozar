package com.comopt.touchpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableScheduling
@EnableAutoConfiguration
public class TouchPointApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TouchPointApplication.class);
    }
}
