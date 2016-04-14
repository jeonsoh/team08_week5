package com.practical.billviewservice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private App(){

    }
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {

        FileInputStream fis = null;
        FileOutputStream fos =null;
        String value = null;
        for(int i =0;i<args.length;i++){


            try{

                fis = new FileInputStream(args[i]);
                fos = new FileOutputStream("out.txt");

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
        int cnt=1;
        User myUser = new User();
        Plan myPlan = null; 

        while(parser.hasMoreTokens()){
            String word = parser.nextToken().toUpperCase(); 

            switch(cnt){
            case 1:
                if("GOLD".equalsIgnoreCase(word)){
                    myPlan = new Gold();    
                }else if("SILVER".equalsIgnoreCase(word))
                {
                    System.out.println(word);
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
                cnt=1;
        }
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }
}
