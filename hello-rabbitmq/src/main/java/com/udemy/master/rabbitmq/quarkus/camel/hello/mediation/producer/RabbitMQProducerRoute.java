package com.udemy.master.rabbitmq.quarkus.camel.hello.mediation.producer;

import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class RabbitMQProducerRoute extends RouteBuilder {
  @Override
  public void configure() {

    from("timer://myTimer?period=5s&fixedRate=true")
            .transform(constant("RabbitMQ with Quarkus/Camel Rocks!!"))
            .to("{{my.rabbitmq.fanout.queue.producer}}")
            .log(LoggingLevel.INFO, "Send message - ${body}")
            .end();
  }
}
