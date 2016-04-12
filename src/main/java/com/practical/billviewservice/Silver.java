package com.practical.billviewservice;

public class Silver extends Plan {
    private static final double BASICMONTLYRATE2 = 29.95;
    private static final int INCLUDEDMINUTES2 = 500;
    private static final double RATEPEREXCESSMINUTE2 = 0.54;
    private static final double ADDITIONALLINERATE2 = 21.50;
    private static final int FAMILYDISCOUNTBASIC2 = 3;
    private static final double FAMILYDISCOUNTBASICRATE2 = 5.00;

    public Silver(){
        super( BASICMONTLYRATE2, INCLUDEDMINUTES2 ,RATEPEREXCESSMINUTE2,ADDITIONALLINERATE2,
                FAMILYDISCOUNTBASIC2, FAMILYDISCOUNTBASICRATE2 );
    }
}
