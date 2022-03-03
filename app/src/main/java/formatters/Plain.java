package formatters;

import java.util.Map;

public class Plain {

    private static final int CHARSTODELETE = 3;

    public static String formatter(Map<String, Object> sortedMap) {
        String s;
        Map<String, Object> changedMap = changeSomeValuesInMap(sortedMap);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : changedMap.entrySet()) {
            if (entry.getKey().startsWith(" -")) {
                s = entry.getKey().replace("-", "+");
                if (changedMap.containsKey(s)) {
                    builder.append("Property '" + entry.getKey().substring(CHARSTODELETE) + "' was updated. From "
                            + entry.getValue() + " to " + changedMap.get(s) + "\n");
                } else {
                    builder.append("Property '" + entry.getKey().substring(CHARSTODELETE) + "' was removed" + "\n");
                }
            }
            if (entry.getKey().startsWith(" +")
                    && !builder.toString().contains(entry.getKey().substring(CHARSTODELETE))) {
                builder.append("Property '" + entry.getKey().substring(CHARSTODELETE) + "' was added with value: "
                        + entry.getValue() + "\n");
            }
        }
        return builder.toString();
    }

    public static Map<String, Object> changeSomeValuesInMap(Map<String, Object> mapToChange) {
        for (Map.Entry<String, Object> entry : mapToChange.entrySet()) {
            if (entry.getValue() != null) {
                if (entry.getValue().getClass().toString().contains("String")) {
                    entry.setValue("'" + entry.getValue() + "'");
                }
                if (entry.getValue().getClass().toString().contains("Array")
                        || entry.getValue().getClass().toString().contains("Map")) {
                    entry.setValue("[complex value]");
                }
            }
        }
        return mapToChange;
    }
}
