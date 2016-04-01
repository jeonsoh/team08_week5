package com.practical.billviewservice;

public class Silver implements Plan{
	private static final double BASICMONTLYRATE = 29.95;
	private static final int INCLUDEDMINUTES = 500;
	private static final double RATEPEREXCESSMINUTE = 0.54;
	private static final double ADDITIONALLINERATE = 21.50;
	private static final int FAMILYDISCOUNTBASIC =3;
	private static final double FAMILYDISCOUNTBASICRATE = 5.00;
	
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
