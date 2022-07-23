package com.udemy.master.rabbitmq.quarkus.camel.hnd.errors;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.apache.camel.quarkus.main.CamelMainApplication;

@QuarkusMain
public class HandleErrorDLQApp {
  public static void main(String... args) {
    Quarkus.run(CamelMainApplication.class, args);
  }
}
