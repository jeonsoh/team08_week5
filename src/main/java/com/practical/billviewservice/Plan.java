package com.practical.billviewservice;

public abstract class Plan {
    public abstract double getBasicMontlyRate();

    public abstract int getIncludedMinutes();

    public abstract double getRatePerExcessMinute();

    public abstract double getAdditionalLineRate();

    public abstract int getFamilyDiscountBasic();

    public abstract double getFamilyDiscountBasicRate();
}