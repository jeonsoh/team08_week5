package com.practical.billviewservice;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Hello world!
 *
 */
public class App {

    private App() {

    }

    public static void main(String[] args) {
        
        String plantype="";
        int usedMiniute=0;
        int lineNumber=0;
        String userName="";
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("userinfo.txt"));
            String line = in.readLine();
            while(line != null){
            StringTokenizer parser = new StringTokenizer(line, " ");
            
                int cnt=0;
                while(parser.hasMoreTokens()){
                    String word = parser.nextToken().toUpperCase();
                    if(cnt == 4)
                        cnt=0;
                    switch(cnt){
                        case 0:
                            plantype = word;
                            break;
                        case 1:
                            usedMiniute = Integer.parseInt(word);
                            break;
                        case 2:
                            lineNumber = Integer.parseInt(word);
                            break;
                        case 3:  
                            userName = word;
                            break;
                        default:
                    }
                    cnt++;
                }
                line = in.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        Plan myPlan = null;
        if(plantype.toUpperCase().equals("GOLD")){
            myPlan= new Gold();
        }else if(plantype.toUpperCase().equals("SILVER")){
            myPlan= new Silver();
        }
        
        User myUser = new User(myPlan, usedMiniute, lineNumber, userName);

        Calculator myCalculator = new Calculator(myUser, myPlan);
        BillViewService billviewsystem = new BillViewService(myUser, myPlan, myCalculator);
        billviewsystem.showUser();
        billviewsystem.showPlan();
        billviewsystem.showCalculator();
        billviewsystem.showTotalCalculator();

    }
}
