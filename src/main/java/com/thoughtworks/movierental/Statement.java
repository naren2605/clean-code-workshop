package com.thoughtworks.movierental;

import java.util.List;

public class Statement {
    private final String customerTitle;
    private final List<Rental> rentals;
    public Statement(List<Rental> rentals,String customerTitle){
        this.customerTitle=customerTitle;
        this.rentals=rentals;
    }

    protected String getFooter() {
        String footer = "Amount owed is " + getTotalAmount() + "\n";
        footer += "You earned " + getFrequentRenterPoints()
                + " frequent renter points";
        return footer;
    }
    protected String getHeader() {
        return "Rental Record for " + customerTitle + "\n";
    }

    protected String getBody() {
        String body="";
        for (Rental each : rentals) {
            body += "\t" + each.getMovie().getTitle() + "\t" +each.getRent()+ "\n";
        }
        return body;
    }


    protected final String getText(){
        return getHeader()+getBody()+getFooter();
    }
    protected final int getFrequentRenterPoints() {
        return rentals.stream(). mapToInt(rental->rental.getFrequentRenterPoints()).sum();
    }

    protected final double getTotalAmount() {
        return rentals.stream().mapToDouble(rental->rental.getRent()).sum();
    }

    protected final List<Rental> getRentals() {
        return rentals;
    }

    protected final String getCustomerTitle() {
        return customerTitle;
    }
}
