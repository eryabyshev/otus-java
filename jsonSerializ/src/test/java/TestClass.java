import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class TestClass{

    private int anInt = 23;
    private double aDouble = 3.14;
    private float aFloat = 9.8f;
    private boolean aBoolean = true;
    private byte aByte = 1;
    private short aShort = 127;
    private char aChar = 'a';

    private String str = "I love Java";
    List<Integer> integers = asList(10, 17, 23);



    @Override
    public boolean equals(Object obj) {
        TestClass test = (TestClass) obj;

        return this.aBoolean == test.aBoolean &&
                this.aByte == test.aByte &&
                this.aChar == test.aChar &&
                this.aDouble == test.aDouble &&
                this.aFloat == test.aFloat &&
                this.anInt == test.anInt &&
                this.aShort == test.aShort &&

                this.str.equals(test.str) &&

                Arrays.equals(this.integers.toArray(), test.integers.toArray());

    }
}