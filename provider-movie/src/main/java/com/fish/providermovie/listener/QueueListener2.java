package com.fish.providermovie.listener;


import com.fish.providermovie.po.Mail;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueListener2 {
    
    @RabbitListener(queues = "myqueue")
    public void displayMail(Mail mail) throws Exception {
        System.out.println("队列监听器2号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "directqueue1")
    public void directQueue1(Mail mail) throws Exception {
        System.out.println("队列监听器directqueue1号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "directqueue2")
    public void directQueue2(Mail mail) throws Exception {
        System.out.println("队列监听器directqueue2号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "queue1")
    public void queue1(Mail mail) throws Exception {
        System.out.println("队列监听器queue1号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "queue2")
    public void queue2(Mail mail) throws Exception {
        System.out.println("队列监听器queue2号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "topicqueue1")
    public void topicQueue1(Mail mail) throws Exception {
        System.out.println("队列监听器topicqueue1号收到消息"+mail.toString());
    }

    @RabbitListener(queues = "topicqueue2")
    public void topicQueue2(Mail mail) throws Exception {
        System.out.println("队列监听器topicqueue2号收到消息"+mail.toString());
    }
}