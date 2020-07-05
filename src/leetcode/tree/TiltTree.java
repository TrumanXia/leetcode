package leetcode.tree;

public class TiltTree {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        sum += Math.abs((root.left == null ? 0 : root.left.val) - (root.right == null ? 0 : root.right.val));
        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeGenerator.stringToTreeNode("[1,2,3,4,null,5]");
        System.out.println(new TiltTree().findTilt(treeNode));
    }
}
