package com.practical.billviewservice;

public class User {

	private Plan myPlantype;
	private int myMinitUsed;
	private int myLineNum;
	private String myName;
	
	public User(Plan myPlan, int minitUsed, int lineNum, String name) {
		// TODO Auto-generated constructor stub
		this.myPlantype=myPlan;
		this.myMinitUsed=minitUsed;
		this.myLineNum=lineNum;
		this.myName=name;
	}

	public Plan getMyPlantype() {
		return myPlantype;
	}

	public void setMyPlantype(Plan myPlantype) {
		this.myPlantype = myPlantype;
	}

	public int getMyinuteUsed() {
		return myMinitUsed;
	}

	public void setMyMiniUsed(int myMiniUsed) {
		this.myMinitUsed = myMiniUsed;
	}

	public int getMyLineNum() {
		return myLineNum;
	}

	public void setMyLineNum(int myLineNum) {
		this.myLineNum = myLineNum;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

}
