//package second.trys.algorithm.dp;
//
//import leetcode.tree.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GenerateAllKindsOfTrees {
//
//    List<TreeNode> res = new ArrayList<>();
//    private List<TreeNode> initiate(int n) {
//        act(n, new TreeNode(-1), new ArrayList<>());
//        return res;
//    }
//
//    private void act(int n, TreeNode single, List<Integer> nodes) {
//        if (nodes.size() == n) {
//            res.add(copyTree(single));
//            return;
//        }
//        for (int i = 1; i <= n; i++) {
//            if (nodes.indexOf(i) != -1) continue;
//            nodes.add(i);
//            if (single.val > i) {
////                插入节点到树上
//                single.left = new TreeNode(i);
//            } else if (single.val < i) {
////                插入节点到树上
//                single.right = new TreeNode(i);
//            } else {
//                continue;
//            }
//
//            nodes.remove(new Integer(i));
//        }
//        for (int anInt : ints) {
//            if (single.indexOf(anInt) != -1) {
//                continue;
//            }
//            single.add(anInt);
//            act(ints, single);
//            single.remove(new Integer(anInt));
//        }
//    }
//
//    private TreeNode copyTree(TreeNode source) {
//        if (source == null) return source;
//
//        TreeNode target = new TreeNode(source.val);
//        target.left = copyTree(source.left);
//        target.right = copyTree(source.right);
//        return target;
//    }
//
//
//}
