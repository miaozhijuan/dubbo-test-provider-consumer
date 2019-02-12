package com.example.demo.producer.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class Consumer {

    @JmsListener(destination = "lishikai.queue")
    public void receiveQueue(String text) {
        System.out.println(text);
    }



    //需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    @JmsListener(destination = "lishikai.topic", containerFactory="jmsListenerContainerTopic")
    public void receiveTopic(String text) {
        System.out.println(text);
    }

}