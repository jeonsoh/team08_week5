package com.practical.team08_week4;

public class Calculator {

	private User myUser;
	private Plan myPlan;
	
	private Calculator(){
		
	}
	
	public Calculator(User _myUser, Plan _myPlan) {
		// TODO Auto-generated constructor stub
		this.myUser=myUser;
		this.myPlan=_myPlan;
	}
	
	public double calculatorSum(){
	
		return 1.0;
	}
	
	public String processCalculator(){
	
		return "Hello";
	}
	
	public double calculateMinutesBill()
	{
		return 2.0;
	}
	
	public double calculateLineBill(){
		
		return 3.0;
	}
	

}
