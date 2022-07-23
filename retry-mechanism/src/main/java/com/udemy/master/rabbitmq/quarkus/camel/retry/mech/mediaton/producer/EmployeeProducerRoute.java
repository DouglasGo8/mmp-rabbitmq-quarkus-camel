package com.udemy.master.rabbitmq.quarkus.camel.retry.mech.mediaton.producer;

import lombok.NoArgsConstructor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;

@NoArgsConstructor
@ApplicationScoped
public class EmployeeProducerRoute extends RouteBuilder {

  @Override
  public void configure() {

    from("timer://myTimer?period=5s&fixedRate=true")
            .to("bean:employeeBean")
            //.setHeader("CamelRabbitmqRequeue", constant(false))
            .marshal().json(JsonLibrary.Jackson)
            .setHeader("CamelRabbitmqRoutingKey", jsonpath("$.image"))
            .to("{{rbbtmq.q.producer}}")
            //.log(LoggingLevel.INFO, "Send message - ${body}")
            .end();
  }
}
