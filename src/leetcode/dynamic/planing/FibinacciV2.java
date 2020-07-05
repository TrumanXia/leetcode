package leetcode.dynamic.planing;

/*
    递归 1 1 2 3 5 8
 */
public class FibinacciV2 {
    private boolean[] mem;

    public static void main(String[] args) {
//        int count = 6;
//        mem = new boolean[count + 1];
        System.out.println(f(6));
    }

    /* 重复计算了
    6
   4  5
  3 2 4 3

     */

    public static int f(int n) {
        if (n == 0 || n == 1) return 1;
        else return f(n -1) + f(n - 2);
    }
}
