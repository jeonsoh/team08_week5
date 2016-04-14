package com.practical.billviewservice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        FileInputStream fis = null;
        FileOutputStream fos =null;
        String value = null;
        for(int i =0;i<args.length;i++){


            try{

                fis = new FileInputStream(args[i]);
                fos = new FileOutputStream("out/out"+i+".txt");

                byte[] buf = new byte[1024];
                int count = 0;

                while ( (count = fis.read(buf) ) != -1) {
                    fos.write(buf, 0, count);
                }

                value=new String(buf, "UTF-8");

                appRun(value);

            }catch (Exception e) {
                LOGGER.error("context", e);
            }finally{

                if(fos!=null)
                    try {
                        fos.close();
                    } catch (IOException e) {                        
                         LOGGER.error("context", e);
                    }
                if(fis!=null)
                    try {
                        fis.close();
                    } catch (IOException e) {
                        LOGGER.error("context", e);
                    }
            }
        }

    }

    private static void appRun(String line) {
        StringTokenizer parser = new StringTokenizer(line, " ");
        User myUser = new User();
        Plan myPlan = null;

        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toUpperCase(); 
             if("GOLD".equalsIgnoreCase(word)){
                 myPlan = new Gold();    
             }else if("SILVER".equalsIgnoreCase(word))
             {
                 myPlan = new Silver();
             }        
             myUser.setMyPlantype(myPlan);
             
             word=parser.nextToken().toUpperCase();
             myUser.setMyMiniUsed(Integer.valueOf(word));
             
             word=parser.nextToken().toUpperCase();
             myUser.setMyLineNum(Integer.valueOf(word));
             
             word=parser.nextToken().toUpperCase();             
             myUser.setMyName(word);
        }
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }

}
