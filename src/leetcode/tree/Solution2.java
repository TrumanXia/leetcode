package leetcode.tree;

import java.util.*;

public class Solution2 {
    List<String> records = new ArrayList<>();

    public int sumRootToLeaf(TreeNode root) {
        String record = "";
        dfs(root, record);
        int sum = 0;
        for(String path : records) {
            sum += Integer.parseInt(path, 2);
        }
        return sum;
    }

    private void dfs (TreeNode root, String record) {
        record += root.val;
        if (root.right == null && root.left == null) {
            records.add(record);
            return;
        }
        if (root.left != null) {
            dfs(root.left, record);
        }
        if (root.right != null) {
            dfs(root.right, record);
        }
    }

    public static void main(String[] args) {
        int i = new Solution2().sumRootToLeaf(TreeGenerator.stringToTreeNode("[0, 1, 1]"));
        System.out.println(i);
//        System.out.println(3 << 1);
    }
}
