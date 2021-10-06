package com.udemy.master.rabbitmq.quarkus.camel.json.mediation.producer;

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
            .marshal().json(JsonLibrary.Jackson)
            .to("{{my.rabbitmq.fanout.queue.producer}}")
            .log(LoggingLevel.INFO, "Send message - ${body}")
            .end();
  }
}
