package foundation;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author 97994
 * @since 2020-08-09
 */
class ClassA<K, V> {
    protected Map<K, V> map;
    String hell;
}

class SubClass<T> extends ClassA<T, T> {
    Map<T, T> map;
}

public class TestType {
    public static void main(String[] args) throws NoSuchFieldException {
        SubClass<Long> longSubClass = new SubClass<>();

        Field map = ClassA.class.getDeclaredField("map");
        // System.out.println(ClassA.class.getDeclaredField("hell").getGenericType());
        // System.out.println(ClassA.class.getDeclaredField("hell").getAnnotatedType());
        // System.out.println(map.getGenericType());
        // System.out.println(map.getGenericType() instanceof ParameterizedType);

        System.out.println(longSubClass.getClass().getDeclaredField("map").getGenericType());
    
        // 需要mybatis的支持


    }

}
