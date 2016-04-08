package com.practical.billviewservice;



import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppSilverTest extends TestCase {
    
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser=null;
    
    @Before
    public void setUp(){
         myPlan=new Silver();
    }
    

    
    public void show(BillViewService billviewservice){
        billviewservice.showUser();
        billviewservice.showPlan();
        billviewservice.showCalculator();
        billviewservice.showTotalCalculator();
    }
    
    
    @Test
    public void billViewServiceSilver(){
        int usedMiniute = 878;
        int useLineNumber = 4;     
        myUser = new User(myPlan, usedMiniute, useLineNumber, name);        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        show(billviewsystem);
    }
    
    
    
    
    @Test
    public void testCalculatorTotalSilver() {
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
    
}
