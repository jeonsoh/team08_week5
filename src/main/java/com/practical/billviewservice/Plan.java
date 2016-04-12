package com.practical.billviewservice;

public class Plan {
    private double BASICMONTLYRATE;
    private int INCLUDEDMINUTES;
    private double RATEPEREXCESSMINUTE;
    private double ADDITIONALLINERATE;
    private int FAMILYDISCOUNTBASIC;
    private double FAMILYDISCOUNTBASICRATE;
    
    public Plan( double basicRate, int includedMinutes, double ratePreExcessMinute,
            double additionalLineRate, int familyDiscountBasic, double familyDiscountBasicRate ){
        this.BASICMONTLYRATE = basicRate;
        this.INCLUDEDMINUTES = includedMinutes;
        this.RATEPEREXCESSMINUTE = ratePreExcessMinute;
        this.ADDITIONALLINERATE = additionalLineRate;
        this.FAMILYDISCOUNTBASIC = familyDiscountBasic;
        this.FAMILYDISCOUNTBASICRATE = familyDiscountBasicRate;
    }
    
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