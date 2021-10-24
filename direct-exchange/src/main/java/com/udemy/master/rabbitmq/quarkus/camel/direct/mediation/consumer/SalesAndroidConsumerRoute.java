package com.udemy.master.rabbitmq.quarkus.camel.direct.mediation.consumer;

import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class SalesAndroidConsumerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("{{my.rabbitmq.sales.android.consumer}}")
                .log("Consuming message ${body} from Accounting Queue - ${threadName} - " +
                        "and ${header.CamelRabbitmqRoutingKey} routingKey")
                .end();

    }
}
