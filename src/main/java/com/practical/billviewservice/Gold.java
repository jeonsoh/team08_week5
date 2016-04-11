package com.practical.billviewservice;

public class Gold implements Plan {
    private static final double BASICMONTLYRATE = 49.95;
    private static final int INCLUDEDMINUTES = 1000;
    private static final double RATEPEREXCESSMINUTE = 0.45;
    private static final double ADDITIONALLINERATE = 14.50;
    private static final int FAMILYDISCOUNTBASIC = 3;
    private static final double FAMILYDISCOUNTBASICRATE = 5.00;
    
    public double getBasicMontlyRate() {
        return BASICMONTLYRATE;
    }

    public int getIncludedMinutes() {
        return INCLUDEDMINUTES;
    }

    public double getRatePerExcessMinute() {
        return RATEPEREXCESSMINUTE;
    }

    public double getAdditionalLineRate() {
        return ADDITIONALLINERATE;
    }

    public int getFamilyDiscountBasic() {
        return FAMILYDISCOUNTBASIC;
    }

    public double getFamilyDiscountBasicRate() {
        return FAMILYDISCOUNTBASICRATE;
    }

}
