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
       String args[] = {"Gold", "848", "4", "홍길동"}; 
       App app = new App();
       
    }
    


   
}
