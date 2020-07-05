package leetcode.dynamic.planing;

/*
    递归 1 1 2 3 5 8
 */
public class FibinacciV1 {
    public static void main(String[] args) {
        System.out.println(f(3));
    }

    /* 重复计算了
    6
   4  5
  3 2 4 3

     */

    public static int f(int n) {
        System.out.println(String.format("f(%d)", n));
        if (n == 0 || n == 1) return 1;
        else return f(n - 1) + f(n - 2);
    }
}
