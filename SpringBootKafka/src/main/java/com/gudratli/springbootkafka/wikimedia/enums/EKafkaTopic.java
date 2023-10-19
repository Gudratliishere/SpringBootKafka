package com.gudratli.springbootkafka.wikimedia.enums;

/**
 * @author : Dunay Gudratli
 * @mailto : d.qudretli@gmail.com
 * @since : 17.10.2023
 **/
public enum EKafkaTopic {
    WIKIMEDIA_RECENTCHANGE("wikimedia_recent_change");

    private final String data;

    public String getData() {
        return data;
    }

    EKafkaTopic(String data) {
        this.data = data;
    }
}
