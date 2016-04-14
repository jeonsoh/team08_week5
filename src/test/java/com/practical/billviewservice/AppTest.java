package com.practical.billviewservice;

import java.io.IOException;

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
    @Test
    public void testApp() {
        String userfile[]= new String[2];
        userfile[0] = "user.txt";
        userfile[1] = "user2.txt";
        try {
            App.main(userfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertTrue(true);
    }

   
}
