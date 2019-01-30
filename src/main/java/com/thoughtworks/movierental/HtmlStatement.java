package com.thoughtworks.movierental;

public class HtmlStatement  {
    private final String customerTitle;
    private final Rentals rentals;
    public HtmlStatement(Rentals rentals, String customerTitle) {
        this.customerTitle=customerTitle;
        this.rentals=rentals;
    }

    private String getBody() {
        String body="";
        for (Rental rental : rentals) {
            body += "\t" + rental.getMovie().getTitle() + "\t" +rental.getRent()+ "<br/>";
        }
        return body;
    }

    private String getFooter() {
        String footer = "Amount owed is <b>" + rentals.getTotalAmount() + "</b><br/>";
        footer += "You earned <b>" + rentals.getFrequentRenterPoints()+"</b>"
                + " frequent renter points";
        return footer;
    }

    private String getHeader() {
         return "Rental Record for <b>" + customerTitle + "</b><br/>";
    }


    public  String getText(){
        return getHeader()+getBody()+getFooter();
    }


}
