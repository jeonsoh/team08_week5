package com.practical.billviewservice;

public class User {

	private String myPlantype;
	private int myMiniUsed;
	private int myLineNum;
	private String myName;
	
	public User(String plantype, int minitUsed, int lineNum, String name) {
		// TODO Auto-generated constructor stub
		this.myPlantype=plantype;
		this.myMiniUsed=minitUsed;
		this.myLineNum=lineNum;
		this.myName=name;
	}

	public String getMyPlantype() {
		return myPlantype;
	}

	public void setMyPlantype(String myPlantype) {
		this.myPlantype = myPlantype;
	}

	public int getMyMiniUsed() {
		return myMiniUsed;
	}

	public void setMyMiniUsed(int myMiniUsed) {
		this.myMiniUsed = myMiniUsed;
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
