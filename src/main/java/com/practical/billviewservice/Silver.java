package com.practical.billviewservice;

public class Silver extends Plan{
	private double Basic_Montly_Rate = 29.95;
	private int Included_Minutes = 500;
	private double Rate_Per_Excess_Minute = 0.54;
	private double Additional_Line_Rate = 21.50;
	private int Family_discount_Basic =3;
	private double Family_discount_Basic_Rate = 5.00;
	
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
