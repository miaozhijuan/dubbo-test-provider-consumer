package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class Producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     *为什么resource能用autowired不能用
     */
    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/sendMsg")
    public void send(@RequestParam(defaultValue = "helloworld") String msg) {
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);

    }

}
