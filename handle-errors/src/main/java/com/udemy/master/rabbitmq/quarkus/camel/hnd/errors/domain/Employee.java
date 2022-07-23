package com.udemy.master.rabbitmq.quarkus.camel.hnd.errors.domain;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@RegisterForReflection
public class Employee implements Serializable {
  private final String employeeName;
  private final double employeeSalary;
  private final String employeeHireDate;
  private final String employeeDepartment;
  private final String employeeIdentifier;
}
