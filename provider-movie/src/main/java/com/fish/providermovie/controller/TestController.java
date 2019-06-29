package com.fish.providermovie.controller;

import com.fish.providermovie.po.Mail;
import com.fish.providermovie.service.Producer;
import com.fish.providermovie.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
