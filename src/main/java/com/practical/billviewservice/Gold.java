package com.practical.billviewservice;

public class Gold implements Plan{
	private  final double  BASICMONTLYRATE = 49.95;
	private  final int INCLUDEDMINUTES = 1000;
	private  final double RATEPEREXCESSMINUTE = 0.45;
	private  final double ADDITIONALLINERATE = 14.50;
	private  final int FAMILYDISCOUNTBASIC =3;
	private  final double FAMILYDISCOUNTBASICRATE = 5.00;
	
	public double getBasicMontlyRate() {
		return BASICMONTLYRATE;
	}	
	public int getIncludedMinutes() {
		return INCLUDEDMINUTES;
	}	
	public double getRatePerExcessMinute() {
		return RATEPEREXCESSMINUTE;
	}	
	public double getAdditionalLineRate() {
		return ADDITIONALLINERATE;
	}	
	public int getFamilyDiscountBasic() {
		return FAMILYDISCOUNTBASIC;
	}	
	public double getFamilyDiscountBasicRate() {
		return FAMILYDISCOUNTBASICRATE;
	}

}
