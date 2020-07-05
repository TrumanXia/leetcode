package leetcode.backtrace;

public class Robot {
    private int gridNum = 0;
    private boolean[][] entered;
    private int[][] enterCounter;
/*11
8*/
    public static void main(String[] args) {
        System.out.println(new Robot().movingCount(11, 8, 16));
//        System.out.println(new Robot().movingCount(2, 3, 100));
    }
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        entered = new boolean[m + 1][n + 1];
        enterCounter = new int[m + 1][n + 1];
        // 从坐标 (0, 0) 进入
        dfs(m, n, 0, 0, k);
        return gridNum;
    }

    private void dfs(int m, int n, int curPosM, int curPosN, int k) {
        if (curPosM < 0 || curPosM > m - 1 || curPosN < 0 || curPosN > n - 1) {
            return;
        }
//        System.out.println(curPosM + " " + curPosN + " " + k );
//        System.out.println(entered[curPosM][curPosN]);
        if (biggerThanK(curPosM, curPosN, k) || entered[curPosM][curPosN]) {
//            System.out.println("tr");
            return;
        }
        System.out.println(entered[curPosM][curPosN]);

        if (++enterCounter[curPosM][curPosN] == 1) gridNum ++;

        for (int i = -1; i <= 1; i += 2) {
            entered[curPosM][curPosN] = true;
            dfs(m, n, curPosM + i, curPosN, k);
//            entered[curPosM][curPosN] = false;
        }
        for (int i = -1; i <= 1; i += 2) {
            entered[curPosM][curPosN] = true;
            dfs(m, n, curPosM, curPosN + i, k);
//            entered[curPosM][curPosN] = false;
        }

//        dfs(m, n, curPosM - 1, curPosN, k);
//        dfs(m, n, curPosM, curPosN + 1, k);
//        dfs(m, n, curPosM, curPosN - 1, k);


//        return;
    }

    private boolean biggerThanK(int curPosM, int curPosN, int k) {
        int sumM = 0, sumN = 0;
        while(curPosM > 0){
            sumM += curPosM % 10;
            curPosM /=10;
//            System.out.println(curPosM);
        }
        while (curPosN > 0) {
            sumN += curPosN % 10;
            curPosN /= 10;
        }
        boolean res = (sumM + sumN) > k;

//        System.out.println(res);
//        if(res == true) System.out.println(res);;
        return res;
    }
}
