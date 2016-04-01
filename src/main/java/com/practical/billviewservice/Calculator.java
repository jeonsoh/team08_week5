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
	
	public double calculateMinutesBill(){
		int useMinutes = myUser.getMyMiniUsed();
		
		double basicMonthlyRate = myPlan.Basic_Montly_Rate;
		int includedMinutes = myPlan.getIncluded_Minutes();
		double excessMinutesRate = myPlan.getRate_Per_Excess_Minute();
		
		if( useMinutes <= includedMinutes ){
			this.minutesBill = basicMonthlyRate;
		}
		else{
			int excess = useMinutes - includedMinutes;
			this.minutesBill = basicMonthlyRate + ( excess * excessMinutesRate );
		}
		
		return this.minutesBill;
	}
	
	public double calculateLineBill(){
		
		return 3.0;
	}
	

}
