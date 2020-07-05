package leetcode.mono.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 如果是环形的，该如何解决？
 * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]。
 * 拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4 。
 *
 * 如果在代码中体现环形的属性，可以假装增加一倍数组，然后对索引进行取模，保证数组不会越界
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        for (int i : new NextGreaterElements().solve(new int[]{2, 1, 2, 4, 3})) {
            System.out.println(i + "\t");
        }
    }
    private int[] solve (int[] input) {
        Deque<Integer> stack = new ArrayDeque<>();
        int length = input.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
//        正过来想，思路比较清晰
//        单调栈，保证栈中的元素保持递增，或者递减
        for (int i = 0, len = input.length; i < len * 2; i++) {
            while(!stack.isEmpty() && input[stack.peek()] < input[i % len]) {
                result[stack.peek()] = input[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return result;
    }
}
