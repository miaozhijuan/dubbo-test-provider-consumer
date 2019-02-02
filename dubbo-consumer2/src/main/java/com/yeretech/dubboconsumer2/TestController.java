package com.yeretech.dubboconsumer2;


import com.alibaba.dubbo.config.annotation.Reference;
import com.yeretech.dubboprovider.TestService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "/user", description = "Operations about user")
@RestController
public class TestController {

    @Reference
    TestService testService ;

    @RequestMapping("/test")
    public String main(@RequestParam("name") String name){

        return testService.sayHello(name);


    }

    @RequestMapping("/play")
    public String don(){

        return testService.sayHello("hellolishikai");

    }
}
