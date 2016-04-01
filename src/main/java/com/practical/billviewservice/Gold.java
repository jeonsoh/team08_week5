package com.practical.billviewservice;

public class Gold implements Plan{
	private double basicMontlyRate = 49.95;
	private int includedMinutes = 1000;
	private double ratePerExcessMinute = 0.45;
	private double additionalLineRate = 14.50;
	private int familyDiscountBasic =3;
	private double familyDiscountBasicRate = 5.00;
	
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
