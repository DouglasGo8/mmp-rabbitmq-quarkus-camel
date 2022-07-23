package com.udemy.master.rabbitmq.quarkus.camel.hnd.errors.beans;

import com.udemy.master.rabbitmq.quarkus.camel.hnd.errors.domain.Employee;
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

    return new Employee("Joseph",
            ThreadLocalRandom.current().nextDouble(5000, 20_000),
            hireDate,
            "IT Machine Leaning",
            "NR12003");
  }
}
