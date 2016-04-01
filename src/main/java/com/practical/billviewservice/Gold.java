package com.practical.billviewservice;

public class Gold implements Plan{
	private static final double basicMontlyRate = 49.95;
	private static final int includedMinutes = 1000;
	private static final double ratePerExcessMinute = 0.45;
	private static final double additionalLineRate = 14.50;
	private static final int familyDiscountBasic =3;
	private static final double familyDiscountBasicRate = 5.00;
	
	public double getBasicMontlyRate() {
		return basicMontlyRate;
	}	
	public int getIncludedMinutes() {
		return includedMinutes;
	}	
	public double getRatePerExcessMinute() {
		return ratePerExcessMinute;
	}	
	public double getAdditionalLineRate() {
		return additionalLineRate;
	}	
	public int getFamilyDiscountBasic() {
		return familyDiscountBasic;
	}	
	public double getFamilyDiscountBasicRate() {
		return familyDiscountBasicRate;
	}

}
