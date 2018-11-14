import main.java.ATM;
import main.java.BanknoteFaceValue;
import main.java.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DepartmentAtmTest {


    public List<Cell> getCellsList(int h, int h5, int t, int t5){
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(BanknoteFaceValue.HUNDRED, h));
        cells.add(new Cell(BanknoteFaceValue.HUNDRED5, h5));
        cells.add(new Cell(BanknoteFaceValue.THOUSAND, t));
        cells.add(new Cell(BanknoteFaceValue.THOUSAND5, t5));
        return cells;
    }


    public void getMoneyForAllAtm(Departament departament){
        List<ATM> atms = departament.getAtms();
        int withdraw = 100;
        for (ATM a : atms){
            a.getMoney(withdraw);
            withdraw+=200;
        }
    }

    public List<ATM> getAtms(){
        List<ATM> atms = new ArrayList<ATM>();
        atms.add(new ATM(getCellsList(1,1,1,1)));
        atms.add(new ATM(getCellsList(2, 2, 2, 2)));
        atms.add(new ATM(getCellsList(3, 3, 3, 3)));
        atms.add(new ATM(getCellsList(4, 4, 4, 4)));
        return atms;
    }




    @Test
    public void getAllMoneyTest(){
        Departament departament = new Departament(getAtms());
        Assert.assertTrue(departament.getAllMoney() == 66000);
    }

    private Map<BanknoteFaceValue, Integer> getMap(Object clazz, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (Map<BanknoteFaceValue, Integer>) field.get(clazz);
    }


    public boolean cmpArrays(List<ATM> a, List<ATM> b) throws NoSuchFieldException, IllegalAccessException {

        if(a.size() != b.size())
            return false;

        for(int i = 0; i < a.size(); i++){
                Map<BanknoteFaceValue, Integer> mapA = getMap(a.get(i), "money");
                Map<BanknoteFaceValue, Integer> mapB = getMap(b.get(i), "money");
                if(!Arrays.equals(mapA.entrySet().toArray(), mapB.entrySet().toArray()))
                    return false;
        }
        return true;


    }


    @Test
    public void restoreTest() throws NoSuchFieldException, IllegalAccessException {
        Departament departament = new Departament(getAtms());
        getMoneyForAllAtm(departament);
        departament.restore();
        Assert.assertTrue(cmpArrays(departament.getAtms(),  getAtms()));
    }



}
