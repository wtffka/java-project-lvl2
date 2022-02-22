package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class MapperFactory {
    public static ObjectMapper getMapper(String filepath) {
        if (filepath.contains(".json")) {
            return new ObjectMapper();
        }
        return new ObjectMapper(new YAMLFactory());
    }
}
