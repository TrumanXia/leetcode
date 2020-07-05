package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 不要用set，用map
 */
public class LongestSerialNum {
    public static void main(String[] args) {
        System.out.println(new LongestSerialNum().act(new int[]{100, 4, 200, 2, 3, 2}));
    }

    private int act(int[] input) {

        int len = input.length;
//        用set就好了，没必要用map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(input[i], i);
        }
        int largestStreak = 1;
        for (int i = 0; i < len; i++) {
            if (map.get(input[i] - 1) != null) continue;
            int currentStreak = 1;
            int j = input[i] + 1;
            while (map.get(j) != null) {
                currentStreak ++;
                j ++;
            }
            if (currentStreak > largestStreak)
                largestStreak = currentStreak;
        }
        return largestStreak;
    }
}
