package com.practical.billviewservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class App {
    
    App() {

    }

    public static void main(String[] args) {
        
        try{
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            String line = in.readLine();
            while(line != null){
                User myUser = new User();
                Plan myPlan = null;
                int cnt=0;
                StringTokenizer parser = new StringTokenizer(line, " ");
                myPlan = appRun(myUser, myPlan, cnt, parser);
                line = in.readLine();
                Calculator myCalculator = new Calculator(myUser, myPlan);
                BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
                billviewsystem.showUser();
                billviewsystem.showPlan();
                billviewsystem.showCalculator();
                billviewsystem.showTotalCalculator();
            }
            in.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
      
    }

    private static Plan appRun(User myUser, Plan myPlan, int cnt, StringTokenizer parser) {
        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toUpperCase();
            
            switch(cnt){
            case 0:
                if("GOLD".equalsIgnoreCase(word)){
                myPlan = new Gold();    
                }else if("SILVER".equalsIgnoreCase(word))
                {
                    myPlan = new Silver();
                }        
                myUser.setMyPlantype(myPlan);
                break;
            case 1:   
                myUser.setMyMiniUsed(Integer.valueOf(word));
                break;
            case 2:
                myUser.setMyLineNum(Integer.valueOf(word));
                break;
            case 3:
                myUser.setMyName(word);
                break;
            default:
                    
            }
            cnt++;                    
            if(cnt==4)
                cnt=0;
        }
        return myPlan;
    }
}
