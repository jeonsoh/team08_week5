package com.practical.billviewservice;

/**
 * Hello world!
 *
 */
public class App {
	
	private App(){
		
	}
    public static void main( String[] args ){
    	Plan myPlan = new Gold();
    	User myUser = new User(myPlan,2000,3,"Hong-Gill-Dong");
    	
    	Calculator myCalculator = new Calculator(myUser,myPlan);
    	BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
    	billviewsystem.showUser();
    	billviewsystem.showPlan();
    	billviewsystem.showCalculator();
    	billviewsystem.showTotalCalculator();
    	
    }
}
