package com.practical.billviewservice;

/**
 * Hello world!
 *
 */
public class App {
	private static int USEDMINIUTE = 2000;
	private static int LINENUMBER = 3;
	private App(){
		
	}
    public static void main( String[] args ){
    	
    	
    	Plan myPlan = new Gold();
    	User myUser = new User(myPlan,USEDMINIUTE,LINENUMBER,"Hong-Gill-Dong");
    	
    	Calculator myCalculator = new Calculator(myUser,myPlan);
    	BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
    	billviewsystem.showUser();
    	billviewsystem.showPlan();
    	billviewsystem.showCalculator();
    	billviewsystem.showTotalCalculator();
    	
    }
}
