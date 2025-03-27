package common.features.collectionspractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("A", "abc");
        myMap.put("B", "bcd");
        myMap.put("C", "SELECT $A from $B");

        for (Map.Entry<String, String> element : myMap.entrySet()) {
            if (element.getValue().contains("$")) {
                StringBuilder newValue = new StringBuilder();
                char[] value = element.getValue().toCharArray();
                for (int i = 0; i < value.length; i++) {
                    if (value[i] == '$') {
                        newValue.append(myMap.get(String.valueOf(value[i + 1])));
                        i++;
                    } else {
                        newValue.append(value[i]);
                    }
                }
                element.setValue(newValue.toString());
            }
        }

        myMap.entrySet().forEach(System.out::println);
    }
}
