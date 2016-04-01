package com.practical.billviewservice;

import java.util.logging.Logger;
import java.util.logging.Level;

public class BillViewService {
	private User myUser;
	private Plan myPlan;
	private Calculator myCalculator;
	private Logger log;
	
	private BillViewService(){
		
	}

	BillViewService(User user, Plan plan, Calculator caculator)
	{
		this.myUser= user;
		this.myCalculator= caculator;
		this.myPlan= plan;
	}
	
	public void showUser(){
		log = Logger.getLogger("My Logger");
		log.log(Level.INFO, "\n[User정보]");
		log.log(Level.INFO, "Name : "+this.myUser.getMyName());
		
		if(this.myUser.getMyPlantype() instanceof Gold){
			log.log(Level.INFO, "Plan : Gold");
		}else if(this.myUser.getMyPlantype() instanceof Silver){
			log.log(Level.INFO, "Plan : Silver");
		}
		
		log.log(Level.INFO, "Minit Used : "+this.myUser.getMyinuteUsed());
		log.log(Level.INFO, "Line Number : "+this.myUser.getMyLineNum());
		
	}
	
	public void showPlan(){
		StringBuffer planbuf = new StringBuffer();
		planbuf.append("\n[User의 Plan 정보]\n");
		planbuf.append("Basic Montly Rate : "+this.myPlan.getBasic_Montly_Rate()+"\n");
		planbuf.append("Include Minutes : "+this.myPlan.getIncluded_Minutes()+"\n");
		planbuf.append("Additional Line Rate : "+this.myPlan.getAdditional_Line_Rate()+"\n");
		planbuf.append("Rate Per Excess Minute :"+this.myPlan.getRate_Per_Excess_Minute()+"\n");
		planbuf.append("Family Discount Basic : "+this.myPlan.getFamily_discount_Basic()+"\n");
		planbuf.append("Family Discount Basic Rate :"+this.myPlan.getFamily_discount_Basic_Rate()+"\n");
		
		log.log(Level.INFO, planbuf.toString());
	}
	
	public void showCalculator(){
		log.log(Level.INFO, "\n[사용자의 라인에 대한 비용 ]");
		log.log(Level.INFO, this.myCalculator.calculateLineBill()+"\n");
		log.log(Level.INFO, "[사용자의 통화량에 대한 비용 ]");
		log.log(Level.INFO, this.myCalculator.calculateMinutesBill()+"\n");
		log.log(Level.INFO, "[ 사용자의 비용 계산 과정 ]");
		log.log(Level.INFO, this.myCalculator.processCalculator()+"\n");
	}
	
	public void showTotalCalculator(){
		log.log(Level.INFO, "\n[ 총 비용 ]");
		log.log(Level.INFO, this.myCalculator.calculatorSum()+"\n");
	}
}
