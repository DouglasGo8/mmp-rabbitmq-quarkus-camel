package com.udemy.master.rabbitmq.quarkus.camel.topic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author dougdb
 */
@Getter
@AllArgsConstructor
public class Picture {

  private final long size;
  //
  private final String name;
  private final String type;
  private final String source;
}
