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
    @Test
    public void testApp() throws IOException {
        String userfile[]= new String[3];
        userfile[0] = "user1.txt";
        userfile[1] = "user2.txt";
        userfile[2] = "user3.txt";
        try {
            App.main(userfile);
        } catch (IOException e) {
            throw e;
        }catch (Exception e){
            throw new IOException(e);
        }
        assertTrue(true);
    }

   
}
