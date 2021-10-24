package com.udemy.master.rabbitmq.quarkus.camel.direct.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class SalesAppleConsumerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("{{my.rabbitmq.sales.apple.consumer}}")
                .log("Consuming message ${body} from Accounting Queue - ${threadName} - " +
                        "and ${header.CamelRabbitmqRoutingKey} routingKey")
                .end();

    }
}
