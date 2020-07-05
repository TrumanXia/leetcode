package leetcode.tree;

public class Solution {
    private int min = Integer.MAX_VALUE;
    private int lastVal = 0;
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return min;
    }

    private void inOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        if(Math.abs(root.val - lastVal) < min) {
            min = Math.abs(root.val - lastVal);
        }
        lastVal = root.val;
        inOrderTraversal(root.left);

        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeGenerator.stringToTreeNode("[1,null,5,3]");
        int minimumDifference = new Solution().getMinimumDifference(treeNode);
        System.out.println(minimumDifference);
    }
}
