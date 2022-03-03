package formatters;

import java.util.Map;

public class Stylish {
    private static String whiteSpace = " ";
    private static final int AMOUNTOFWHITESPACES = 3;

    public static String formatter(Map<String, Object> sortedMap) {
        StringBuilder builder = new StringBuilder("{\n");

        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            if (!entry.getKey().startsWith(whiteSpace)) {
                builder.append("\t" + whiteSpace.repeat(AMOUNTOFWHITESPACES) + entry.getKey() + ":" + whiteSpace
                        + entry.getValue() + "\n");
                continue;
            }
            builder.append("\t" + entry.getKey() + ":" + whiteSpace + entry.getValue() + "\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
