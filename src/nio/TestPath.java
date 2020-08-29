package nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 97994
 * @since 2020-08-29
 */
public class TestPath {
    public static void main(String[] args) {
        // Path path = Paths.get("nio", "TestPath.java");
        Path path = Paths.get("E:\\EclipseWorkspace2\\leetcode\\src\\nio\\TestPath.java");
        System.out.println(path.toAbsolutePath());
        System.out.println(Files.exists(path));
    }
}
