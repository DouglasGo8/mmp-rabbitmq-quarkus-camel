package com.udemy.master.rabbitmq.quarkus.camel.fanout.mediation.producer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@ApplicationScoped
@NoArgsConstructor
public class AccountingMarketingHrRoute extends RouteBuilder {
  @Override
  public void configure() {

    from("timer://myAccountingHRTimer?period=5s&fixedRate=true")
            .to("bean:myQuotes")
            .to("{{my.rabbitmq.hr.producer}}")
            .log("${body}")
            .end();
  }


}
