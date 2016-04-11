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
    
    App() {

    }

    public static void main(String[] args) {
        User myUser = new User();
        Plan myPlan;
        Scanner scan = new Scanner(System.in);
        
        LOGGER.info("계획을 정해주세요 (GOLD? SILVER?) :");
        String plan = scan.next();
        if("GOLD".equalsIgnoreCase(plan)){
            myPlan = new Gold();
        }else if("SILVER".equalsIgnoreCase(plan)){
            myPlan = new Silver();
        }else{
            throw new IllegalStateException("서비스 하지 않는 계획입니다.");
        }
        myUser.setMyPlantype(myPlan);
        
        LOGGER.info("사용자가 이용 시간 ? :");
        myUser.setMyMiniUsed(scan.nextInt());
        
        LOGGER.info("사용자가 이용한 전화선 수? : ");
        myUser.setMyLineNum(scan.nextInt());
        
        LOGGER.info("사용자의 이름은? : ");
        myUser.setMyName(scan.next());
        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();

    }
}
