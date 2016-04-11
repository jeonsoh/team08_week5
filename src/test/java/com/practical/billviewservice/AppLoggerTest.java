package com.practical.billviewservice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLoggerTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BillViewService.class);
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser=null;

    
    public void billViewServiceGold(){
        int usedMiniute = 878;
        int useLineNumber = 4;     
        myUser = new User(myPlan, usedMiniute, useLineNumber, name);        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
    }
    
    @Test
    public void testShowUser()
    {
        int usedMiniute = 878;
        int useLineNumber = 4;     
        myUser = new User(myPlan, usedMiniute, useLineNumber, name);
        
        String test = "";
        //assertEquals( ,billViewService.showUser() );
    }
    

}
