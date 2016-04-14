package com.practical.billviewservice;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static User myUser = new User();
    private static Plan myPlan = null;
    
    private App(String args,int cnt){

        FileInputStream fis =null;
        FileOutputStream fos =null;
        byte[] buf = new byte[1024];
        try{


            // String s= System.getProperty("user.dir"); getAbsolutePath 와 동일                 
            File path = new File("");

            if("--file".equals(args)){
                if(cnt>0){
                    fis  = new FileInputStream(path.getAbsolutePath()+"/classes/user/"+args);
                    fos = new FileOutputStream(path.getAbsolutePath()+"/classes/output/"+"out"+cnt+".txt");
                }
            }else{

                fis  = new FileInputStream(path.getAbsolutePath()+"/src/main/resources/user/"+args);
                fos = new FileOutputStream(path.getAbsolutePath()+"/src/main/resources/user/"+"out"+cnt+".txt");

            }

            for(int count=0; count>=0; count = fis.read(buf) ) {
                fos.write(buf, 0, count);
            }
            appSet(new String(buf, "UTF-8"));
            
        }catch (Exception e) {
            LOGGER.error("Exception Error", e);
        }finally{
            if(fos!=null )
                try {
                    fos.close();
                } catch (IOException e) {                        
                    LOGGER.error("FileOutputStream Error", e);
                }
            if(fis!=null)
                try {
                    fis.close();
                } catch (IOException e) {                        
                    LOGGER.error("FileInputStream Error", e);
                }
        }
    }



    public static void main(String[] args) {
        for(int i =0;i<args.length;i++){
            App app=new App(args[i],i);
            app.appRun();
        }
    }

    private static void appSet(String line){
        StringTokenizer parser = new StringTokenizer(line, " ");
        

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
    }
    private  static void appRun() {
        
        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }

}
