package com.thoughtworks.movierental;

import java.util.List;

public class TextStatement {
    private final String customerTitle;
    private final Rentals rentals;
    public TextStatement(Rentals rentals, String customerTitle){
        this.customerTitle=customerTitle;
        this.rentals=rentals;
    }

    protected String getFooter() {
        String footer = "Amount owed is " + rentals.getTotalAmount() + "\n";
        footer += "You earned " + rentals.getFrequentRenterPoints()
                + " frequent renter points";
        return footer;
    }
    protected String getHeader() {
        return "Rental Record for " + customerTitle + "\n";
    }

    protected String getBody() {
        String body="";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" +rental.getRent()+ "\n";
        }
        return body;
    }


    public  String getText(){
        return getHeader()+getBody()+getFooter();
    }



}
