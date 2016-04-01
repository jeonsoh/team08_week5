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
		int useMinutes = myUser.getMyinuteUsed();
		
		double basicMonthlyRate = myPlan.getBasic_Montly_Rate();
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
		int userline = myUser.getMyLineNum();
		int discountbasic = myPlan.getFamily_discount_Basic();
		double basicrate = myPlan.getBasic_Montly_Rate();
		double additionallinerate = myPlan.getAdditional_Line_Rate();
		double familydiscountrate = myPlan.getFamily_discount_Basic_Rate();
		
		if(userline == 1)
			lineBill = basicrate;
		// 라인이 1개일 경우
		else if(userline > 1 && userline <= discountbasic)
			lineBill = basicrate 
						+ ((userline-1)*additionallinerate);
		// 라인이 추가로 있지만 가족 할인에 포함되지 않을 경우
		else
			lineBill = basicrate
						+ ((discountbasic-1)*additionallinerate)
						+ ((userline - discountbasic)*familydiscountrate);
		// 라인이 가족 할인에 포함될 정도로 있는 경우
		
		return lineBill;
	}
	

}
