package com.practical.billviewservice;

import org.junit.Before;
import org.junit.Test;

import com.practical.billviewservice.Calculator;
import com.practical.billviewservice.Plan;
import com.practical.billviewservice.User;

import junit.framework.TestCase;

public class CalculatorSilverTest extends TestCase {

    private static final int USEDMINIUTE = 0;
    private static final int LINENUMBER = 0;
    
    
    Plan myPlan;
    User myUser;
    Calculator calculator;
    
    
    @Before
    public void setUpSilver(){
        myPlan = new Silver();
        myUser= new User(myPlan, USEDMINIUTE, LINENUMBER, "Gill-Dong");
        calculator = new Calculator(myUser, myPlan);
    }
    
    @Test
    public void testCalculatorZero() {

        
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);

    }
    
    @Test
    public void testCalculatorTotal() {

        
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);

    }
}
