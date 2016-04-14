package com.practical.billviewservice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    FileInputStream fis = null;
    public static void main(String[] args) throws IOException {
        
        FileInputStream fis = null;
        FileOutputStream fos =null;
        try{
            
            fis = new FileInputStream("user.txt");
            fos = new FileOutputStream("out.txt");
            
            byte[] buf = new byte[1024];
            int count = 0;
            
            while ( (count = fis.read(buf) ) != -1) {
                fos.write(buf, 0, count);
            }
            String value = new String(buf, "UTF-8");
            if(value !=null)
               appRun(value);
            
        }catch(IOException e){
            LOGGER.info(e.toString());
        }finally{
            fos.close();
            fis.close();
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
