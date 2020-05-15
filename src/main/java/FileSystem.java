import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {
    private static final String APPLICATION_FOLDER = ".JOSMA";
    private static final String USER_FOLDER = System.getProperty("C:\\Users\\User");
    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }
}
