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
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";
    for (Rental each : rentals) {
      double thisAmount = 0;
      //determine amounts for each line
      thisAmount = thisAmount+ getRent(each);
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
          &&
          each.getDaysRented() > 1) frequentRenterPoints++;

      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }

  private double getRent(Rental each) {
    double rent=0;
    switch (each.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        rent += 2;
        if (each.getDaysRented() > 2)
          rent += (each.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        rent += each.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        rent += 1.5;
        if (each.getDaysRented() > 3)
          rent += (each.getDaysRented() - 3) * 1.5;
        break;
    }
    return rent;
  }
}

