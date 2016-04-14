package com.practical.billviewservice;

public class User {

    private Plan myPlantype;
    private int myMinitUsed;
    private int myLineNum;
    private String myName;

    public User(){
        
    }
    
    public User( Plan myPlan, int minitUsed, int lineNum, String name ) {
        this.myPlantype = myPlan;
        this.myMinitUsed = minitUsed;
        this.myLineNum = lineNum;
        this.myName = name;
        
        
    }

    public Plan getMyPlantype() {
        return myPlantype;
    }

    public void setMyPlantype(Plan myPlantype) {
        this.myPlantype = myPlantype;
    }

    public int getMyinuteUsed() {
        return myMinitUsed;
    }

    public void setMyMiniUsed(int myMiniUsed){
        if(myMiniUsed < 0){
            throw new IllegalStateException( "사용 시간은 음수일 수 없습니다." );
        }else{
            this.myMinitUsed = myMiniUsed;
        }
    }

    public int getMyLineNum() {
        return myLineNum;
    }

    public void setMyLineNum(int myLineNum){
        if(myLineNum <= 0){
            throw new IllegalStateException("라인의 수는 1 이상이여야 합니다.");
        }else{
            this.myLineNum = myLineNum;
        }
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        if(myName == null){
            throw new IllegalStateException("이름이 입력되지 않았습니다.");
        }else{
            this.myName = myName;
        }
    }
}