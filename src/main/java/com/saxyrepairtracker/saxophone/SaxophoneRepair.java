package com.saxyrepairtracker.saxophone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.saxyrepairtracker"})
public class SaxophoneRepair {

  public static void main(String[] args) {
    SpringApplication.run(SaxophoneRepair.class, args);
  }
}
