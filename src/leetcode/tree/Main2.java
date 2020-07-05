package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {

    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    private int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.add(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
