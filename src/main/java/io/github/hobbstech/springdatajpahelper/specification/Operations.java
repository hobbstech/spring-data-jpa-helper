package io.github.hobbstech.springdatajpahelper.specification;

public enum Operations {

    GREATER_THAN(">"),
    LESS_THAN("<"),
    EQUALS(":");

    String sign;

    Operations(String sign) {
        this.sign = sign;
    }
}
