package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String generate(String filepath1, String filepath2) throws IOException {
        String firstFileToString = readUsingFiles(filepath1);
        String secondFileToString = readUsingFiles(filepath2);
        Map<String,Object> firstFileToMap = getData(firstFileToString);
        Map<String,Object> secondFileToMap = getData(secondFileToString);
        return genDiff(firstFileToMap, secondFileToMap);
    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static Map<String, Object> getData(String content) throws IOException {
        Map<String, Object> map = mapper.readValue(content, new TypeReference<Map<String, Object>>() {});
        return map;
    }

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
            if(a.getKey().contains(" ")) {
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

