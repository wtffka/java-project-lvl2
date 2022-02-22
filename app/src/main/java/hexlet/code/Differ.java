package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;


public class Differ {

    public static String genDiff(Map<String, Object> map1, Map<String, Object> map2) throws JsonProcessingException {
        List<Map.Entry<String, Object>> entries = new ArrayList<>();
        for (Map.Entry s : map1.entrySet()) {

            String negativeKey = " - " + s.getKey();
            String positiveKey = " + " + s.getKey();

            if (!map2.containsKey(s.getKey())) {
                entries.add(new AbstractMap.SimpleEntry(negativeKey, s.getValue()));
            } else if (s.getValue().equals(map2.get(s.getKey()))) {
                entries.add(new AbstractMap.SimpleEntry(s.getKey(), s.getValue()));
            } else {
                entries.add(new AbstractMap.SimpleEntry(negativeKey, s.getValue()));
                entries.add(new AbstractMap.SimpleEntry(positiveKey, map2.get(s.getKey())));
            }
        }
        for (Map.Entry s : map2.entrySet()) {

            String positiveKey = " + " + s.getKey();

            if (!map1.containsKey(s.getKey())) {
                entries.add(new AbstractMap.SimpleEntry(positiveKey, s.getValue()));
            }
        }

        Collections.sort(entries, (a, b) -> {
            if (a.getKey().contains(" ")) {
                if (b.getKey().contains(" ")) {
                    return a.getKey().split(" ")[2].compareTo(b.getKey().split(" ")[2]);
                } else {
                    return a.getKey().split(" ")[2].compareTo(b.getKey());
                }
            } else {
                if (b.getKey().contains(" ")) {
                    return a.getKey().compareTo(b.getKey().split(" ")[2]);
                } else {
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });

        Map<String, Object> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        StringBuilder builder = new StringBuilder("{\n");

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            if (!entry.getKey().startsWith(" ")) {
                builder.append("\t" + "   " + entry.getKey() + ": " + entry.getValue() + "\n");
                continue;
            }
            builder.append("\t" + entry.getKey() + ": " + entry.getValue() + "\n");
        }
        builder.append("}");

        return builder.toString();
    }
}

