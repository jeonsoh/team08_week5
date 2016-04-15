package com.practical.billviewservice;



import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppSilverTest extends TestCase {
    
    BillViewService billViewService = null;
    String name = "홍길동";
    Plan myPlan = null;
    User myUser = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppGoldTest.class);
    Exception ex;
    
    @Before
    public void setUp(){
         myPlan = new Silver();
    }

    public void show( BillViewService billviewservice ){
        billviewservice.showUser();
        billviewservice.showPlan();
        billviewservice.showCalculator();
        billviewservice.showTotalCalculator();
    }
    
    
    @Test
    public void testbillViewServiceSilver(){
        int usedMiniute = 878;
        int useLineNumber = 4;     
        myUser = new User(myPlan, usedMiniute, useLineNumber, name);
        myUser.setMyLineNum(8);
        myUser.setMyMiniUsed(833);
        myUser.setMyName("심청");
        myUser.setMyPlantype(new Silver());
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        show(billviewsystem);
    }
    
    
    @Test
    public void testCalculatorTotalSilver() {
        int usedMiniute = 878;
        int useLineNumber = 4;
        
        Plan plan = new Silver();
        myUser = new User( plan, usedMiniute, useLineNumber, name);
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum2 = calculator.calculatorSum();
        double miniBill2 = calculator.calculateMinutesBill();
        double lineBill2 = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill2 + lineBill2;

        assertEquals(totalBill, sum2);
    }
    
    @Test
    public void testBasicLine(){
        //라인 1, 추가라인x, 추가통화량x, family discount x
        int usedMiniute = 499;
        int useLineNumber = 1;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 29.95, calculator.calculatorSum() );
     }
    
    @Test
    public void testBasicLineExMinNoDC(){
        //라인 1, 추가라인x, 추가통화량o, family discount x
        int usedMiniute = 520;
        int useLineNumber = 1;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 40.75, calculator.calculatorSum() );
     }
    @Test
    public void testaddLine(){
        //라인 2or3, 추가라인o, 추가통화량x, family discount x
        int usedMiniute = 499;
        int useLineNumber = 2;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 51.45, calculator.calculatorSum() );
     }
    @Test
    public void testaddLineExMinNoDC(){
        //라인 2or3, 추가라인o, 추가통화량o, family discount x
        int usedMiniute = 523;
        int useLineNumber = 2;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 63.87, calculator.calculatorSum(),0.005);
     }
    @Test
    public void testaddLineDC(){
        //라인 4more, 추가라인o, 추가통화량x, family discount o
        int usedMiniute = 499;
        int useLineNumber = 5;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 82.95, calculator.calculatorSum() );
     }
    @Test
    public void testaddLineExMinDC(){
        //라인 4more, 추가라인o, 추가통화량x, family discount o
        int usedMiniute = 550;
        int useLineNumber = 5;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 109.95, calculator.calculatorSum() );
     }
    
    @Test
    public void testException(){
        int usedMiniute = -3;
        int useLineNumber = -5;
        
        Plan plan = new Silver();
        User user = new User( plan, usedMiniute, useLineNumber, null );
        Calculator calculator = new Calculator( user, plan );
        assertEquals(-99.05, calculator.calculatorSum() );
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMyMiniUsedException(){
        try{
            myPlan = new Silver();
            User user = new User( myPlan, 2, 2, name );
            user.setMyMiniUsed(-3);           
            
        }catch(IllegalStateException e){
            ex = e;
            LOGGER.info(ex.getMessage());
            
        }finally{
            assertEquals("사용 시간은 음수일 수 없습니다.", ex.getMessage());
        }
       

    }
    @Test(expected = IllegalStateException.class)
    public void testMyLineException(){
        try{
            myPlan = new Silver();
            User user = new User( myPlan, 2, 2, name );
            user.setMyLineNum(-3);           
            
        }catch(IllegalStateException e){
            ex = e;
            LOGGER.info(ex.getMessage());
            
        }finally{
            assertEquals("라인의 수는 1 이상이여야 합니다.", ex.getMessage());
        }
        

    }
    @Test(expected = IllegalStateException.class)
    public void testMyMiniUsedException3(){
        try{
            myPlan = new Silver();
            User user = new User( myPlan, 2, 2, name );
            user.setMyName(null);                       
        }catch(IllegalStateException e){
            ex = e;
            LOGGER.info(ex.getMessage());
            
        }finally{
            assertEquals("이름이 입력되지 않았습니다.", ex.getMessage());
        }
    }
   
}