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
		Logger.getLogger("User Message");
	}
	
	public void showPlan(){
		Logger.getLogger("Plan Message");
	}
	
	public void showCalculator(){
		Logger.getLogger("Calculator Message");
	}
	
	public void showTotalCalculator(){
		Logger.getLogger("Total Calculator Message");
	}
}
