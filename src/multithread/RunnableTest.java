package multithread;

public class RunnableTest {
    public static void main(String[] args) {
        new Runnable(){

            @Override
            public void run() {
                System.out.println("ss");
            }
        };

        int[] ints = new int[0];
        ints[0] = 1;
        System.out.println(ints.length);
    }
}
