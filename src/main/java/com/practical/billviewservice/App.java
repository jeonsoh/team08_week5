package com.practical.billviewservice;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private App(String baseDir, String args,int cnt, boolean isFile){

        FileInputStream fis =null;
        FileOutputStream fos =null;

        byte[] buf = new byte[1024];
        try{


            // String s= System.getProperty("user.dir"); getAbsolutePath 와 동일                 
            File path = new File("");


            if(isFile){
                if(cnt>0){

                    fis  = new FileInputStream(path.getAbsolutePath()+baseDir+"/classes/user/"+args);
                    fos = new FileOutputStream(path.getAbsolutePath()+baseDir+"/classes/output/"+"out"+(cnt+1)+".txt");

                }
            }else{

                fis  = new FileInputStream(path.getAbsolutePath()+"/src/main/resources/user/"+args);
                fos = new FileOutputStream(path.getAbsolutePath()+"/src/main/resources/output/"+"out"+(cnt+1)+".txt");

            }
            if(!isFile){
                for(int count=0; count>=0; count = fis.read(buf) ) {
                    fos.write(buf, 0, count);
                }
                appRun(new String(buf, "UTF-8"));
            }else if(cnt>0){
                for(int count=0; count>=0; count = fis.read(buf) ) {
                    fos.write(buf, 0, count);
                }
                appRun(new String(buf, "UTF-8"));
            }else{
                LOGGER.info("파일 입력받습니다");
            }


        }catch (Exception e) {
            LOGGER.error("Exception ", e);

        }finally{
            try{
                if(fos!=null ){
                    fos.close();
                }
                if(fis!=null){
                    fis.close();
                }
                fis.close();

            } catch (Exception e) {                        
                LOGGER.error("Exception 발", e);
            }finally{
                LOGGER.info("file 입출력 끝");
            }


        }
    }

    /**
     * jar 로 command line에서 처리되는부분과 test로 하는 부분 
     * @param args
     */
    public static void main(String[] args) {
        boolean isFile = false;
        if("--file".equals(args[0])){
            isFile = true;
            for(int i =0;i<args.length;i++){
                App app=new App("",args[i],i,isFile);
                app.showUser(i);
            }
        }else if(args[0]!=null){
            for(int i =0;i<args.length;i++){
                App app=new App("",args[i],i,isFile);
                app.showUser(i);
            }
        }
        
    }


    /**
     * 이 경우에는 test에서는 프로젝트가 기본경로가 되지만 mvn package로 할경우 target이 경로가 잡히기 때문이다. 
     * @param args
     * @param baseDir baseDir test를 위해 기본경로를 잡아줌 
     */
    public static void testMain(String baseDir,String[] args) {
        if("--file".equals(args[0])){
            boolean isFile  = true;
            for(int i =0;i<args.length;i++){
                App app=new App(baseDir,args[i],i,isFile);
                app.showUser(i);
            }
        }
    }

    private static void appRun(String line){
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
            }else{
                myPlan=null;
            }
            myUser.setMyPlantype(myPlan);

            word=parser.nextToken().toUpperCase();
            myUser.setMyMiniUsed(Integer.valueOf(word));

            word=parser.nextToken().toUpperCase();
            myUser.setMyLineNum(Integer.valueOf(word));

            word=parser.nextToken().toUpperCase();             
            myUser.setMyName(word);
        }

        Calculator myCalculator= new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();
    }

    private  void showUser(int i) {
        if(i >0){
            LOGGER.info("위의 내용은"+(i+1)+"번째 사용자에 대한 정보입니다");
        }
    }

}
