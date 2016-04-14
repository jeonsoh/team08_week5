package com.practical.billviewservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Hello world!
 *
 */
public class App {
    
    App() {

    }

    public static void main(String[] args) {
        User myUser = new User();
        Plan myPlan = null;
        int cnt=0;
        try{
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            String line = in.readLine();
            while(line != null){
            StringTokenizer parser = new StringTokenizer(line, " ");
                while(parser.hasMoreTokens()){
                    String word = parser.nextToken().toUpperCase();
                    
                    if(cnt==0){
                        if(word.equalsIgnoreCase("GOLD")){
                            myPlan = new Gold();    
                        }else if(word.equalsIgnoreCase("SILVER"))
                        {
                            myPlan = new Silver();
                        }        
                        myUser.setMyPlantype(myPlan);
                    }else if(cnt==1){   
                        myUser.setMyMiniUsed(Integer.valueOf(word));
                    }else if(cnt==2){
                        myUser.setMyLineNum(Integer.valueOf(word));
                    }else if(cnt==3){
                        myUser.setMyName(word);
                    }
                    cnt++;                    
                    if(cnt==4)
                        cnt=0;
                }
                line = in.readLine();
            }
            in.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }
}
