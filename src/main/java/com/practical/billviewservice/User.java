package com.practical.billviewservice;

public class User {

	private Plan myPlantype;
	private int myMiniUsed;
	private int myLineNum;
	private String myName;
	
	public User(Plan myPlan, int minitUsed, int lineNum, String name) {
		// TODO Auto-generated constructor stub
		this.myPlantype=myPlan;
		this.myMiniUsed=minitUsed;
		this.myLineNum=lineNum;
		this.myName=name;
	}

}
