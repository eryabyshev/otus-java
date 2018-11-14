package test.java;

import main.java.ATM;
import main.java.BanknoteFaceValue;
import main.java.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ATMTest {



    private Map<BanknoteFaceValue, Integer> getMap(Object clazz, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (Map<BanknoteFaceValue, Integer>) field.get(clazz);
    }

    private Map<BanknoteFaceValue, Integer> getMap(Object clazz) throws NoSuchFieldException, IllegalAccessException {
        return getMap(clazz, "money");
    }

    private Map<BanknoteFaceValue, Integer>getMomentoMap(Object clazz) throws NoSuchFieldException, IllegalAccessException {
        return getMap(clazz, "backUp");
    }



    @Test
    public void takeMoneyTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        atm.takeMoney(BanknoteFaceValue.HUNDRED);
        Map<BanknoteFaceValue, Integer> map = getMap(atm);
        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(1));
    }


    @Test
    public void takeMonyTest2() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        atm.takeMoney(BanknoteFaceValue.HUNDRED,
                BanknoteFaceValue.HUNDRED5,
                BanknoteFaceValue.THOUSAND5,
                BanknoteFaceValue.HUNDRED);
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(2));
        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED5), new Integer(1));
        Assert.assertEquals(map.get(BanknoteFaceValue.THOUSAND5), new Integer(1));
    }

    @Test
    public void takeMonyTest3() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        atm.takeMoney(100);
        Map<BanknoteFaceValue, Integer> map = getMap(atm);
        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(1));
    }

    @Test
    public void takeMonyTest4() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        atm.takeMoney(100, 300, 200, 500, 1000);
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(1));
        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED5), new Integer(1));
        Assert.assertEquals(map.get(BanknoteFaceValue.THOUSAND), new Integer(1));
    }


    @Test
    public void getSumTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        map.put(BanknoteFaceValue.HUNDRED, 10);
        map.put(BanknoteFaceValue.HUNDRED5, 2);
        map.put(BanknoteFaceValue.THOUSAND, 1);
        map.put(BanknoteFaceValue.THOUSAND5, 2);

        Assert.assertEquals(atm.sumAllMoney(), 13000);
    }


    @Test
    public void getMoneyTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        map.put(BanknoteFaceValue.HUNDRED, 10);
        map.put(BanknoteFaceValue.HUNDRED5, 2);
        map.put(BanknoteFaceValue.THOUSAND, 1);
        map.put(BanknoteFaceValue.THOUSAND5, 2);
        Assert.assertTrue(atm.getMoney(100));
        map = getMap(atm);
        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(9));
    }


    @Test
    public void getMoneyTest2() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        map.put(BanknoteFaceValue.HUNDRED, 10);
        map.put(BanknoteFaceValue.THOUSAND, 1);
        map.put(BanknoteFaceValue.THOUSAND5, 2);
        Assert.assertTrue(atm.getMoney(100));

        Assert.assertTrue(atm.getMoney(1500));
    }

    @Test
    public void getMoneyTest3() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        map.put(BanknoteFaceValue.HUNDRED, 0);
        map.put(BanknoteFaceValue.THOUSAND, 0);
        map.put(BanknoteFaceValue.THOUSAND5, 0);
        Assert.assertTrue(atm.getMoney(0));

        Assert.assertFalse(atm.getMoney(1500));
    }

    @Test
    public void getMoneyTest4() throws NoSuchFieldException, IllegalAccessException {

        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);
        map.put(BanknoteFaceValue.HUNDRED, 0);
        map.put(BanknoteFaceValue.THOUSAND, 0);
        map.put(BanknoteFaceValue.THOUSAND5, 2);
        Assert.assertFalse(atm.getMoney(1000));
    }



    @Test
    public void initZeroTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);
        Map<BanknoteFaceValue, Integer> backUp = getMomentoMap(atm);
        Assert.assertArrayEquals(map.entrySet().toArray(), backUp.entrySet().toArray());
    }

    private List<Cell> getTestCells(){
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(BanknoteFaceValue.HUNDRED, 10));
        cells.add(new Cell(BanknoteFaceValue.THOUSAND, 2));
        cells.add(new Cell(BanknoteFaceValue.THOUSAND5,5));
        return cells;
    }

    @Test
    public void initTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM(getTestCells());
        Map<BanknoteFaceValue, Integer> map = getMap(atm);
        Map<BanknoteFaceValue, Integer> backUp = getMomentoMap(atm);
        Assert.assertArrayEquals(map.entrySet().toArray(), backUp.entrySet().toArray());
    }


    @Test
    public void restoreTest() throws NoSuchFieldException, IllegalAccessException {
        ATM atm = new ATM(getTestCells());

        atm.getMoney(100);
        atm.getMoney(300);
        atm.getMoney(1000);
        atm.restore();
        Map<BanknoteFaceValue, Integer> map = getMap(atm);

        Assert.assertEquals(map.get(BanknoteFaceValue.HUNDRED), new Integer(10));
        Assert.assertEquals(map.get(BanknoteFaceValue.THOUSAND), new Integer(2));

    }




}
