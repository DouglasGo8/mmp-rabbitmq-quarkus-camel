package com.udemy.master.rabbitmq.quarkus.camel.retry.mech.mediaton.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@NoArgsConstructor
@ApplicationScoped
public class EmployeeConsumerRoute extends RouteBuilder {
  @Override
  public void configure() {

    onException(IllegalArgumentException.class)
            .maximumRedeliveries(1)
            .logExhausted(true)
            .logExhaustedMessageBody(true)
            .to("{{rbbtmq.dlq.producer}}");

    from("{{rbbtmq.q.images.consumer}}")
            //.delay(ThreadLocalRandom.current().nextLong(3000))
            .choice().when(jsonpath("$.[?(@.employeeSalary > 10000)]"))
              .throwException(new IllegalArgumentException("Salary cannot be over than 10K"))
            .otherwise()
              .log(LoggingLevel.INFO, "Receiving Images message - ${body}-${threadName} - at ${date:now}")
            .end();

    from("{{rbbtmq.q.vector.consumer}}")
            //.delay(ThreadLocalRandom.current().nextLong(3000))
            //.choice().when(jsonpath("$.[?(@.employeeSalary > 10000)]"))
            //   .throwException(new IllegalStateException("Salary cannot be over than 10K"))
            // .otherwise()
            .log(LoggingLevel.INFO, "Receiving Vector message - ${body}-${threadName} - at ${date:now}")
            .end();
  }
}
