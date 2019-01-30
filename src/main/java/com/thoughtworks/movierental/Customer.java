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

    String header = getHeader();
    String body="";
    double totalAmount = getTotalAmount();
    int frequentRenterPoints = getFrequentRenterPoints();
    body = getBody();
    //add footer lines result
    String footer=getFooter(totalAmount, frequentRenterPoints);
    String result = header+body+footer;
    return result;
  }

  private String getBody() {
    String body="";
    for (Rental each : rentals) {
      body += getFormattedRentForDisplay(each);
    }
    return body;
  }

  private int getFrequentRenterPoints() {
    return rentals.stream(). mapToInt(rental->rental.getFrequentRenterPoints()).sum();
  }

  private double getTotalAmount() {
    return rentals.stream().mapToDouble(rental->rental.getRent()).sum();
  }

  private String getFormattedRentForDisplay(Rental each) {
    return "\t" + each.getMovie().getTitle() + "\t" +
        String.valueOf(each.getRent()) + "\n";
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

