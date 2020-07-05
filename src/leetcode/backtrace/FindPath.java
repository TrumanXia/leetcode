package leetcode.backtrace;

public class FindPath {

    public static void main(String[] args) {
        System.out.println(new FindPath().exist(new char[][]{{'a'}, {'c'}}, "ac"));
    }
    public boolean exist(char[][] board, String word) {
        if (board.length * board[0].length < word.length()) {
            return false;
        }
        boolean[][] traversed = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {

                if (dfs(board, i, j, word, 0, traversed))
                    // break;只能停止一层循环，不能直接返回
                    // break;
                    return true;
            }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] traversed) {

        // 边界终止条件, 以及不能之前遍历过的了
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || index > word.length() - 1 ||  traversed[i][j] == true) {
            return false;
        }
        // 当前值不满足
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else {
            if (index == word.length() - 1) {
                return true;
            }
        }
        boolean res = false;
        traversed[i][j] = true;
        // 进行下一步--
        res = dfs(board, i + 1, j, word, index + 1, traversed) ||
            dfs(board, i - 1, j, word, index + 1, traversed) ||
            dfs(board, i, j + 1, word, index + 1, traversed) ||
            dfs(board, i, j - 1, word, index + 1, traversed);
        traversed[i][j] = false;

        return res;

    }
}
