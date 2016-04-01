package com.practical.billviewservice;

public class Silver implements Plan{
	private static final double basicMontlyRate = 29.95;
	private static final int includedMinutes = 500;
	private static final double ratePerExcessMinute = 0.54;
	private static final double additionalLineRate = 21.50;
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
