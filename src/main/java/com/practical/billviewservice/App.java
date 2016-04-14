package com.practical.billviewservice;


import java.io.File;
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

    public static void main(String[] args) {

        
        FileInputStream fis =null;
        FileOutputStream fos =null;
        for(int i =0;i<args.length;i++){
            try{

                String fileName = args[i];                 
                               
                // String s= System.getProperty("user.dir"); getAbsolutePath 와 동일 

                
                File path = new File("");
               
                if("--file".equals(args[0])){
                    String userlFile = path.getAbsolutePath()+"/classes/user/"+fileName;
                    String outputFile = path.getAbsolutePath()+"/classes/output/"+"out"+i+".txt";
                    fis  = new FileInputStream(userlFile);
                    fos = new FileOutputStream(outputFile);
                }else{
                    
                    String userlFile = path.getAbsolutePath()+"/src/main/resources/user/"+fileName;
                    String outputFile = path.getAbsolutePath()+"/src/main/resources/user/"+"out"+i+".txt";
                    fis  = new FileInputStream(userlFile);
                    fos = new FileOutputStream(outputFile);
                }
                          
                byte[] buf = new byte[1024];
                
                
                for(int count=0; count != -1; count = fis.read(buf) ) {
                    fos.write(buf, 0, count);
                }

                String value=new String(buf, "UTF-8");

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
