package app;

import hexlet.code.Differ;
import hexlet.code.Parser;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Map;

class AppTest {
    @Test
    void testGenDiffJSON() throws IOException {
        Map<String, Object> firstJsonFile = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        Map<String, Object> secondJsonFile = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

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
        String result = Differ.genDiff(firstJsonFile, secondJsonFile);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testGenDiffYAML() throws IOException {

        Map<String, Object> map1 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file1.yml");
        Map<String, Object> map2 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file2.yml");

        String formatName = "";

        String expectedString = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        String result = Differ.genDiff(map1, map2);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testPlainFormatJSON() throws IOException {
        Map<String, Object> map1 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        Map<String, Object> map2 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

        String formatName = "plain";

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

        String result = Differ.genDiff(map1, map2, formatName);
        assertThat(result).isEqualTo(expectedString);
    }

    @Test
    void testOutputAsJSON() throws IOException {
        Map<String, Object> map1 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file1.json");
        Map<String, Object> map2 = Parser.getData(
                "/home/wtffka/java-project-lvl2/src/test/resources/file2.json");

        String formatName = "json";

        String expectedString = "{\n"
                + "\t\"chars1\":[\"a\",\"b\",\"c\"],\n"
                + "\t\" - chars2\":[\"d\",\"e\",\"f\"],\n"
                + "\t\" + chars2\":false,\n"
                + "\t\" - checked\":false,\n"
                + "\t\" + checked\":true,\n"
                + "\t\" - default\":null,\n"
                + "\t\" + default\":[\"value1\",\"value2\"],\n"
                + "\t\" - id\":45,\n"
                + "\t\" + id\":null,\n"
                + "\t\" - key1\":\"value1\",\n"
                + "\t\" + key2\":\"value2\",\n"
                + "\t\"numbers1\":[1, 2, 3, 4],\n"
                + "\t\" - numbers2\":[2, 3, 4, 5],\n"
                + "\t\" + numbers2\":[22, 33, 44, 55],\n"
                + "\t\" - numbers3\":[3, 4, 5],\n"
                + "\t\" + numbers4\":[4, 5, 6],\n"
                + "\t\" + obj1\":{\n"
                + "\t\t\"nestedKey\":\"value\",\n"
                + "\t\t\"isNested\":true\n"
                + "\t},\n"
                + "\t\" - setting1\":\"Some value\",\n"
                + "\t\" + setting1\":\"Another value\",\n"
                + "\t\" - setting2\":200,\n"
                + "\t\" + setting2\":300,\n"
                + "\t\" - setting3\":true,\n"
                + "\t\" + setting3\":\"none\"\n"
                + "}";

        String result = Differ.genDiff(map1, map2, formatName);
        assertThat(result).isEqualTo(expectedString);
    }
}
