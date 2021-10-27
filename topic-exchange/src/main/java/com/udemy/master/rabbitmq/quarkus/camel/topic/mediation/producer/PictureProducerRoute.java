package com.udemy.master.rabbitmq.quarkus.camel.topic.mediation.producer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class PictureProducerRoute extends RouteBuilder {
  @Override
  public void configure() {


    from("timer://myPictureProducer?period=5s&fixedRate=true")
            .to("bean:myRandomPicture")
            .marshal().json(JsonLibrary.Jackson)
            .setHeader("CamelRabbitmqRoutingKey", jsonpath("$.source"))
            .to("{{my.rabbitmq.pic.producer}}")
            .log("Message produced")
            .end();

  }
}
