package foundation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 97994
 * @since 2020-08-09
 */
interface SuperClass<T> {
    void method(T t);

    List<T> get();
}

public class AClass implements SuperClass<String> {
    @Override
    public void method(String s) {
        System.out.println(s);
    }

    @Override
    public ArrayList<String> get() {
        return null;
    }
}

/**
 * 编译时去掉泛型(泛型擦除)后是这样的，泛型T都被替换为了Object
 **/
// public interface SuperClass {
// void method(Object t);
// }
// public class AClass implements SuperClass {
// public void method(String s) {
// System.out.println(s);
// }
// public void method(Object s) {//桥接方法
// this.method((String) s);
// }
// }

// javap -p AClass.class 可以查看反编译以上结果
