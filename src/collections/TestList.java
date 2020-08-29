package collections;

import proxy.gupao.com.gupao.vip.proxy.client.Animal;
import proxy.gupao.com.gupao.vip.proxy.client.Dog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 97994
 * @since 2020-08-16
 */
public class TestList {
    public static void main(String[] args) {
//        List<? extends Animal> animals = new ArrayList<>();
        List<? super Animal> animals = new ArrayList<>();
        animals.add(new Dog());
    }
}
