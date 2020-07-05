package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Boolean>> futures = new ArrayList<>();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 1000, 2000,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        for (int i = 0; i < 5; i++) {
            futures.add(threadPoolExecutor.submit(() -> {
                    Thread.sleep(1000);
                    return true;
            }));
        }
        System.out.println(futures.size());
        for (Future<Boolean> future : futures) {
            future.get();
        }
        System.out.println(futures.size());
        threadPoolExecutor.shutdown();
//        持续会报错
//        threadPoolExecutor.submit(() -> {
//
//        });
    }
}
