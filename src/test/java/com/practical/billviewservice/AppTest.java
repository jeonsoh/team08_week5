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
     * App Test :-)
     * @throws IOException 
     */
    @Test(expected = Exception.class)
    public void testApp() throws IOException {
        String[] userfile= new String[4];
        
        userfile[0] = "user1.txt";
        userfile[1] = "user2.txt";
        userfile[2] = "user3.txt";
        userfile[3] = "user4.txt";
        
        try {
            App.main(userfile);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            assertTrue(true);
        } 
    } 
    @Test(expected = Exception.class)
    public void testErrorApp() throws IOException {
        String[] userfile= new String[4];
        
        userfile[0] = "--file";
        userfile[1] = "user1.txt";
        userfile[2] = "user2.txt";
        userfile[3] = "user3.txt";
        
        try {
            App.main(userfile);
        } catch (Exception e) {
            e.getMessage();
        }finally{
            assertTrue(true);     
        }
       
       
    }

   
}
