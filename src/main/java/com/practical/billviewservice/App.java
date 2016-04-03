package com.practical.billviewservice;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    private App() {

    }

    public static void main(String[] args) {
        String plan="";
        int usedmiiniute=0;
        int uselineNumber=0;
        String name="";
        Plan myPlan=null;
        
        
        Scanner scan = new Scanner(System.in);
        LOGGER.info("계획을 정해주세요 (GOLD? SILVER?) :");
        plan = scan.next();
        LOGGER.info("사용자가 이용 시간 ? :");
        usedmiiniute = scan.nextInt();
        LOGGER.info("사용자가 이용한 전화선 수? : ");
        uselineNumber = scan.nextInt();
        LOGGER.info("사용자의 이름은? : ");
        name =  scan.next();
        
        if(plan.equalsIgnoreCase("GOLD")){
            myPlan = new Gold();
        }else if(plan.equalsIgnoreCase("SILVER")){
            myPlan = new Silver();
        }
        
        
        User myUser = new User(myPlan, usedmiiniute, uselineNumber, name);
        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();

    }
}
