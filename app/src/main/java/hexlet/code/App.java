package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {

    @Parameters(description = "path to first file")
    private String filepath1;

    @Parameters(description = "path to second file")
    private String filepath2;

    @Parameters(description = "choose format you want")
    private String formatName;

    @Option(names = {"-f", "--format "}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        String diff = Parser.generate(filepath1, filepath2, formatName);
        System.out.println(diff);
        return 0;
    }
}
