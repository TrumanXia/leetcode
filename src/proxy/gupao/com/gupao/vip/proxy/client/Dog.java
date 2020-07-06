package proxy.gupao.com.gupao.vip.proxy.client;

public class Dog extends Animal {
    @Override
    public void bark() {
        System.out.println("i am barking!");
    }

    public static void main(String[] args) {
        System.out.println(Dog.class.getSuperclass());
    }
}
