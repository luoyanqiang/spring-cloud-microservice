package com.fish.providermovie.listener;

import com.fish.providermovie.po.Mail;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "myqueue")
public class QueueListener1 {

    @RabbitHandler
    public void displayMail(Mail mail, Channel channel, Message message) throws Exception {
        System.out.println("队列监听器1号收到消息" + mail.toString());
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);//如果需要确认的要调用
    }
}