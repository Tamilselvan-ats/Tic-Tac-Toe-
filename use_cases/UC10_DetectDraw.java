package com.example.tictactoe;

/**
 * UC10: Detect Draw Condition
 */
public class UC10_DetectDraw {
    private static char[][] fullBoard = {{'X', 'O', 'X'}, {'X', 'X', 'O'}, {'O', 'X', 'O'}};
    private static char[][] partialBoard = {{'X', 'O', '-'}, {'-', 'X', 'O'}, {'O', 'X', 'O'}};

    public static void main(String[] args) {
        System.out.println("Is Full Board draw? " + isBoardFull(fullBoard));
        System.out.println("Is Partial Board draw? " + isBoardFull(partialBoard));
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}
