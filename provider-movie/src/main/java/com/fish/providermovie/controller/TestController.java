package com.fish.providermovie.controller;

import com.fish.providermovie.po.Mail;
import com.fish.providermovie.service.Producer;
import com.fish.providermovie.service.Publisher;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: luo
 * @Time: 2019-03-14 09:15
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Publisher publisher;
    @Autowired
    private Producer producer;

    @PostMapping("rabbit")
    public void rabbit(String queue, Mail mail) {
        producer.sendMail(queue, mail);
    }

    @PostMapping("publish")
    public void publish(String type, String key, Mail mail) {
        switch (type) {
            case "publish" :
                publisher.publishMail(mail);
                break;
            case "direct" :
                publisher.sendDirectMail(mail, key);
                break;
            case "topic" :
                publisher.sendTopicMail(mail, key);
                break;
            default:
        }
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostMapping("deadLetter")
    public void sendMsg(String content) {
        MessagePostProcessor messagePostProcessor = message -> {
            MessageProperties messageProperties = message.getMessageProperties();
//            设置编码
            messageProperties.setContentEncoding("utf-8");
//            设置过期时间10*1000毫秒
            messageProperties.setExpiration("20000");
            return message;
        };
        rabbitTemplate.convertAndSend("DL_EXCHANGE", "DL_KEY", content, messagePostProcessor);
    }


}
