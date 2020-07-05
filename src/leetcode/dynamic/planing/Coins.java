package leetcode.dynamic.planing;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 凑硬币问题，给出固定几种硬币，比如1， 2, 5 ，再给一个总金额，
 * 请问最少主要几枚硬币凑出这个金额，如果不能凑出，返回-1
 * 写出状态转移方程
 * dp（n） = 0, n = 0;
 * dp(n) = -1, n = -1;
 * dp(n) = min{dp(n-coin) + 1 | coin 属于 coins}， n > 0;
 */
public class Coins {
    private static int[] memV2;
    private static Map<Integer, Integer> memMap;

    public static void main(String[] args) {
//        System.out.println(new Coins().dynamicPlanningV1(new int[]{1, 2, 5}, 13));
//        k个硬币，总金额是n
//        可以用数组，也可以map
        int totalAmount = 12;
//        memV2 = new int[totalAmount + 1];
//        Arrays.fill(memV2, -1);
//        System.out.println(new Coins().dynamicPlanningV2(new int[]{1, 2, 5}, totalAmount));
        memMap = new HashMap<>();
//        System.out.println(new Coins().dynamicPlanningV3(new int[]{1, 2, 5}, totalAmount));
        System.out.println(new Coins().dynamicPlanningV4(new int[]{1, 2, 5}, totalAmount));


    }

    private int dynamicPlanningV1(int[] coins, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        System.out.print(String.format("%d\t", n));
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (n - coin < 0) {
                continue;
            }
            int subProblem = dynamicPlanningV1(coins, n - coin);
            if (subProblem == -1) {
                continue;
            }
            int res = subProblem + 1;
            if (min > res) {
                min = res;
            }
        }
        return min;
    }

    private int dynamicPlanningV2(int[] coins, int total) {
        if (memV2[total] != -1) {
            return memV2[total];
        }
        System.out.print(String.format("%d\t", total));
        if (total == 0) {
            memV2[total] = 0;
            return memV2[total];
        }
        if (total < 0) {
//            memV2[total] = -1;
            return memV2[total];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (total - coin < 0) {
                continue;
            }
            int subProblem = dynamicPlanningV2(coins, total - coin);
            if (subProblem == -1) {
                continue;
            }
            int thisCase = subProblem + 1;
            if (min > thisCase) {
                min = thisCase;
            }
        }
        memV2[total] = min;
        return min;
    }

    private int dynamicPlanningV3(int[] coins, int total) {
        if (memMap.get(total) != null) {
            return memMap.get(total);
        }
        System.out.print(String.format("%d\t", total));
        if (total == 0) {
            memMap.put(0, 0);
            return 0;
        }
        if (total < 0) {
//            memMap.put();
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (total - coin < 0) {
                continue;
            }
            int subProblem = dynamicPlanningV3(coins, total - coin);
            if (subProblem == -1) {
                continue;
            }
            int thisCase = subProblem + 1;
            if (min > thisCase) {
                min = thisCase;
            }
        }
        memMap.put(total, min);
        return min;
    }

    private int dynamicPlanningV4(int[] coins, int total) {
        if (total < 0) {
            return -1;
        }
        if (total == 0) {
            return 0;
        }

        int[] dpTable = new int[total + 1];
        Arrays.fill(dpTable, total + 1);
//        int min = Integer.MAX_VALUE;
        dpTable[0] = 0;
        for (int i = 1; i <= total; i++) {
//求内在子问题 + 1 的最小值
            for (int coin : coins) {
                if (i - coin < 0) {continue;}
                dpTable[i] = min(dpTable[i], 1 + dpTable[i - coin]);
            }
        }

        return dpTable[total];
    }

    private int min (int a , int b) {
        if (a > b)
            return b;
        return a;
    }


}
