package foundation;

import java.io.File;

/**
 * @author 97994
 * @since 2020-08-08
 */
public class TestFile {
    public static void main(String[] args) {
        File file = new File("F:\\BaiduNetdiskDownload");
        System.out.println(file.isDirectory());
    }
}
