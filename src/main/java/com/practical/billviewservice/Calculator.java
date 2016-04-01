package com.practical.billviewservice;

public class Calculator {

	private User myUser;
	private Plan myPlan;
	private double total;
	private double lineBill;
	private double minutesBill;
	private int familyDiscountMyLine;
	private int addedMyLine;
	
	private Calculator(){
		
	}
	
	public Calculator(User user, Plan plan) {
		this.myUser=user;
		this.myPlan=plan;
		if(user.getMyLineNum() == 1){
			this.familyDiscountMyLine = 0;
			this.addedMyLine = 0;
		}
		else if(user.getMyLineNum() <= plan.getFamily_discount_Basic()){
			this.familyDiscountMyLine = 0;
			this.addedMyLine = user.getMyLineNum() -1;
		}
		else if(user.getMyLineNum() > plan.getFamily_discount_Basic()){
			this.familyDiscountMyLine = user.getMyLineNum() - plan.getFamily_discount_Basic();
			this.addedMyLine = user.getMyLineNum() - this.familyDiscountMyLine - 1;
		}
		 
	}
	
	public double calculatorSum(){
	
		this.total = this.myPlan.getBasic_Montly_Rate() + lineBill + minutesBill;
		return total;

	}
	
	public String processCalculator(){
		StringBuffer buf = new StringBuffer();
		buf.append("계산과정 :");
		int lineNum = this.myUser.getMyLineNum() ;
		
		if(lineNum > 0){
			buf.append("기본비용: "+this.myPlan.getBasic_Montly_Rate());
		} // 기본 비용 계산
		
		if(addedMyLine > 0){
			buf.append(" + 추가라인비용("+addedMyLine+"*"+this.myPlan.getAdditional_Line_Rate()+")");
		} // 가족 할인이 적용되지 않은 추가 라인 비용 계산
		
		if(familyDiscountMyLine > 0){
			buf.append(" + 가족 할인 라인 비용(" + familyDiscountMyLine +"*"+ this.myPlan.getFamily_discount_Basic_Rate() + ")");
		} // 가족 할인이 적용된 추가 라인 비용 계산
		
		if(this.myUser.getMyinuteUsed() > this.myPlan.getIncluded_Minutes()){
			int excess = this.myUser.getMyinuteUsed() - this.myPlan.getIncluded_Minutes();
			buf.append(" + 초과 시간에 대한 비용(" + excess +"*" + this.myPlan.getRate_Per_Excess_Minute()+")");
		} // 초과 시간에 대한 비용

		buf.append(" = "+this.calculatorSum());	
		
		return buf.toString();
	}
	
	public double calculateMinutesBill(){
		int useMinutes = myUser.getMyinuteUsed();
		
		int includedMinutes = myPlan.getIncluded_Minutes();
		double excessMinutesRate = myPlan.getRate_Per_Excess_Minute();
		
		if( useMinutes <= includedMinutes ){
			this.minutesBill = 0;
		}
		else{
			int excess = useMinutes - includedMinutes;
			this.minutesBill = excess * excessMinutesRate;
		}
		
		return this.minutesBill;
	}
	
	public double calculateLineBill(){
		double additionallinerate = myPlan.getAdditional_Line_Rate();
		double familydiscountrate = myPlan.getFamily_discount_Basic_Rate();
		
		lineBill = (this.addedMyLine * additionallinerate) + (this.familyDiscountMyLine * familydiscountrate);
		
		return lineBill;
	}
	

}
