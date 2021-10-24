package com.udemy.master.rabbitmq.quarkus.camel.direct.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dougdb
 */
@Getter
@AllArgsConstructor
public class Brand {
    private final String kind;
    private final String model;
}
