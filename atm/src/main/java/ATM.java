
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class ATM {

    private Map<BanknoteFaceValue, Integer> money = new HashMap<BanknoteFaceValue, Integer>();


    public ATM(){
        money.put(BanknoteFaceValue.HUNDRED, 0);
        money.put(BanknoteFaceValue.HUNDRED5, 0);
        money.put(BanknoteFaceValue.THOUSAND, 0);
        money.put(BanknoteFaceValue.THOUSAND5, 0);
    }


    public void takeMoney(BanknoteFaceValue input){
        Integer value = money.get(input);
        value++;
        money.put(input, value);
    }


    public void takeMoney(BanknoteFaceValue... input){
        for(BanknoteFaceValue b : input)
            takeMoney(b);
    }


    private BanknoteFaceValue getBanknoteFaceValue(int input){

        for(BanknoteFaceValue b : BanknoteFaceValue.values()){
            if(b.getValue() == input)
                return b;
        }
        return null;
    }


    public void takeMoney(int input){

        BanknoteFaceValue b = getBanknoteFaceValue(input);
        if(b != null) {
            Integer value = money.get(b);
            value++;
            money.put(b, value);
        }
        else{
            System.err.println("I can not accept this bill");
        }
    }

    public void takeMoney(int... input){
        for(int i : input)
            takeMoney(i);
    }


    public int sumAllMoney(){
        int sum = 0;
        for (Map.Entry<BanknoteFaceValue, Integer>entry : money.entrySet())
            sum += entry.getKey().getValue() * entry.getValue();
        return sum;
    }


    private boolean canMinus(int money, BanknoteFaceValue b){
        return (money - b.getValue() >= 0);
    }

    private Map doThreeMap(){

        Map<BanknoteFaceValue, Integer> temp = new TreeMap<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<BanknoteFaceValue, Integer>entry : money.entrySet()){
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }


    public boolean getMoney(int input){

        if(input > sumAllMoney()){
            System.out.println("Not enough funds for the operation");
            return false;
        }

        Map<BanknoteFaceValue, Integer> mapCopy = doThreeMap();

        for (Map.Entry<BanknoteFaceValue, Integer> entry : mapCopy.entrySet()){
            if(entry.getValue() == 0) continue;
            int count = entry.getValue();
            int minus = 0;
            for(int i = 0; i < count; i++){
                if(canMinus(input, entry.getKey())) {
                    minus++;
                    input -= entry.getKey().getValue();
                }else break;
            }
            mapCopy.put(entry.getKey(), mapCopy.get(entry.getKey()) - minus);
        }
        if(input == 0){
            money = mapCopy;
            return true;
        }
        return false;

    }
    



}
