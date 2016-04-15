package com.practical.billviewservice;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppPlanNullTest extends TestCase {
    
    BillViewService billViewService  = null;
    String name="홍길동";
    Plan myPlan=null;
    User myUser=null;
    private static final Logger LOGGER = LoggerFactory.getLogger(AppGoldTest.class);
    Exception ex;

    
    @Before
    public void setUp(){
         myPlan=null;
    }
    
    public void show(BillViewService billviewservice){
        billviewservice.showUser();
        billviewservice.showPlan();
        billviewservice.showCalculator();
        billviewservice.showTotalCalculator();
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testMyMiniUsedException3(){
        try{
            User user = new User( myPlan, 2, 2, name );
            user.setMyName(null);                       
        }catch(IllegalStateException e){
            ex = e;
            LOGGER.info(ex.getMessage());
            
        }finally{
            assertEquals("Plan을 입력하지 않았습니다.", ex.getMessage());
        }
    }

 }