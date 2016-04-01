package com.practical.billviewservice;

interface Plan {
	
	public double getBasic_Montly_Rate();
	public int getIncluded_Minutes();
	public double getRate_Per_Excess_Minute();
	public double getAdditional_Line_Rate();
	public int getFamily_discount_Basic();
	public double getFamily_discount_Basic_Rate();
}
