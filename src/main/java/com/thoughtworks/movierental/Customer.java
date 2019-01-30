package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    return StatementGenerator.getInstance().getTextStatement(getName(),rentals).getText();
  }

  public String htmlStatement() {
    return StatementGenerator.getInstance().getHtmlStatement(getName(),rentals).getText();
  }

}

