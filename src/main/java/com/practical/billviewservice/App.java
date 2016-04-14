package com.practical.billviewservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(BillViewService.class);
    private static BufferedReader in;
    public static void main(String[] args) {
        
        
        try{
            
            in = new BufferedReader(new FileReader("user.txt"));
            String line = in.readLine();
            while(line != null){                                               
                appRun(line);                                
                line = in.readLine();
            }
            
            in.close();
            
            
        }catch(IOException e){
            LOGGER.info(e.toString());
        }
      
    }

    private static void appRun(String line) {
        StringTokenizer parser = new StringTokenizer(line, " ");
        int cnt=0;
        User myUser = new User();
        Plan myPlan = null; 
        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toUpperCase();            
            switch(cnt){
            case 0:
                break;
            case 1:
                if("GOLD".equalsIgnoreCase(word)){
                myPlan = new Gold();    
                }else if("SILVER".equalsIgnoreCase(word))
                {
                    myPlan = new Silver();
                }        
                myUser.setMyPlantype(myPlan);
                break;
            case 2:   
                myUser.setMyMiniUsed(Integer.valueOf(word));
                break;
            case 3:
                myUser.setMyLineNum(Integer.valueOf(word));
                break;
            case 4:
                myUser.setMyName(word);
                break;
            default:
                    
            }
            cnt++;                    
            if(cnt==5)
                cnt=0;
        }
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }
}
