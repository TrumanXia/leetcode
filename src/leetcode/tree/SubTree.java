package leetcode.tree;

public class SubTree {
    public static void main(String[] args) {
        new SubTree().isSubtree(TreeGenerator.stringToTreeNode("[3,4,5,1,2]"),
            TreeGenerator.stringToTreeNode("[4,1,2]"));
    }

    public boolean isSubtree(TreeNode t, TreeNode s) {
        TreeNode sameRoot = traverseT(t, s.val);
        if (sameRoot == null) return false;
        return traverse(s, sameRoot);
    }

    private TreeNode traverseT(TreeNode t, int nodeValue) {
        if (t == null) return null;
        if (t.val == nodeValue) {
            return t;
        }
        traverseT(t.left, nodeValue);
        traverseT(t.right, nodeValue);

        return null;
    }

    private boolean traverse(TreeNode s, TreeNode t) {
        if (t == null && s != null) return false;
        if (t != null && s == null) return false;
        if (s.val != t.val) return false;

        traverse(s.left, t.left);
        traverse(s.right, s.right);

        return true;
    }
}
