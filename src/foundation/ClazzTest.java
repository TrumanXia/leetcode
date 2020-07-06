package foundation;

public class ClazzTest {
    public static void main(String[] args) {
        System.out.println(Dog.class.getClasses().length);
    }

    static class Dog extends Thread{

    }
}
