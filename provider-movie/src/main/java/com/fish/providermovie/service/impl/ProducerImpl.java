package com.fish.providermovie.service.impl;

import com.fish.providermovie.po.Mail;
import com.fish.providermovie.service.Producer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("producer")
public class ProducerImpl implements Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Override
    public void sendMail(String queue, Mail mail) {
        rabbitTemplate.setQueue(queue);
        rabbitTemplate.convertAndSend(queue,mail);
    }

}