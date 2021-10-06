package com.udemy.master.rabbitmq.quarkus.camel.fanout.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class AccountingHrRoute extends RouteBuilder {
  @Override
  public void configure() {

    from("{{my.rabbitmq.accounting.hr.consumer}}")
            .log("Consuming message ${body} from Accounting Queue - ${threadName}")
            .end();
  }
}
