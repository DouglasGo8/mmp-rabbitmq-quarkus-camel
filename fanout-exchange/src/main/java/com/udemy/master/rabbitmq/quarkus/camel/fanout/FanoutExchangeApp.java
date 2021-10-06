package com.udemy.master.rabbitmq.quarkus.camel.fanout;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

/**
 * @author dougdb
 */
@QuarkusMain
public class FanoutExchangeApp {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}
