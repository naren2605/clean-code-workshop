package com.thoughtworks.movierental;

import java.util.List;

public class StatementGenerator {

    private static StatementGenerator statementGenerator;
    private StatementGenerator(){}

    public Statement getTextStatement(String customerTitle, List<Rental> rentals) {
        return new Statement(rentals, customerTitle);
    }

    public Statement getHtmlStatement(String customerTitle, List<Rental> rentals) {
        return new HtmlStatement(rentals, customerTitle);
    }

    public static StatementGenerator getInstance(){
        if(statementGenerator==null){
            statementGenerator=new StatementGenerator();
        }
        return statementGenerator;
    }


}
