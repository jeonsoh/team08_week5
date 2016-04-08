package com.practical.billviewservice;



import org.junit.Test;
import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser;
    
    /**
     * Create the test case
     *
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
    
    public void show(BillViewService billviewservice){
        billviewservice.showUser();
        billviewservice.showPlan();
        billviewservice.showCalculator();
        billviewservice.showTotalCalculator();
    }
    
    
    @Test
    public void billViewServiceGold(){
        int usedMiniute = 878;
        int useLineNumber = 4;

        Plan myPlan=new Gold();
        User myUser = new User(myPlan, usedMiniute, useLineNumber, name);        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        show(billviewsystem);
    }
    
    @Test
    public void billViewServiceSilver(){
        int usedMiniute = 878;
        int useLineNumber = 4;

        Plan myPlan=new Silver();
        User myUser = new User(myPlan, usedMiniute, useLineNumber, name);        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        show(billviewsystem);
    }
    
    @Test
    public void testGold(){
        int usedMiniute = 878;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, "test" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 83.95, calculator.calculatorSum() );
     }
    
    @Test
    public void testCalculatorTotalGold() {
        int usedMiniute = 878;
        int useLineNumber = 4;
        myPlan = new Silver();
        myUser= new User(myPlan, usedMiniute, useLineNumber, "Gill-Dong");
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);

    }
    @Test
    public void testCalculatorTotaSilverl() {
        int usedMiniute = 878;
        int useLineNumber = 4;
        myPlan = new Silver();
        myUser= new User(myPlan, usedMiniute, useLineNumber, "Gill-Dong");
        Calculator calculator = new Calculator(myUser, myPlan);

        double sum = calculator.calculatorSum();
        double miniBill = calculator.calculateMinutesBill();
        double lineBill = calculator.calculateLineBill();

        double totalBill = myPlan.getBasicMontlyRate() + miniBill + lineBill;

        assertEquals(totalBill, sum);

    }
}
