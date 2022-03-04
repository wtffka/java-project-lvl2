package hexlet.code;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;


public class Differ {

    private static final String WHITESPACE = " ";

    public static String genDiff(Map<String, Object> map1, Map<String, Object> map2, String formatName) {
        List<Map.Entry<String, Object>> entries = new ArrayList<>();
        for (Map.Entry s : map1.entrySet()) {

            String negativeKey = WHITESPACE + "-" + WHITESPACE + s.getKey();
            String positiveKey = WHITESPACE + "+" + WHITESPACE + s.getKey();

            if (!map2.containsKey(s.getKey())) {
                entries.add(new AbstractMap.SimpleEntry(negativeKey, s.getValue()));
            } else if (s.getValue() != null && s.getValue().equals(map2.get(s.getKey()))) {
                entries.add(new AbstractMap.SimpleEntry(s.getKey(), s.getValue()));
            } else {
                entries.add(new AbstractMap.SimpleEntry(negativeKey, s.getValue()));
                entries.add(new AbstractMap.SimpleEntry(positiveKey, map2.get(s.getKey())));
            }
        }
        for (Map.Entry s : map2.entrySet()) {

            String positiveKey = WHITESPACE + "+" + WHITESPACE + s.getKey();

            if (!map1.containsKey(s.getKey())) {
                entries.add(new AbstractMap.SimpleEntry(positiveKey, s.getValue()));
            }
        }

        entries.sort((a, b) -> {
            if (a.getKey().contains(WHITESPACE)) {
                if (b.getKey().contains(WHITESPACE)) {
                    return a.getKey().split(WHITESPACE)[2].compareTo(b.getKey().split(WHITESPACE)[2]);
                } else {
                    return a.getKey().split(WHITESPACE)[2].compareTo(b.getKey());
                }
            } else {
                if (b.getKey().contains(WHITESPACE)) {
                    return a.getKey().compareTo(b.getKey().split(WHITESPACE)[2]);
                } else {
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });

        Map<String, Object> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return Formatter.chooseFormat(formatName, sortedMap);
    }
}
