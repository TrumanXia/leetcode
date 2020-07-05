package leetcode.dynamic.planing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Permutate {

    /*void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}*/
//    全排列记录器
    private List<List<Integer>> res = new ArrayList<>();

    private List<List<Integer>> permute(int[] nums){

        LinkedList<Integer> track = new LinkedList<>();
        traceback(nums, track);
        return res;
    }

    private void traceback (int[] nums, LinkedList<Integer> track){
//        递归终止条件
        if (nums.length == track.size()) {
//            注意这边的问题，如果这样添加，就会出现空列表的问题，因为track只要一份
//            res.add(track);
            res.add(new LinkedList<>(track));
//            这边怎么返回？
            return;
        }
//        循环自然结束，也会返回
        for (int num : nums) {
            if (track.contains(num))
                continue;
            System.out.print(String.format("%d\t", num));

            track.add(num);
            System.out.println(track);
//            遍历树
            traceback(nums, track);
            System.out.println(track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutate().permute(new int[]{1,2,3}));
    }

}
