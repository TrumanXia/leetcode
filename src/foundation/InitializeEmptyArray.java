package foundation;

import java.util.stream.Stream;

/**
 * @author 97994
 * @since 2020-08-09
 */
public class InitializeEmptyArray {
    public static void main(String[] args) {
        String[] array = new String[0];
        array = new String[]{"1", "2"};
        System.out.println(array.length);
        Stream.of(array).forEach(System.out::println);
//        System.out.println(array);
    }
}
