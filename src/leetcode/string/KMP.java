package leetcode.string;

/**
 *  mismatch时， 看 1 - j-1 的pattern什么情况
 *
 *  x 怎么得来的？如果 到了 第 j 个字符不匹配，那么就看1-j-1 pattern的情况
 */
public class KMP {

    private int[][] dfa;
    private String pattern;
    public KMP(String pattern) {
        this.pattern = pattern;
        int len = pattern.length();
        int charLength = 256;
        dfa = new int[len][charLength];
//        base case
        dfa[0][pattern.charAt(0)] = 1;
//        每一个位置
        for (int j = 1, x = 0; j < len; j++) {
            for(int c = 0; c < charLength; c++) {
                dfa[j][c] = dfa[x][c];
//                匹配
                dfa[j][pattern.charAt(j)] = j + 1;
//                更新位置
                x = dfa[x][pattern.charAt(j)];
            }
        }
    }

    private int search(String text) {
        int i, j, n = text.length(), m = this.pattern.length();
        for(i = 0, j = 0; i < n && j < m; i++) {
            j = dfa[j][text.charAt(i)];
        }
        if (j == m) {
            return i - m;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        System.out.println(new KMP("txt").search("iamintxsttxtee"));
    }
}
