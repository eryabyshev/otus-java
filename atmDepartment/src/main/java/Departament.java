import main.java.ATM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Departament {

    private List<ATM> atms;

    public Departament(){
        atms = new ArrayList<ATM>();
    }

    public List<ATM> getAtms(){
        return atms;
    }

    public void addAtms(Collection<ATM> atms){
        atms.addAll(atms);
    }


    public Departament(List<ATM> atms){
        this.atms = atms;
    }

    public void addAtm(ATM atm){
        atms.add(atm);
    }

    public long getAllMoney(){
        long sum = 0;
        for (ATM atm : atms)
            sum += atm.sumAllMoney();
        return sum;
    }

    public void restore(){
        for (ATM atm : atms)
            atm.restore();
    }

}
