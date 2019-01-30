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
    String header = getHeader();
    String body="";
    for (Rental each : rentals) {
      double thisAmount = 0;
      //determine amounts for each line
      thisAmount = thisAmount+ each.getRent();
      frequentRenterPoints = frequentRenterPoints+each.getFrequentRenterPoints();
      //show figures for this rental
      body += getFormattedRentForDisplay(each, thisAmount);
      totalAmount += thisAmount;
    }

    //add footer lines result
    String footer=getFooter(totalAmount, frequentRenterPoints);
    String result = header+body+footer;
    return result;
  }

  private String getFormattedRentForDisplay(Rental each, double thisAmount) {
    return "\t" + each.getMovie().getTitle() + "\t" +
        String.valueOf(thisAmount) + "\n";
  }

  private String getFooter(double totalAmount, int frequentRenterPoints) {
    String footer = "Amount owed is " + String.valueOf(totalAmount) + "\n";
    footer += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return footer;
  }

  private String getHeader() {
    return "Rental Record for " + getName() + "\n";
  }

}

