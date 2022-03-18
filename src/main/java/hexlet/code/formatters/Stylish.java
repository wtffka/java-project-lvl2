package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.List;

public class Stylish {

    private static final String WSPACE = " ";
    private static final int AMOUNT_OF_WSPACES_IF_NOTHING = 4;

    public static String formatter(List<Tree> diffTree) {
        StringBuilder diffBuilder = new StringBuilder("{\n");

        for (Tree pair : diffTree) {
            String key = pair.getKey();
            Object startingValue = pair.getStartingValue();
            Object finalValue = pair.getFinalValue();
            String typeOfChange = pair.getTypeOfChange();

            switch (typeOfChange) {

                case "removed":
                    diffBuilder.append(WSPACE.repeat(2) + "-" + WSPACE + key + ":" + WSPACE + startingValue + "\n");
                    break;

                case "added":
                    diffBuilder.append(WSPACE.repeat(2) + "+" + WSPACE + key + ":" + WSPACE + finalValue + "\n");
                    break;

                case "unchanged":
                    diffBuilder.append(WSPACE.repeat(AMOUNT_OF_WSPACES_IF_NOTHING) + key + ":" + WSPACE + startingValue
                            + "\n");
                    break;

                case "changed":
                    diffBuilder.append(WSPACE.repeat(2) + "-" + WSPACE + key + ":" + WSPACE + startingValue + "\n"
                            + WSPACE.repeat(2) + "+" + WSPACE + key + ":" + WSPACE + finalValue + "\n");
                    break;

                default: break;
            }
        }
        diffBuilder.append("}");
        return diffBuilder.toString();
    }
}
