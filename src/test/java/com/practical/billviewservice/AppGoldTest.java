package com.practical.billviewservice;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppGoldTest extends TestCase {
    
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser=null;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppGoldTest.class);
    Exception ex;

    
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
        
        Plan plan = new Gold();
        myUser = new User( plan, usedMiniute, useLineNumber, name );
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

    @Test(expected = IllegalStateException.class)
    public void testMyMiniUsedException(){
        try{
            myPlan = new Gold();
            User user = new User( myPlan, 2, 2, name );
            user.setMyMiniUsed(-3);           
            
        }catch(IllegalStateException e){
            ex = e;
            LOGGER.info(e.getMessage());
        }
        assertEquals("사용 시간은 음수일 수 없습니다.", ex.getMessage());

    }
    @Test(expected = IllegalStateException.class)
    public void testMyLineException(){
        try{
            myPlan = new Gold();
            User user = new User( myPlan, 2, 2, name );
            user.setMyLineNum(-3);           
            
        }catch(IllegalStateException e){
//            ex = e;
//            LOGGER.info(e.getMessage());
        }
        assertEquals("라인의 수는 1 이상이여야 합니다.", ex.getMessage());

    }
    @Test(expected = IllegalStateException.class)
    public void testMyMiniUsedException3(){
        try{
            myPlan = new Gold();
            User user = new User( myPlan, 2, 2, name );
            user.setMyName(null);           
            
        }catch(IllegalStateException e){
//            ex = e;
//            LOGGER.info(e.getMessage());
        }
        assertEquals("이름이 입력되지 않았습니다.", ex.getMessage());
        

    }
}