package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author 97994
 * @since 2020-08-15
 */
public class TestIo {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.xml");
    }
}
