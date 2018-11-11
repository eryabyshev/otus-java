import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Map;

public class ATMTest {



    private Map<BanknoteFaceValue, Integer> getMap(Object clazz) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getClass().getDeclaredField("money");
        field.setAccessible(true);
        return (Map<BanknoteFaceValue, Integer>) field.get(clazz);
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




}
