package app;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    @Test
    void testGenDiffJSON() throws IOException {

        String filepath1 = ("/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        String filepath2 = ("/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

        String formatName = "stylish";

        String expectedString = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";
        String result = Differ.generate(filepath1, filepath2, formatName);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testGenDiffYAML() throws IOException {

        String filepath1 = ("/home/wtffka/java-project-lvl2/src/test/resources/file1.yml");
        String filepath2 = ("/home/wtffka/java-project-lvl2/src/test/resources/file2.yml");

        String formatName = "";

        String expectedString = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String result = Differ.generate(filepath1, filepath2, formatName);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testPlainFormatJSON() throws IOException {
        String filepath1 = ("/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        String filepath2 = ("/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

        String formatName = "plain";

        String result = Differ.generate(filepath1, filepath2, formatName);

        String expectedString = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        assertThat(result).isEqualTo(expectedString);
    }

    @Test
    void testOutputAsJSON() throws IOException {
        String filepath1 = ("/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        String filepath2 = ("/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

        String formatName = "json";

        String expectedString = Files.readString(
                Paths.get("/home/wtffka/java-project-lvl2/src/test/resources/jsonString"));

        String result = Differ.generate(filepath1, filepath2, formatName);
        assertThat(result).isEqualTo(expectedString);
    }
}
