package leetcode.dynamic.planing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueen {
    List<char[][]> res = new ArrayList<>();

    private List<char[][]> solveQueen(int n) {
        char[][] board = new char[n][n];

        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }

        traceBack(board, 0);
        return res;
    }

    private void traceBack(char[][] board , int row) {
//        注意终止条件，超过了棋盘，才能增加
        if (row == board.length) {
            res.add(board);
            return;
        }

        for (int collum = 0; collum < board[row].length; collum++) {
            if (isNotValid(board, row, collum)) {
                continue;
            }

            board[row][collum] = 'Q';
            traceBack(board, row + 1);
            board[row][collum] = '.';
        }

    }

    private boolean isNotValid(char[][] board, int row, int collum){
        int len = board.length;
        for (int i = 0; i < len; i++) {
            if (board[row][i] == 'Q') {
                return true;
            }
        }

        for (int i = 0; i < len; i++) {
            if (board[i][collum] == 'Q') {
                return true;
            }
        }

//        左上角
        for (int i = row - 1, j = collum - 1; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 'Q'){
                return  true;
            }
        }

//        有上角
        for (int i = row - 1, j = collum + 1; i >= 0 && j < len; i-- ,j++){
            if (board[i][j] == 'Q'){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().solveQueen(8).size());
    }
}
