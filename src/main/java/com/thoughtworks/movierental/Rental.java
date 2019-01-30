package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  double getRent() {
    double rent=0;
    switch (movie.getPriceCode()) {
      case Movie.REGULAR:
        rent += 2;
        if (daysRented > 2)
          rent += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        rent += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        rent += 1.5;
        if (daysRented > 3)
          rent += (daysRented - 3) * 1.5;
        break;
    }
    return rent;
  }

  int getFrequentRenterPoints() {
    // add frequent renter points
    // add bonus for a two day new release rental
    if (canEarnExtraPoints()){
        return 2;
    }else{
      return 1;
    }
  }

  private boolean canEarnExtraPoints() {
    return (getMovie().getPriceCode() == Movie.NEW_RELEASE)
        &&
        getDaysRented() > 1;
  }
}