package second.trys.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class Permutation {
    List<List<Integer>> res = new ArrayList<>();
    private List<List<Integer>> initiate(int[] ints) {
        act(ints, new ArrayList<>());
        return res;
    }

    private void act(int[] ints, List<Integer> single) {
        if (single.size() == ints.length) {
            res.add(new ArrayList<>(single));
            return;
        }
        for (int anInt : ints) {
            if (single.indexOf(anInt) != -1) {
                continue;
            }
            single.add(anInt);
            act(ints, single);
            single.remove(new Integer(anInt));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permutation().initiate(new int[]{1, 2, 3}));
    }


}
