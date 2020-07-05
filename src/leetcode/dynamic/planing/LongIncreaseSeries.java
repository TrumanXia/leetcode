package leetcode.dynamic.planing;

import leetcode.tool.Util;

import java.util.Arrays;

public class LongIncreaseSeries {
    public static void main(String[] args) {
        System.out.println(new LongIncreaseSeries().get(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    private int get(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Util.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Util.max(res, dp[i]);
        }
        return res;
    }
}
