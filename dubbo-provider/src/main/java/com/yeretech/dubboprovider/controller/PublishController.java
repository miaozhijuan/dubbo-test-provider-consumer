package com.yeretech.dubboprovider.controller;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.broker.region.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * @author: elvin
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    @Resource
    private JmsMessagingTemplate jms;

    @Resource
    private Queue queue;

    @Resource
    private Topic topic;

    @RequestMapping("/queue")
    public String queue(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend((Destination) queue, "queue"+i);
        }

        return "queue 发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void consumerMsg(String msg){
        System.out.println(msg);
    }

    @RequestMapping("/topic")
    public String topic(){

        for (int i = 0; i < 10 ; i++){
            jms.convertAndSend((Destination) topic, "topic"+i);
        }

        return "topic 发送成功";
    }
}
