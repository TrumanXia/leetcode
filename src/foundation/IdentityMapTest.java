package foundation;

import java.util.IdentityHashMap;

/**
 * IdentityMapTest key 比较的是引用 == ， 而不是Object.equals方法
 *
 * @author 97994
 * @since 2020-07-19
 */

public class IdentityMapTest {
    public static void main(String[] args) {
        IdentityHashMap<Object, Object> objectObjectIdentityHashMap = new IdentityHashMap<>();
        objectObjectIdentityHashMap.put(1, 2);
        objectObjectIdentityHashMap.put(1, 3);
        String s = new String("1");
        objectObjectIdentityHashMap.put(s, 5);
        objectObjectIdentityHashMap.put(new String("1"), 3);
        System.out.println(objectObjectIdentityHashMap.get(s));
    }
}
