package leetcode.dynamic.planing;

import leetcode.tool.Util;

/**
 *  N = 3, W = 4
 *
 *  wt = [2, 1, 3]
 *  val = [4, 2, 3]
 *
 *  状态有物品数目 和 重量 dp是二维数组。
 *  初始化 为dp[0][...] = dp[...][0] = 0;
 *  dp[n][w] = dp[n-1][w];
 *  dp[n][w] = dp[n-1][w - wt[n - 1]] + val[n - 1];
 */
public class ZeroOne {
    public static void main(String[] args) {
        System.out.println(new ZeroOne().doPlanning(3, 4, new int[]{2, 1, 3}, new int[]{4, 2, 3}));
    }

    private int doPlanning(int N, int W, int[] wt, int[] val) {
        int[][] dp = new int[N + 1][W + 1];
//        正好为0.所以没有问题
//        for (int i = 0; i < dp.length; i++) {
////            dp[0][i] = dp[i][0] = 0;
//        }
        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++){
                if (w - wt[n -1] < 0) {
                    dp[n][w] = dp[n - 1][w];
                } else {
                    dp[n][w] = Util.max(dp[n-1][w], dp[n-1][w - wt[n -1]] + val[n -1]);
                }
            }
        }
        return dp[N][W];
    }
}
