package com.practical.billviewservice;

import com.practical.billviewservice.Calculator;
import com.practical.billviewservice.Gold;
import com.practical.billviewservice.Plan;
import com.practical.billviewservice.User;


import junit.framework.TestCase;




public class CalculatorTest extends TestCase {
	
	 public void testCalculator(){
		 
		int usedMiniute = 2000;
	    int lineNumber = 3;
		Plan myPlan = new Gold();
		User myUser = new User(myPlan,usedMiniute,lineNumber,"Gill-Dong");
		
		Calculator calculator =new Calculator(myUser, myPlan);
		
		
		double sum = calculator.calculatorSum();
		double miniBill = calculator.calculateMinutesBill();
		double lineBill = calculator.calculateLineBill();
		
		
		double totalBill = myPlan.getBasicMontlyRate()+ miniBill+lineBill;
		
		assertEquals(totalBill, sum);
		 
	 }
}
