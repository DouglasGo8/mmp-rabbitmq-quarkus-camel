package com.udemy.master.rabbitmq.quarkus.camel.fanout.mediation.bean;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.NoArgsConstructor;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dougdb
 */
@Named
@NoArgsConstructor
@ApplicationScoped
@RegisterForReflection
public class MyQuotes {

  @Handler
  public String myAccountingHrQuotes() {
    var quotes = new String[]{
            "Stay Hungry. Stay Foolish; Steve Jobs",
            "Good Artists Copy, Great Artists Steal; Pablo Picasso",
            "Argue with idiots, and you become an idiot; Paul Graham",
            "Be yourself; everyone else is already taken; Oscar Wilde",
            "Simplicity is the ultimate sophistication; Leonardo Da Vinci"
    };

    return quotes[ThreadLocalRandom.current().nextInt(1,quotes.length - 1)];
  }
}
