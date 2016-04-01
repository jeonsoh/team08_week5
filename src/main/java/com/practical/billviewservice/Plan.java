package com.practical.billviewservice;

public class Plan {

	protected double Basic_Montly_Rate;
	protected int Included_Minutes;
	protected double Rate_Per_Excess_Minute;
	protected double Additional_Line_Rate;
	protected int Family_discount_Basic;
	protected double Family_discount_Basic_Rate;
	
	public double getBasic_Montly_Rate() {
		return Basic_Montly_Rate;
	}
	public void setBasic_Montly_Rate(double basic_Montly_Rate) {
		Basic_Montly_Rate = basic_Montly_Rate;
	}
	public int getIncluded_Minutes() {
		return Included_Minutes;
	}
	public void setIncluded_Minutes(int included_Minutes) {
		Included_Minutes = included_Minutes;
	}
	public double getRate_Per_Excess_Minute() {
		return Rate_Per_Excess_Minute;
	}
	public void setRate_Per_Excess_Minute(double rate_Per_Excess_Minute) {
		Rate_Per_Excess_Minute = rate_Per_Excess_Minute;
	}
	public double getAdditional_Line_Rate() {
		return Additional_Line_Rate;
	}
	public void setAdditional_Line_Rate(double additional_Line_Rate) {
		Additional_Line_Rate = additional_Line_Rate;
	}
	public int getFamily_discount_Basic() {
		return Family_discount_Basic;
	}
	public void setFamily_discount_Basic(int family_discount_Basic) {
		Family_discount_Basic = family_discount_Basic;
	}
	public double getFamily_discount_Basic_Rate() {
		return Family_discount_Basic_Rate;
	}
	public void setFamily_discount_Basic_Rate(double family_discount_Basic_Rate) {
		Family_discount_Basic_Rate = family_discount_Basic_Rate;
	}
}
