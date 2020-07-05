package leetcode.tool;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Util {
    public static int max(int x, int y) {
        if (x > y)
            return x;
        return y;
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(1);
        queue.addFirst(2);
        Integer poll = queue.removeFirst();
        Integer poll2 = queue.removeFirst();
        System.out.println(poll2);
//        queue.isEmpty()
    }
}
