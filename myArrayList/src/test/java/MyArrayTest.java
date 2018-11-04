import org.junit.Assert;
import org.junit.Test;
import ru.evgeny.list.MyArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.Assert.*;

public class MyArrayTest {

    @Test
    public void sizeTestEmptyList(){
        List<String> list = new MyArrayList<String>();
        assertEquals(0, list.size());
    }

    @Test
    public void includeAllelements(){
        List<String> myArray = new MyArrayList<String>();
        List<String> template = new ArrayList<String>();

        addAll(template, "Apple", "Cherry", "Orange", "Strawberry");
        myArray.add("Apple");
        myArray.add("Cherry");
        myArray.add("Orange");
        myArray.add("Strawberry");
        assertArrayEquals(template.toArray(), myArray.toArray());
    }
}
