package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;

import static utils.Utils.*;

public class JsonUtils {

    public static JSONArray arrayToJson(Object array) throws IllegalAccessException {
        JSONArray json = new JSONArray();

        for (int i = 0; i < Array.getLength(array); i++){
            Object value = Array.get(array, i);
            buildJson(value, json);
        }

        return json;
    }

    public static JSONArray collectionToJson(Collection collection) throws IllegalAccessException {
        JSONArray json = new JSONArray();
        for(Object o : collection)
            buildJson(o, json);
        return json;

    }


    public static JSONObject objToJson(Object o) throws IllegalAccessException {
        JSONObject json = new JSONObject();
        Field[] objFields = getFields(o);

        for(Field f : objFields){
            f.setAccessible(true);
            Object field = f.get(o);

            if(isPrimitive(field) || isString(field))
                json.put(f.getName(), field);
            else if(isArray(field))
                json.put(f.getName(), arrayToJson((Object[]) field));
            else if(isCollection(field))
                json.put(f.getName(), collectionToJson((Collection) field));
            else
                json.put(f.getName(), objToJson(field));
        }
        return json;
    }


    private static void buildJson(Object o, JSONArray json) throws IllegalAccessException {
        if(isPrimitive(o) || isString(o))
            json.add(o);
        else if(isArray(o))
            json.add(arrayToJson(o));
        else if(isCollection(o))
            json.add(collectionToJson((Collection) o));
        else
            json.add(objToJson(o));
    }


    public static String buildToJson(Object o) throws IllegalAccessException {
        if(o == null)
            return "{}";
        else if(isString(o) || o instanceof Character)
            return "\"" + o.toString() + "\"";
        else if(isPrimitive(o))
            return o.toString();
        else if(isArray(o))
            return arrayToJson(o).toString();
        else if(isCollection(o))
            return collectionToJson((Collection) o).toString();
        else
            return objToJson(o).toJSONString();
    }


}
