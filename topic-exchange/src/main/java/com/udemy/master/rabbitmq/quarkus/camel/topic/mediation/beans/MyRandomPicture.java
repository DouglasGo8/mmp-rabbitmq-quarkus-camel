package com.udemy.master.rabbitmq.quarkus.camel.topic.mediation.beans;


import com.udemy.master.rabbitmq.quarkus.camel.topic.domain.Picture;
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
public class MyRandomPicture {


  @Handler
  public Picture produceKindOfPictures() {

    final var images = List.of(
            new Picture(87745, "My Pic 1", "jpg", "mobile.large.jpg"),
            new Picture(34000, "My Pic 2", "png", "web.large.png"),
            new Picture(12000, "My Pic 3", "svg", "mobile.large.svg"),
            new Picture(3000, "My Pic 4", "svg", "web.small.svg"),
            new Picture(120, "My Pic 5", "jpg", "mobile.small.jpg"),
            new Picture(65844, "My Pic 6", "png", "web.large.png"),
            new Picture(3544, "My Pic 7", "svg", "mobile.small.svg"),
            new Picture(9874, "My Pic 8", "png", "mobile.large.png"),
            new Picture(12, "My Pic 9", "svg", "web.small.svg"),
            new Picture(554, "My Pic 10", "jpg", "web.small.jpg"));


    return images.get(ThreadLocalRandom.current().nextInt(images.size()));

  }

}
