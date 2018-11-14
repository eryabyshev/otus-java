package main.java;

public enum BanknoteFaceValue {


    HUNDRED(100),
    HUNDRED5(500),
    THOUSAND(1000),
    THOUSAND5(5000);

    private int value;

    BanknoteFaceValue(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }


}
