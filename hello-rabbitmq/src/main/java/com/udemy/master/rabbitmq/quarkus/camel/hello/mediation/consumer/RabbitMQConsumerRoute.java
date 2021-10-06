package com.udemy.master.rabbitmq.quarkus.camel.hello.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class RabbitMQConsumerRoute extends RouteBuilder {

  @Override
  public void configure() {
    from("{{my.rabbitmq.fanout.queue.consumer}}")
            //.delay(ThreadLocalRandom.current().nextLong(3000))
            .log(LoggingLevel.INFO, "Receiving message - ${body}-${threadName} - at ${date:now}")
            .end();
  }
}
