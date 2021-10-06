package com.udemy.master.rabbitmq.quarkus.camel.fanout.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class MarketingHrRoute extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("{{my.rabbitmq.marketing.hr.consumer}}")
            .log("Consuming message ${body} from Marketing Queue - ${threadName}")
            .end();
  }
}
