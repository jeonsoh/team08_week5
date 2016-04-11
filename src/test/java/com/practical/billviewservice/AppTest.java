package com.practical.billviewservice;


import org.junit.Test;

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
    
    @Test
    public void testUserSetMethod()
    {
        int usedMinute = 878;
        int useLineNumber = 4;
        
        Plan plan = new Gold();
        User user = new User( plan, usedMinute, useLineNumber, "홍길동" );

        assertEquals( usedMinute, user.getMyinuteUsed() );
        assertEquals( useLineNumber, user.getMyLineNum() );
        assertEquals( "홍길동", user.getMyName() );
        assertEquals( plan, user.getMyPlantype());
       
    }
    


}
