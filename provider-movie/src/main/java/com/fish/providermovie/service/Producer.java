package com.fish.providermovie.service;

import com.fish.providermovie.po.Mail;

public interface Producer {

    public void sendMail(String queue, Mail mail);


}
