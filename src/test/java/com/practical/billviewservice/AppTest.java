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
    public void testApp() throws Exception {
        String[] userfile= new String[10];
        
        userfile[0] = "user1.txt";
        userfile[1] = "user2.txt";
        userfile[2] = "user3.txt";
        userfile[3] = "user4.txt";
        userfile[4] = "user5.txt";
        userfile[5] = "user6.txt";
        userfile[6] = "user7.txt";
        userfile[7] = "user8.txt";
        userfile[8] = "user9.txt";
        userfile[9] = "user10.txt";
        
        App.main(userfile);
       
        assertTrue(true);
    } 
    @Test
    public void testErrorApp() throws Exception {
        String[] userfile= new String[2];
        
        userfile[0] = "--file";
        userfile[1] = "user5.txt";
        
        App.main(userfile);
       
        assertTrue(true);
    }
    
    
    @Test
    public void testFile() throws Exception {
        String[] userfile= new String[5];
        
        userfile[0] = "--file";
        userfile[1] = "user1.txt";
        userfile[2] = "user2.txt";
        userfile[3] = "user3.txt";
        userfile[4] = "user6.txt";
        
        App.testMain("/target",userfile);
       
        assertTrue(true);
    }
    
    @Test
    public void testFileError() throws Exception {
        String[] userfile= new String[4];
        
        userfile[0] = "user11.txt";
        userfile[1] = "user10.txt";
        userfile[2] = "user8.txt";
        userfile[3] = "user9.txt";
        
        App.testMain("/target",userfile);
       
        assertTrue(true);
    }

    @Test
    public void testNull() throws Exception {
       
        App.main(null);
       
        assertTrue(true);
    }

   
}
