package com.yeretech.dubboconsumer2;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class DubboConsumer2Application {

    public static void main(String[] args) {

        SpringApplication.run(DubboConsumer2Application.class, args);
    }

}

