package com.practical.billviewservice;

public class Gold extends Plan {
    private static final double BASICMONTLYRATE = 49.95;
    private static final int INCLUDEDMINUTES = 1000;
    private static final double RATEPEREXCESSMINUTE = 0.45;
    private static final double ADDITIONALLINERATE = 14.50;
    private static final int FAMILYDISCOUNTBASIC = 3;
    private static final double FAMILYDISCOUNTBASICRATE = 5.00;
    
    @Override
    public double getBasicMontlyRate() {
        return BASICMONTLYRATE;
    }

    @Override
    public int getIncludedMinutes() {
        return INCLUDEDMINUTES;
    }

    @Override
    public double getRatePerExcessMinute() {
        return RATEPEREXCESSMINUTE;
    }

    @Override
    public double getAdditionalLineRate() {
        return ADDITIONALLINERATE;
    }

    @Override
    public int getFamilyDiscountBasic() {
        return FAMILYDISCOUNTBASIC;
    }

    @Override
    public double getFamilyDiscountBasicRate() {
        return FAMILYDISCOUNTBASICRATE;
    }

}
