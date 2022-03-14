package formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSON {
    private static boolean isNested;

    public static String formatter(Map<String, Object> mapToFormat) {

        StringBuilder stringBuilder = new StringBuilder("{\n");
        String tab = "\t";
        if (isNested) {
            tab = "\t\t";
        }

        for (Map.Entry<String, Object> entry : mapToFormat.entrySet()) {
            stringBuilder.append(tab + "\"" + entry.getKey() + "\":");

            if (entry.getValue() != null && entry.getValue().getClass().toString().contains("List")) {
                List<Object> listOfEntries = new ArrayList<>((ArrayList) entry.getValue());
                if ((listOfEntries.get(0) instanceof String)) {
                    stringBuilder.append("[");
                    for (int i = 0; i < listOfEntries.size(); i++) {
                        if (i != listOfEntries.size() - 1) {
                            stringBuilder.append("\"" + listOfEntries.get(i) + "\",");
                        } else {
                            stringBuilder.append("\"" + listOfEntries.get(i) + "\"],\n");
                        }
                    }
                } else {
                    stringBuilder.append(entry.getValue() + ",\n");
                }
                continue;
            }

            if (entry.getValue() != null && entry.getValue().getClass().toString().contains("Map")) {
                isNested = true;
                stringBuilder.append(formatter((Map<String, Object>) entry.getValue()));
                stringBuilder.append(",\n");
                isNested = false;
                continue;
            }

            if (entry.getValue() != null && entry.getValue().getClass().toString().contains("String")) {
                stringBuilder.append("\"" + entry.getValue() + "\",\n");
                continue;
            }

            stringBuilder.append(entry.getValue() + ",\n");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        if (isNested) {
            stringBuilder.append("\t" + "}");
        } else {
            stringBuilder.append("}");
        }
        return stringBuilder.toString();
    }
}
