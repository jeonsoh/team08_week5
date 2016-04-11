package com.practical.billviewservice;


import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    
    
    
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
    
    public void testUser()
    {
        int usedMiniute = 878;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMiniute, useLineNumber, "홍길동" );
        Calculator calculator = new Calculator( user, plan );
        assertEquals( 83.95, calculator.calculatorSum() );
    }

}
