package com.practical.billviewservice;

public class Silver implements Plan{
	private double basicMontlyRate = 29.95;
	private int includedMinutes = 500;
	private double ratePerExcessMinute = 0.54;
	private double additionalLineRate = 21.50;
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
