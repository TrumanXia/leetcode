package leetcode.mono.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 使用单调栈，来求出数组中每一位数字以后比当前数字大的数字所在的位置，如果没有则为 -1。
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        for (int i : new NextGreaterElement().calculate(new int[]{5, 3, 1, 2, 4})) {
            System.out.print(i + "\t");
        }
    }

    private int[] calculate(int[] input) {
        int length = input.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
//        单调栈 维护单调减元素的索引
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i]) {
//              更新结果
                result[stack.peek()] = i - stack.peek();
//                不pop会造成死循环！更新栈中的数据，要弹出，比较前面索引的值
                System.out.println(stack.pop());
            }
            stack.push(i);
        }

        return result;
    }
}
