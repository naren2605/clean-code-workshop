package com.thoughtworks.movierental;

import java.util.List;

public class HtmlStatement  {
    private final String customerTitle;
    private final List<Rental> rentals;
    public HtmlStatement(List<Rental> rentals, String customerTitle) {
        this.customerTitle=customerTitle;
        this.rentals=rentals;
    }

    private String getBody() {
        String body="";
        for (Rental each : rentals) {
            body += "\t" + each.getMovie().getTitle() + "\t" +each.getRent()+ "<br/>";
        }
        return body;
    }

    private String getFooter() {
        String footer = "Amount owed is <b>" + getTotalAmount() + "</b><br/>";
        footer += "You earned <b>" + getFrequentRenterPoints()+"</b>"
                + " frequent renter points";
        return footer;
    }

    private String getHeader() {
         return "Rental Record for <b>" + customerTitle + "</b><br/>";
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
