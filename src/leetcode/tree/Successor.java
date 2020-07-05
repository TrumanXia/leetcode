package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Successor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        inorderTraversal(root, nodes);
        int index = nodes.indexOf(p);
        if (index == -1 || index + 1 == nodes.size()) {
            return null;
        }
        return nodes.get(index + 1);
    }

    private void inorderTraversal(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, nodes);
        nodes.add(root);
        inorderTraversal(root.right, nodes);
    }
}
