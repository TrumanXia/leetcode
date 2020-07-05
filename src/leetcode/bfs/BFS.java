package leetcode.bfs;

import leetcode.tree.TreeGenerator;
import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {
    private List<Integer> act(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if(node == null) continue;
            res.add(node.val);
            nodes.addLast(node.left);
            nodes.addLast(node.right);
        }
        return res;

        /*
        * cbjbd
        * dbjbc
        * */
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeGenerator.stringToTreeNode("[1, 2, 3, 4,5]");
        System.out.println(new BFS().act(treeNode));
    }

}
