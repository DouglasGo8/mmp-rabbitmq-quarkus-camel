package com.udemy.master.rabbitmq.quarkus.camel.topic.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class PictureConsumerRoute extends RouteBuilder {
  @Override
  public void configure() {

    from("{{my.rabbitmq.pic.image.consumer}}")
            .log("Consuming message ${body} from rmq.pic.image Queue - routingKey ${header.CamelRabbitmqRoutingKey}")
            .end();

    from("{{my.rabbitmq.pic.vector.consumer}}")
            .log("Consuming message ${body} from rmq.pic.vector Queue - routingKey ${header.CamelRabbitmqRoutingKey}")
            .end();

    from("{{my.rabbitmq.pic.filter.consumer}}")
            .log("Consuming message ${body} from rmq.pic.filter Queue - routingKey ${header.CamelRabbitmqRoutingKey}")
            .end();

    from("{{my.rabbitmq.pic.log.consumer}}")
            .log("Consuming message ${body} from rmq.pic.log Queue - routingKey ${header.CamelRabbitmqRoutingKey}")
            .end();
  }
}
