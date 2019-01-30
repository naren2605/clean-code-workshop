package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {


    public int getFrequentRenterPoints() {
        return this.stream(). mapToInt(rental->rental.getFrequentRenterPoints()).sum();
    }

    public  double getTotalAmount() {
        return this.stream().mapToDouble(rental->rental.getRent()).sum();
    }
}
