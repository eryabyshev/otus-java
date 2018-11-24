package utils;

import java.lang.reflect.Field;
import java.util.Collection;

public class Utils {

    public static boolean isPrimitive(Object obj){
        return obj instanceof Integer || obj instanceof Float || obj instanceof Double || obj instanceof Short ||
                obj instanceof Byte || obj instanceof Boolean || obj instanceof Long || obj instanceof Character;
    }

    public static boolean isString(Object obj){
        return obj instanceof String;
    }

    public static boolean isArray(Object obj){
        return obj.getClass().isArray();
    }


    public static boolean isCollection(Object obj){
        return obj instanceof Collection;
    }

    public static Field[] getFields(Object obj){
        return  obj.getClass().getDeclaredFields();
    }
}
