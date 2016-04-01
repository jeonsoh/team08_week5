package com.practical.billviewservice;

import com.practical.billviewservice.Calculator;
import com.practical.billviewservice.Gold;
import com.practical.billviewservice.Plan;
import com.practical.billviewservice.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class CalculatorTest extends TestCase {
	
	 public void testCalculator(){
		Plan myPlan = new Gold();
		User myUser = new User(myPlan,2000,3,"Gill-Dong");
		
		Calculator calculator =new Calculator(myUser, myPlan);
		
		
		double sum = calculator.calculatorSum();
		double miniBill = calculator.calculateMinutesBill();
		double lineBill = calculator.calculateLineBill();
		
		
		
		assertEquals(1.0, sum);
		assertEquals(2.0, miniBill);
		assertEquals(3.0, lineBill);
		 
	 }
}
