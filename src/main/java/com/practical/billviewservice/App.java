package com.practical.billviewservice;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Hello world!
 *
 */
public class App {
    
    private static final int USEDMINIUTE = 2000;
    private static final int LINENUMBER = 3;

    private App() {

    }

    public static void main(String[] args) {
        
       
        Plan myPlan = new Gold();
        User myUser = new User(myPlan, USEDMINIUTE, LINENUMBER, "Hong-Gill-Dong");
        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();

    }
}
