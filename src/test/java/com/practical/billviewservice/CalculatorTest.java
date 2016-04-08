package com.practical.billviewservice;

import org.junit.Test;

import com.practical.billviewservice.Calculator;
import com.practical.billviewservice.Gold;
import com.practical.billviewservice.Plan;
import com.practical.billviewservice.User;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    private static final int USEDMINIUTE = 2000;
    private static final int LINENUMBER = 3;

    
    @Test
    public void testCalculator() {

        Plan myPlan = new Gold();
        User myUser = new User(myPlan, USEDMINIUTE, LINENUMBER, "Gill-Dong");

        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);

    }
}
