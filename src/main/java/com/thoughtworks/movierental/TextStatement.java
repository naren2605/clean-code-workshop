package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String customerTitle;
    private final List<Rental> rentals;
    public TextStatement(List<Rental> rentals, String customerTitle){
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


    public  String getText(){
        return getHeader()+getBody()+getFooter();
    }
    private int getFrequentRenterPoints() {
        return rentals.stream(). mapToInt(rental->rental.getFrequentRenterPoints()).sum();
    }

    private  double getTotalAmount() {
        return rentals.stream().mapToDouble(rental->rental.getRent()).sum();
    }


}
