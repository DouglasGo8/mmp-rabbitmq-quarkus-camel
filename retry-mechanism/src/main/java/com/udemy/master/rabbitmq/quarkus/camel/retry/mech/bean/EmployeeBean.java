package com.udemy.master.rabbitmq.quarkus.camel.retry.mech.bean;

import com.udemy.master.rabbitmq.quarkus.camel.retry.mech.domain.Employee;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.NoArgsConstructor;
import org.apache.camel.Handler;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author dougdb
 */
@Named
@NoArgsConstructor
@ApplicationScoped
@RegisterForReflection
public class EmployeeBean {

  @Handler
  public Employee makeAnEmployee() {

    final var hireDate = LocalDate.of(2012, 6, 14).toString();
    final var images = new String[]{"png", "jpg", "svg"};

    return new Employee(
            images[ThreadLocalRandom.current().nextInt(images.length)],
            "Joseph",
            ThreadLocalRandom.current().nextDouble(5000, 20_000),
            hireDate,
            "IT Machine Leaning",
            "NR12003");
  }
}
