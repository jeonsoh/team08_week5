package com.practical.billviewservice;

/**
 * Hello world!
 *
 */
public class App {
	
	private App(){
		
	}
    public static void main( String[] args ){
    
    	User myUser = new User("Gold",2000,3,"Gill-Dong");
        Plan myPlan = new Gold();
    	Calculator myCalculator = new Calculator(myUser,myPlan); 	
    	BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
    	billviewsystem.showUser();
    	billviewsystem.showPlan();
    	billviewsystem.showCalculator();
    	billviewsystem.showTotalCalculator();
    	
    }
}
