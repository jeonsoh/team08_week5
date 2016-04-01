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
	public int getIncluded_Minutes() {
		return Included_Minutes;
	}	
	public double getRate_Per_Excess_Minute() {
		return Rate_Per_Excess_Minute;
	}	
	public double getAdditional_Line_Rate() {
		return Additional_Line_Rate;
	}	
	public int getFamily_discount_Basic() {
		return Family_discount_Basic;
	}	
	public double getFamily_discount_Basic_Rate() {
		return Family_discount_Basic_Rate;
	}
	
}
