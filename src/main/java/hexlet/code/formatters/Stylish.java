package hexlet.code.formatters;

import hexlet.code.Tree;

import java.util.List;

public class Stylish {

    private static final String WSPACE = " ";

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
                    diffBuilder.append(WSPACE.repeat(2) + "+ " + key + ": " + finalValue + "\n");
                    break;

                case "unchanged":
                    diffBuilder.append(WSPACE.repeat(2).repeat(2) + key + ": " + startingValue + "\n");
                    break;

                case "changed":
                    diffBuilder.append(WSPACE.repeat(2) + "- " + key + ": " + startingValue + "\n"
                            + WSPACE.repeat(2) + "+ " + key + ": " + finalValue + "\n");
                    break;

                default: break;
            }
        }
        diffBuilder.append("}");
        return diffBuilder.toString();
    }

}
