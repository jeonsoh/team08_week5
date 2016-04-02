package com.practical.billviewservice;

import java.util.logging.Logger;
import java.util.logging.Level;

public class BillViewService {
	private User myUser;
	private Plan myPlan;
	private Calculator myCalculator;
	private final Logger MYLOG = Logger.getLogger("My Logger");

	private BillViewService(){

	}

	BillViewService(User user, Plan plan, Calculator caculator){
		this.myUser= user;
		this.myCalculator= caculator;
		this.myPlan= plan;
	}

	public void showUser(){


		StringBuilder userbuf = new StringBuilder();
		userbuf.append("\n[User정보]\n");
		userbuf.append("Name : "+this.myUser.getMyName()+"\n");

		if(this.myUser.getMyPlantype() instanceof Gold){
			userbuf.append("Plan : Gold\n");
		}else if(this.myUser.getMyPlantype() instanceof Silver){
			userbuf.append("Plan : Silver\n");
		}

		userbuf.append("Minit Used : "+this.myUser.getMyinuteUsed()+"\n");
		userbuf.append("Line Number : "+this.myUser.getMyLineNum()+"\n");

		MYLOG.log(Level.INFO,userbuf.toString());

	}

	public void showPlan(){
		StringBuilder planbuf = new StringBuilder();
		planbuf.append("\n[User의 Plan 정보]\n");
		planbuf.append("Basic Montly Rate : "+this.myPlan.getBasicMontlyRate()+"\n");
		planbuf.append("Include Minutes : "+this.myPlan.getIncludedMinutes()+"\n");
		planbuf.append("Additional Line Rate : "+this.myPlan.getAdditionalLineRate()+"\n");
		planbuf.append("Rate Per Excess Minute :"+this.myPlan.getRatePerExcessMinute()+"\n");
		planbuf.append("Family Discount Basic : "+this.myPlan.getFamilyDiscountBasic()+"\n");
		planbuf.append("Family Discount Basic Rate :"+this.myPlan.getFamilyDiscountBasicRate()+"\n");

		MYLOG.log(Level.INFO, planbuf.toString());
	}

	public void showCalculator(){
		StringBuilder calbuf = new StringBuilder();
		calbuf.append("\n[사용자의 라인에 대한 비용 ]\n");
		calbuf.append(this.myCalculator.calculateLineBill()+"\n");
		calbuf.append("[사용자의 통화량에 대한 비용 ]\n");
		calbuf.append(this.myCalculator.calculateMinutesBill()+"\n");
		calbuf.append("[ 사용자의 비용 계산 과정 ]\n");
		calbuf.append(this.myCalculator.processCalculator()+"\n");

		MYLOG.log(Level.INFO, calbuf.toString());
	}


	public void showTotalCalculator(){
		StringBuilder totalbuf = new StringBuilder();
		totalbuf.append("\n[ 총 비용 ]\n");
		totalbuf.append(this.myCalculator.calculatorSum()+"\n");

		MYLOG.log(Level.INFO, totalbuf.toString());
	}
}
