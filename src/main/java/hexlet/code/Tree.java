package hexlet.code;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;

public class Tree {

    private final String typeOfChange;
    private final String key;
    private final Object startingValue;
    private final Object finalValue;

    public Tree(String type, String stringKey, Object stValue, Object fValue) {
        this.typeOfChange = type;
        this.key = stringKey;
        this.startingValue = stValue;
        this.finalValue = fValue;
    }


    public final String getTypeOfChange() {
        return typeOfChange;
    }

    public final String getKey() {
        return key;
    }

    public final Object getStartingValue() {
        return startingValue;
    }

    public final Object getFinalValue() {
        return finalValue;
    }

    public static List<Tree> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
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
}
