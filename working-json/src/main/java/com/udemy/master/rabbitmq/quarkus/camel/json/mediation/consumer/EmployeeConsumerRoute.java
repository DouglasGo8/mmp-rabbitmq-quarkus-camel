package com.udemy.master.rabbitmq.quarkus.camel.json.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@NoArgsConstructor
@ApplicationScoped
public class EmployeeConsumerRoute extends RouteBuilder {
  @Override
  public void configure() {
    from("{{my.rabbitmq.fanout.queue.consumer}}")
            //.delay(ThreadLocalRandom.current().nextLong(3000))
            .choice()
              .when(jsonpath("$.[?(@.employeeSalary > 10000)]"))
                .throwException(new IllegalArgumentException("Salary cannot be upper than 10K"))
              .end()
            .log(LoggingLevel.INFO, "Receiving message - ${body}-${threadName} - at ${date:now}")
            .end();
  }
}
