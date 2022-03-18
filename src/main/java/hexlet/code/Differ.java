package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;


public class Differ {

    public static List<Tree> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>();

        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        List<Tree> allDifferences = new ArrayList<>();

        for (String key : allKeys) {
            Object startingValue = map1.get(key);
            Object finalValue = map2.get(key);

            if (!map2.containsKey(key)) {
                allDifferences.add(new Tree("removed", key, startingValue, finalValue));
            } else if (!map1.containsKey(key)) {
                allDifferences.add(new Tree("added", key, startingValue, finalValue));
            } else if (Objects.equals(startingValue, finalValue)) {
                allDifferences.add(new Tree("unchanged", key, startingValue, finalValue));
            } else {
                allDifferences.add(new Tree("changed", key, startingValue, finalValue));
            }
        }

        return allDifferences;
    }

    public static String generate(String filepath1, String filepath2, String formatName) throws IOException {
        Map<String, Object> firstFileToMap = Parser.getData(filepath1);
        Map<String, Object> secondFileToMap = Parser.getData(filepath2);

        List<Tree> diffTree = genDiff(firstFileToMap, secondFileToMap);

        return Formatter.chooseFormat(diffTree, formatName);
    }

    public static String getStringFromFile(String filepath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filepath)));
    }

}
