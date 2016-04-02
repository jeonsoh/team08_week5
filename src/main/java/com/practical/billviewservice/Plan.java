package com.practical.billviewservice;

interface Plan {
	public double getBasicMontlyRate();

	public int getIncludedMinutes();

	public double getRatePerExcessMinute();

	public double getAdditionalLineRate();

	public int getFamilyDiscountBasic();

	public double getFamilyDiscountBasicRate();
}
