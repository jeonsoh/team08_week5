package com.practical.billviewservice;

public class Calculator {

	private User myUser;
	private Plan myPlan;
	private double total;
	private double lineBill;
	private double minutesBill;
	private int familyDicountMyLine;
	private int addedMyLine;
	
	
	
	private Calculator(){
		
	}
	
	public Calculator(User user, Plan plan) {
		this.myUser=user;
		this.myPlan=plan;
	}
	
	public double calculatorSum(){
	
		this.total = lineBill+minutesBill;
		return total;

	}
	
	public String processCalculator(){
		StringBuffer buf = new StringBuffer();
		buf.append("계산과정 :");
		int lineNum =this.myUser.getMyLineNum() ;
		if(lineNum > 4){
			this.familyDicountMyLine=lineNum -3;
		}else if(lineNum > 1){
			this.addedMyLine = lineNum-1;
		}
		if(this.myPlan instanceof Gold){
			
			if(lineNum >0)
				buf.append("기본비용:49.95 ");
			else
				return "0";
			
			if(lineNum> 1){
				buf.append(" + 추가라인비용("+addedMyLine+"*14.5)");
			}

		}else if(this.myPlan instanceof Silver){
			if(lineNum >0)
				buf.append("기본비용:29.95 ");
			else
				return "0";
			
			if(lineNum> 1){
				buf.append(" + 추가라인비용("+addedMyLine+"*21.50)");
			}
		}
		
		if(lineNum >= 4){
			buf.append(" + 패밀리디스카운트라인비용(5.00*"+familyDicountMyLine+")");
		}
		buf.append(" = "+this.calculatorSum());	
	
	
		return buf.toString();
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
