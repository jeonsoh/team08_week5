package com.practical.billviewservice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static Scanner scan;
    public static void main(String[] args) throws IOException  {
        if(args[0]==null)
        {
            User myUser = new User();
            Plan myPlan;
            scan = new Scanner(System.in);

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
        }else{
            new App(args);
        }
    }
    public App(String args[]) throws IOException{
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

            }catch(IOException e){
                LOGGER.info(e.toString());
                throw  e;
            }catch (Exception e) {
                throw new IOException(e);
            }finally{

                if(fos!=null)
                    fos.close();
                if(fis!=null)
                    fis.close();
            }
        }

        
    }


    private static void appRun(String line) {
        StringTokenizer parser = new StringTokenizer(line, " ");
        User myUser = new User();
        Plan myPlan = null; 
        String word = null;

        while(parser.hasMoreTokens()){
             word = parser.nextToken().toUpperCase(); 
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
