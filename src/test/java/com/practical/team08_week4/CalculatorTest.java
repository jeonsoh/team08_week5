package com.practical.team08_week4;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class CalculatorTest extends TestCase {
	
	
	 public void testCalculator(){
		User myUser = new User("Gold",2000,3,"Gill-Dong");
		Plan myPlan = new Gold();
		Calculator calculator =new Calculator(myUser, myPlan);
		
		
		double sum = calculator.calculatorSum();
		double miniBill = calculator.calculateMinutesBill();
		double lineBill = calculator.calculateLineBill();
		
		
		
		assertEquals(1.0, sum);
		assertEquals(2.0, miniBill);
		assertEquals(3.0, lineBill);
		 
	 }
}
