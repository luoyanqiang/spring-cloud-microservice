package com.fish.providermovie.po;

public class TopicMail extends Mail {
    String routingkey;

    public String getRoutingkey() {
        return routingkey;
    }

    public void setRoutingkey(String routingkey) {
        this.routingkey = routingkey;
    }

    @Override
    public String toString() {
        return "TopicMail [routingkey=" + routingkey + "]";
    }

}