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
		System.out.println("\n[User정보]");
		System.out.println("Name : "+this.myUser.getMyName());
		
		if(this.myUser.getMyPlantype() instanceof Gold){
			System.out.println("Plan : Gold");
		}else if(this.myUser.getMyPlantype() instanceof Silver){
			System.out.println("Plan : Silver");
		}
		
		System.out.println("Minit Used : "+this.myUser.getMyinuteUsed());
		System.out.println("Line Number : "+this.myUser.getMyLineNum());
		
	}
	
	public void showPlan(){
		System.out.println("\n[User의 Plan 정보]");
		System.out.println("Basic Montly Rate : "+this.myPlan.getBasic_Montly_Rate());
		System.out.println("Include Minutes : "+this.myPlan.getIncluded_Minutes());
		System.out.println("Additional Line Rate : "+this.myPlan.getAdditional_Line_Rate());
		System.out.println("Rate Per Excess Minute :"+this.myPlan.getRate_Per_Excess_Minute());
		System.out.println("Family Discount Basic : "+this.myPlan.getFamily_discount_Basic());
		System.out.println("Family Discount Basic Rate :"+this.myPlan.getFamily_discount_Basic_Rate());
	}
	
	public void showCalculator(){
		System.out.println("\n[사용자의 라인에 대한 비용 ]");
		System.out.println(this.myCalculator.calculateLineBill()+"\n");
		System.out.println("[사용자의 통화량에 대한 비용 ]");
		System.out.println(this.myCalculator.calculateMinutesBill()+"\n");
		System.out.println("[ 사용자의 비용 계산 과정 ]");
		System.out.println(this.myCalculator.processCalculator()+"\n");
	}
	
	public void showTotalCalculator(){
		System.out.println("\n[ 총 비용 ]");
		System.out.println(this.myCalculator.calculatorSum()+"\n");
	}
}
