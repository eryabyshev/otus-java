package main.java;

public class Cell {
    private BanknoteFaceValue name;
    private int count;

    public Cell(BanknoteFaceValue name, int count) {
        this.name = name;
        this.count = count;
    }

    public BanknoteFaceValue getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
