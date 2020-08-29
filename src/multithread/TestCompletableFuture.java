package multithread;

/**
 * @author 97994
 * @since 2020-08-26
 */
public class TestCompletableFuture {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        new Thread(new Task()).start();
//        new Thread(new Task()).start();
//        CompletableFuture.runAsync(new Task())
        System.out.println("s");
        System.out.println(System.currentTimeMillis() - start);
    }

    public static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("ss");
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
