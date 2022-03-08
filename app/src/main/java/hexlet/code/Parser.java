package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String filepath) throws IOException {
        ObjectMapper objectMapper = MapperFactory.getMapper(filepath);
        String content = new String(Files.readAllBytes(Paths.get(filepath)));
        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }

}
