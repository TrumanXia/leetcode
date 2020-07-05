package leetcode.tree;

import java.util.ArrayList;

public class RecoverTreeFromPreOrderTraversal {
    public TreeNode recoverFromPreorder(String S) {
        ArrayList<TreeNode>[] layers = new ArrayList[1001];
        // 声明的空的ArrayList，都公用一个空间，所以不会消耗很多内存
        // Shared empty array instance used for default sized empty instances.
        // DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        // 基于java 8 的ArrayList源码
        for (int i = 0; i < 1001; i++) {
            layers[i] = new ArrayList<TreeNode>();
        }

        int len = S.length();
        int i = 0;
        int layerIndex = 0;
        int nodeValue = 0;

        // 首先添加根节点
        while (i < len && S.charAt(i) != '-') {
            nodeValue = nodeValue * 10 + (S.charAt(i) - '0');
            i++;
        }
        TreeNode root = new TreeNode(nodeValue);
        layers[layerIndex].add(root);

        while(i < len) {
            // 循环一次，回置层级索引和节点值，供下次使用
            layerIndex = 0;
            nodeValue = 0;
            // 判断层级
            while (S.charAt(i) == '-') {
                layerIndex++;
                i++;
            }
            // 提取节点值
            while (i < len && '0' <= S.charAt(i) && S.charAt(i) <= '9'){
                nodeValue = nodeValue * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode current = new TreeNode(nodeValue);
            // 存放节点值，供下一层级节点使用
            layers[layerIndex].add(current);
            // 向上一层级节点绑定节点
            if (layers[layerIndex - 1].get(layers[layerIndex - 1].size() -1).left == null){
                layers[layerIndex - 1].get(layers[layerIndex - 1].size() -1).left = current;
            } else {
                layers[layerIndex - 1].get(layers[layerIndex - 1].size() -1).right = current;
            }
        }
        return root;
    }

}
