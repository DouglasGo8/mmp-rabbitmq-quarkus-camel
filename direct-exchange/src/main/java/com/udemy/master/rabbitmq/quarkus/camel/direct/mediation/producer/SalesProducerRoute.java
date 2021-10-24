package com.udemy.master.rabbitmq.quarkus.camel.direct.mediation.producer;


import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import javax.enterprise.context.ApplicationScoped;


/**
 * @author dougdb
 */
@NoArgsConstructor
@ApplicationScoped
public class SalesProducerRoute extends RouteBuilder {


    @Override
    public void configure() {


        from("timer://mySalesProducer?period=5s&fixedRate=true")
                .to("bean:myRandomStock")
                .marshal().json(JsonLibrary.Jackson)
                .setHeader("CamelRabbitmqRoutingKey", jsonpath("$.kind"))
                .to("{{my.rabbitmq.sales.producer}}")
                .log("Message produced")
                .end();

    }
}
