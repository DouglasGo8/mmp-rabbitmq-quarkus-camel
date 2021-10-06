package com.udemy.master.rabbitmq.quarkus.camel.hello;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

/**
 * @author dougdb
 */
@QuarkusMain
public class HelloApp {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}
