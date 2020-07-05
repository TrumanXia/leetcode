package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest {
    /**
     * 测试数据库连接池
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        JdbcUtil util = new JdbcUtil();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), 100, 1000, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(10));
        for (int i = 0; i < 10; i++) {
//            多线程下会有问题
            threadPoolExecutor.execute(() -> {
                try {
                    Connection conn = util.getConnection();
                    if(conn != null){
                        System.out.println("我得到了一个连接");
                    }
                    util.CloseConnection(conn, null, null);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}
