package com.thoughtworks.movierental;

import java.util.List;

public class StatementGenerator {

    private static StatementGenerator statementGenerator;
    private StatementGenerator(){}

    public TextStatement getTextStatement(String customerTitle, Rentals rentals) {
        return new TextStatement(rentals, customerTitle);
    }

    public HtmlStatement getHtmlStatement(String customerTitle, Rentals rentals) {
        return new HtmlStatement(rentals, customerTitle);
    }

    public static StatementGenerator getInstance(){
        if(statementGenerator==null){
            statementGenerator=new StatementGenerator();
        }
        return statementGenerator;
    }


}
