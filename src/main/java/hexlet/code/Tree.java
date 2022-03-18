package hexlet.code;

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
}
