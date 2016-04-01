package com.practical.billviewservice;

public class Calculator {

	private User myUser;
	private Plan myPlan;
	private double total;
	private double lineBill;
	private double minutesBill;
	private int family_Discout_Myline;
	private int added_myline;
	
	private Calculator(){
		
	}
	
	public Calculator(User user, Plan plan) {
		// TODO Auto-generated constructor stub
		this.myUser=user;
		this.myPlan=plan;
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
