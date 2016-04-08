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
    public void testSilver(){
        int usedMiniute = 1;
        int useLineNumber =1;
        myUser = new User( myPlan, usedMiniute, useLineNumber, name );
        Calculator calculator = new Calculator( myUser, myPlan );
        assertEquals( 29.95, calculator.calculatorSum() );
     }
}
