package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {


    @Test
    public void test1SingleRentalWithRegularPriceCodeAndDaysAreMoreThanTwoDays() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("",Movie.REGULAR),3));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", customer.statement());

    }

    @Test
    public void test2SingleRentalWithNewReleasePriceCode() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 1));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void test3SingleRentalWithChildrensPriceCodeAndDaysAreMoreThanThreeDays() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("", Movie.CHILDRENS), 4));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void test4SingleRentalFrequentRenterPointsWithNewReleasePriceCode() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 2));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    public void test5WithMultipleRentalsAndAllPricingCodeFlows_Test1ToTest4() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("",Movie.REGULAR),3));
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 1));
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 2));
        customer.addRental(getRental(getMovie("", Movie.CHILDRENS), 4));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t3.5\n" +
                "\t\t3.0\n" +
                "\t\t6.0\n" +
                "\t\t3.0\n" +
                "Amount owed is 15.5\n" +
                "You earned 5 frequent renter points", customer.statement());
    }
    @Test
    public void test5IncludeUnavailablePricingCode() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("", 20), 2));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void test6WithMultipleRentalsAndAllPricingCodeFlowsIncludingUnavailablePriceCode_Test1ToTest5() {
        Customer customer = getCustomer("");
        customer.addRental(getRental(getMovie("",Movie.REGULAR),3));
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 1));
        customer.addRental(getRental(getMovie("", Movie.NEW_RELEASE), 2));
        customer.addRental(getRental(getMovie("", Movie.CHILDRENS), 4));
        customer.addRental(getRental(getMovie("", 20), 2));
        Assert.assertEquals("Rental Record for \n" +
                "\t\t3.5\n" +
                "\t\t3.0\n" +
                "\t\t6.0\n" +
                "\t\t3.0\n" +
                "\t\t0.0\n" +
                "Amount owed is 15.5\n" +
                "You earned 6 frequent renter points", customer.statement());
    }

    private Customer getCustomer(String title) {
        return new Customer(title);
    }
    private Rental getRental(Movie movie,int daysRented){
        return new Rental(movie,daysRented);
    }
    private Movie getMovie(String title,int priceCode){
        return new Movie(title,priceCode);
    }


}