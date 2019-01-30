package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement extends Statement {
    public HtmlStatement(List<Rental> rentals, String customerTitle) {
        super(rentals, customerTitle);
    }

    @Override
    protected String getBody() {
        String body="";
        for (Rental each : getRentals()) {
            body += "\t" + each.getMovie().getTitle() + "\t" +each.getRent()+ "<br/>";
        }
        return body;
    }

    @Override
    protected String getFooter() {
        String footer = "Amount owed is <b>" + getTotalAmount() + "</b><br/>";
        footer += "You earned <b>" + getFrequentRenterPoints()+"</b>"
                + " frequent renter points";
        return footer;
    }

    @Override
    protected String getHeader() {
         return "Rental Record for <b>" + getCustomerTitle() + "</b></br>";
    }



}
