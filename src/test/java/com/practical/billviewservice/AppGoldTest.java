package com.practical.billviewservice;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppGoldTest extends TestCase {
    
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser=null;
    
    @Before
    public void setUp(){
         myPlan=new Gold();
    }
    
    public void show(BillViewService billviewservice){
        billviewservice.showUser();
        billviewservice.showPlan();
        billviewservice.showCalculator();
        billviewservice.showTotalCalculator();
    }
    
    @Test
    public void testbillViewServiceGold(){
        int usedMiniute = 878;
        int useLineNumber = 4;     
        myUser = new User(myPlan, usedMiniute, useLineNumber, name);
        myUser.setMyLineNum(8);
        myUser.setMyMiniUsed(833);
        myUser.setMyName("심청");
        myUser.setMyPlantype(new Gold());
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        show(billviewsystem);
    }
    
    @Test
    public void testCalculatorTotalGold() {
        int usedMiniute = 878;
        int useLineNumber = 4;
        myUser= new User(myPlan, usedMiniute, useLineNumber, name);
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);
    }
        
    @Test
    public void testBasicLine(){
        int usedMiniute = 999;
        int useLineNumber = 1;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 49.95, calculator.calculatorSum() );
    }
    
    @Test
    public void testBasicLineExMinNoDC(){
        int usedMiniute = 1010;
        int useLineNumber = 1;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 54.45, calculator.calculatorSum() );
    }
    
    @Test
    public void testAddLine(){
        int usedMiniute = 999;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 83.95, calculator.calculatorSum() );
    }
    
    @Test
    public void testAddLineExMinNoDC(){
        int usedMiniute = 1010;
        int useLineNumber = 3;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 83.45, calculator.calculatorSum() );
    }
    
    @Test
    public void testAddLineDC(){
        int usedMiniute = 878;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 83.95, calculator.calculatorSum() );
    }
    
    @Test
    public void testAddLineExMinDC(){
        int usedMiniute = 1123;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 139.3, calculator.calculatorSum() );
    }
    @Test
    public void testException(){
        int usedMiniute = -3;
        int useLineNumber = -5;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, null );
        Calculator calculator = new Calculator( user, plan );
        assertEquals(-37.05, calculator.calculatorSum() );
    }
}
