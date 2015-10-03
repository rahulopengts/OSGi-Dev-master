package com.intellizones.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParsing {
static JsonParser parser = new JsonParser();

public static void main (String[] str){
	String strr	=	"{\"id\" : 12345, \"days\" : [ \"Monday\", \"Wednesday\" ], \"person\" : { \"firstName\" : \"David\", \"lastName\" : \"Menoyo\" } }";
	//"{"id" : 12345, "days" : [ "Monday", "Wednesday" ], "person" : { "firstName" : "David", "lastName" : "Menoyo" } }";
	
	HashMap h	=	createHashMapFromJsonString(strr);
	Object s=	h.get("person");
	System.out.println(s);
	System.out.println(s.getClass());

}
public static HashMap<String, Object> createHashMapFromJsonString(String json) {
System.out.println(json);
    JsonObject object = (JsonObject) parser.parse(json);
    Set<Map.Entry<String, JsonElement>> set = object.entrySet();
    Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
    HashMap<String, Object> map = new HashMap<String, Object>();

    while (iterator.hasNext()) {

        Map.Entry<String, JsonElement> entry = iterator.next();
        String key = entry.getKey();
        JsonElement value = entry.getValue();

        if (null != value) {
            if (!value.isJsonPrimitive()) {
                if (value.isJsonObject()) {

                    map.put(key, createHashMapFromJsonString(value.toString()));
                } else if (value.isJsonArray() && value.toString().contains(":")) {

                    List<HashMap<String, Object>> list = new ArrayList();
                    JsonArray array = value.getAsJsonArray();
                    if (null != array) {
                        for (JsonElement element : array) {
                            list.add(createHashMapFromJsonString(element.toString()));
                        }
                        map.put(key, list);
                    }
                } else if (value.isJsonArray() && !value.toString().contains(":")) {
                    map.put(key, value.getAsJsonArray());
                }
            } else {
                map.put(key, value.getAsString());
            }
        }
    }
    return map;
}
}