import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.JsonUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class JsonSerializeTest {

    public Gson gson = new Gson();

    @Test
    public void toJsonForPrimitiveTest() throws IllegalAccessException {
        byte b = Byte.MIN_VALUE;
        short s = Short.MAX_VALUE;
        int i = Integer.MIN_VALUE;
        float f = Float.MAX_VALUE;
        double d = Double.MIN_VALUE;
        long l = 1234567890l;

        assertTrue(JsonUtils.buildToJson(b).equals(gson.toJson(b)));
        assertTrue(JsonUtils.buildToJson(s).equals(gson.toJson(s)));
        assertTrue(JsonUtils.buildToJson(i).equals(gson.toJson(i)));
        assertTrue(JsonUtils.buildToJson(f).equals(gson.toJson(f)));
        assertTrue(JsonUtils.buildToJson(d).equals(gson.toJson(d)));
        assertTrue(JsonUtils.buildToJson(l).equals(gson.toJson(l)));
    }


    @Test
    public void toJsonForStringTest() throws IllegalAccessException {
        String str = "Test String";
        assertTrue(JsonUtils.buildToJson(str).equals(gson.toJson(str)));
    }

    @Test
    public void toJsonForBooleanTest() throws IllegalAccessException {
        boolean bool = true;
        assertTrue(JsonUtils.buildToJson(bool).equals(gson.toJson(bool)));
    }


    @Test
    public void toJsonForArrayTest() throws IllegalAccessException {
        int[] array = {10, 11, 12, 13};
        assertTrue(JsonUtils.buildToJson(array).equals(gson.toJson(array)));
    }

    @Test
    public void toJsonForStringArrayTest() throws IllegalAccessException {
        String[] bool = {"10", "11", "12", "13"};
        assertTrue(JsonUtils.buildToJson(bool).equals(gson.toJson(bool)));
    }


    @Test
    public void testClassToJsonTest() throws IllegalAccessException {
        TestClass t = new TestClass();
        char[] my = JsonUtils.buildToJson(t).replaceAll("\"", "").toCharArray();
        char[] json = gson.toJson(t).replaceAll("\"", "").toCharArray();
        Arrays.sort(my);
        Arrays.sort(json);
        Assert.assertArrayEquals(my, json);


    }





}
