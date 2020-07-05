package leetcode.tree;

class BSTValidator {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }
    // 如果单纯的比较树节点与左右子树的比较，会有问题，应该比较左右整课树比较
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        // 搜索二叉树中的元素不能相等吗？
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeGenerator.stringToTreeNode("[5,1,4,null,null,3,6]");
        boolean validBST = new BSTValidator().isValidBST(treeNode);
        System.out.println(validBST);
    }
}