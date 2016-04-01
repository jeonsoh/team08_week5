package com.practical.billviewservice;

public class Silver implements Plan{
	private static final double BASICMONTLYRATE2 = 29.95;
	private static final int INCLUDEDMINUTES2 = 500;
	private static final double RATEPEREXCESSMINUTE2 = 0.54;
	private static final double ADDITIONALLINERATE2 = 21.50;
	private static final int FAMILYDISCOUNTBASIC2 =3;
	private static final double FAMILYDISCOUNTBASICRATE2 = 5.00;
	
	public double getBasicMontlyRate() {
		return BASICMONTLYRATE2;
	}	
	public int getIncludedMinutes() {
		return INCLUDEDMINUTES2;
	}	
	public double getRatePerExcessMinute() {
		return RATEPEREXCESSMINUTE2;
	}	
	public double getAdditionalLineRate() {
		return ADDITIONALLINERATE2;
	}	
	public int getFamilyDiscountBasic() {
		return FAMILYDISCOUNTBASIC2;
	}	
	public double getFamilyDiscountBasicRate() {
		return FAMILYDISCOUNTBASICRATE2;
	}
}
