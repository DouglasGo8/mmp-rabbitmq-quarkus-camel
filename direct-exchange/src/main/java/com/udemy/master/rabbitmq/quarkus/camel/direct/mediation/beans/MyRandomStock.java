package com.udemy.master.rabbitmq.quarkus.camel.direct.mediation.beans;


import com.udemy.master.rabbitmq.quarkus.camel.direct.domain.Brand;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.NoArgsConstructor;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dougdb
 */
@Named
@NoArgsConstructor
@ApplicationScoped
@RegisterForReflection
public class MyRandomStock {


    @Handler
    public Brand myBrand() {
        final var stock = List.of(
                new Brand("apple", "IPhone 8 SE"),
                new Brand("android", "Samsung Galaxy S Plus"),
                new Brand("android", "Motorola G 400"),
                new Brand("apple", "IPhone 12 Max"),
                new Brand("android", "Samsung S21 Ultra 5G")
        );

        return stock.get(ThreadLocalRandom.current().nextInt(stock.size()));
    }
}
