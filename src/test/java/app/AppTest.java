package app;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {

    private static String stylishJSON = "src/test/resources/fixtures/stylishJSON";
    private static String stylishYML = "src/test/resources/fixtures/stylishYML";
    private static String plain = "src/test/resources/fixtures/Plain";
    private static String json = "src/test/resources/fixtures/json";

    @Test
    void testGenDiffJSON() throws IOException {

        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");

        String expectedString = Files.readString(Paths.get(stylishJSON));

        String result = Differ.generate(filepath1, filepath2);
        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testGenDiffYAML() throws IOException {

        String filepath1 = ("src/test/resources/file1.yml");
        String filepath2 = ("src/test/resources/file2.yml");
        String result = Differ.generate(filepath1, filepath2);

        String expectedString = Files.readString(Paths.get(stylishYML));

        assertThat(result).isEqualTo(expectedString);

    }

    @Test
    void testPlainFormatJSON() throws IOException {
        String formatName = "plain";

        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");
        String result = Differ.generate(filepath1, filepath2, formatName);

        String expectedString = Files.readString(Paths.get(plain));

        assertThat(result).isEqualTo(expectedString);
    }

    @Test
    void testOutputAsJSON() throws IOException {
        String filepath1 = ("src/test/resources/file1.json");
        String filepath2 = ("src/test/resources/file2.json");

        String formatName = "json";

        String expectedString = Files.readString(
                Paths.get(json));

        String result = Differ.generate(filepath1, filepath2, formatName);
        assertThat(result).isEqualTo(expectedString);
    }
}
