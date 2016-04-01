package com.practical.billviewservice;

import java.util.logging.Logger;

public class BillViewService {
	private User myUser;
	private Plan myPlan;
	private Calculator myCalculator;
	
	private BillViewService(){
		
	}

	BillViewService(User user, Plan plan, Calculator caculator)
	{
		this.myUser= user;
		this.myCalculator= caculator;
		this.myPlan= plan;
	}
	
	public void showUser(){
		System.out.println("[User정보]");
		System.out.println("Name : "+this.myUser.getMyName());
		System.out.println("Plan : "+this.myUser.getMyPlantype());
		System.out.println("Minit Used : "+this.myUser.getMyinuteUsed());
		System.out.println("Line Number : "+this.myUser.getMyLineNum());
		
	}
	
	public void showPlan(){
		System.out.println("[Plan 정보]");
		System.out.println("Additional Line Rate : "+this.myPlan.getAdditional_Line_Rate());
		System.out.println("Basic Montly Rate : "+this.myPlan.getBasic_Montly_Rate());
		System.out.println("Family Discount Basic "+this.myPlan.getFamily_discount_Basic());
		System.out.println("Family Discount Basic"+this.myPlan.getFamily_discount_Basic_Rate());
		System.out.println("Minutes 대한 비용 "+this.myPlan.getIncluded_Minutes());
		System.out.println("추가라인에 대한 비용 "+this.myPlan.getRate_Per_Excess_Minute());
	}
	
	public void showCalculator(){
		Logger.getLogger("Calculator Message");
	}
	
	public void showTotalCalculator(){
		Logger.getLogger("Total Calculator Message");
	}
}
