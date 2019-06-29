package com.fish.providermovie.service;

import com.fish.providermovie.po.Mail;

public interface Publisher {

    public void publishMail(Mail mail);

    public void sendDirectMail(Mail mail, String routingkey);

    public void sendTopicMail(Mail mail, String routingkey);

}
