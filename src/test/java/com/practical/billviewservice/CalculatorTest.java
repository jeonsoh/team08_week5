package com.practical.billviewservice;

import com.practical.billviewservice.Calculator;
import com.practical.billviewservice.Gold;
import com.practical.billviewservice.Plan;
import com.practical.billviewservice.User;


import junit.framework.TestCase;




public class CalculatorTest extends TestCase {
	
	 public void testCalculator(){
		Plan myPlan = new Gold();
		User myUser = new User(myPlan,2000,3,"Gill-Dong");
		
		Calculator calculator =new Calculator(myUser, myPlan);
		
		
		double sum = calculator.calculatorSum();
		double miniBill = calculator.calculateMinutesBill();
		double lineBill = calculator.calculateLineBill();
		
		System.out.println( myPlan.getBasicMontlyRate());
		System.out.println(miniBill);
		System.out.println(lineBill);
		
		double totalBill = myPlan.getBasicMontlyRate()+ miniBill+lineBill;
		System.out.println(totalBill);
		System.out.println(sum);
		
		assertEquals(totalBill, sum);
		 
	 }
}
