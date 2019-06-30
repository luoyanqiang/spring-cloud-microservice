package com.fish.providermovie.listener;

import com.fish.providermovie.po.Mail;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@RabbitListener(queues = "myqueue")
public class QueueListener1 {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @RabbitHandler
    public void displayMail(Mail mail, Channel channel, Message message) throws Exception {
        int pre = atomicInteger.getAndAdd(1);
        System.out.println("============================" + Integer.toString(pre));
        System.out.println("队列监听器1号收到消息" + mail.toString());
        if(pre > 10) {

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } else {
            //如果需要确认的要调用
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}