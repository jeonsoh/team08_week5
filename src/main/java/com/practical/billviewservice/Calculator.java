package com.practical.billviewservice;

public class Calculator {

    private User myUser;
    private Plan myPlan;
    private double total;
    private double lineBill;
    private double minutesBill;
    private int familyDiscountMyLine;
    private int addedMyLine;

   

    public Calculator(User user, Plan plan) {
        this.myUser = user;
        this.myPlan = plan;
        if(user !=null && plan !=null){   
            if (user.getMyLineNum() == 1) {
                this.familyDiscountMyLine = 0;
                this.addedMyLine = 0;
            } else if (user.getMyLineNum() < plan.getFamilyDiscountBasic()) {
                this.familyDiscountMyLine = 0;
                this.addedMyLine = user.getMyLineNum() - 1;
            } else if (user.getMyLineNum() >= plan.getFamilyDiscountBasic()) {
                this.familyDiscountMyLine = user.getMyLineNum() - plan.getFamilyDiscountBasic();
                this.addedMyLine = user.getMyLineNum() - this.familyDiscountMyLine - 1;
            }
        }

    }

    public double calculatorSum() {

        this.total = this.myPlan.getBasicMontlyRate() + this.calculateLineBill() + this.calculateMinutesBill();
        return total;

    }

    public String processCalculator() {
        StringBuilder buf = new StringBuilder();
        buf.append("계산과정 :");
        
        buf.append("기본비용: " + this.myPlan.getBasicMontlyRate());

        // 기본 비용 계산


        buf.append(" + 추가라인비용(" + addedMyLine + "*" + this.myPlan.getAdditionalLineRate() + ")");

        // 가족 할인이 적용되지 않은 추가 라인 비용 계산

        if (familyDiscountMyLine > 0) {
            buf.append(" + 가족 할인 라인 비용(" + familyDiscountMyLine + "*" + this.myPlan.getFamilyDiscountBasicRate() + ")");
        }
        // 가족 할인이 적용된 추가 라인 비용 계산

        if (this.myUser.getMyinuteUsed() > this.myPlan.getIncludedMinutes()) {
            int excess = this.myUser.getMyinuteUsed() - this.myPlan.getIncludedMinutes();
            buf.append(" + 초과 시간에 대한 비용(" + excess + "*" + this.myPlan.getRatePerExcessMinute() + ")");
        }
        // 초과 시간에 대한 비용

        buf.append(" = " + this.calculatorSum());

        return buf.toString();
    }

    public double calculateMinutesBill() {
        int useMinutes = myUser.getMyinuteUsed();

        int includedMinutes = myPlan.getIncludedMinutes();
        double excessMinutesRate = myPlan.getRatePerExcessMinute();

        if (useMinutes <= includedMinutes) {
            this.minutesBill = 0;
        } else {
            int excess = useMinutes - includedMinutes;
            this.minutesBill = excess * excessMinutesRate;
        }

        return Math.round(this.minutesBill*100d) / 100d;
    }

    public double calculateLineBill() {
        double additionallinerate = myPlan.getAdditionalLineRate();
        double familydiscountrate = myPlan.getFamilyDiscountBasicRate();

        lineBill = (this.addedMyLine * additionallinerate) + (this.familyDiscountMyLine * familydiscountrate);

        return Math.round(this.lineBill*100d) / 100d;
    }

}
