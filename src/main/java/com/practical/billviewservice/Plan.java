package com.practical.billviewservice;

public class Plan {
    private double basicRate;
    private int includedMinutes;
    private double ratePreExcessMinute;
    private double additionalLineRate;
    private int familyDiscountBasic;
    private double familyDiscountBasicRate;
    
    public Plan( double basicRate, int includedMinutes, double ratePreExcessMinute,
            double additionalLineRate, int familyDiscountBasic, double familyDiscountBasicRate ){
        this.basicRate = basicRate;
        this.includedMinutes = includedMinutes;
        this.ratePreExcessMinute = ratePreExcessMinute;
        this.additionalLineRate = additionalLineRate;
        this.familyDiscountBasic = familyDiscountBasic;
        this.familyDiscountBasicRate = familyDiscountBasicRate;
    }
    
    public double getBasicMontlyRate() {
        return this.basicRate;
    }

    public int getIncludedMinutes() {
        return this.includedMinutes;
    }

    public double getRatePerExcessMinute() {
        return this.ratePreExcessMinute;
    }

    public double getAdditionalLineRate() {
        return this.additionalLineRate;
    }
    
    public int getFamilyDiscountBasic() {
        return this.familyDiscountBasic;
    }

    public double getFamilyDiscountBasicRate() {
        return this.familyDiscountBasicRate;
    }
}