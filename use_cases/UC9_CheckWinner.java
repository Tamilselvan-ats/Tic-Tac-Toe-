package com.example.tictactoe;

/**
 * UC9: Check Winning Condition
 */
public class UC9_CheckWinner {
    private static char[][] board = {{'X', 'X', 'X'}, {'-', 'O', '-'}, {'O', '-', '-'}};

    public static void main(String[] args) {
        if (checkWinner('X')) {
            System.out.println("X is the winner!");
        } else {
            System.out.println("No winner yet.");
        }
    }

    private static boolean checkWinner(char symbol) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
        }
        // Cols
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        // Diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;

        return false;
    }
}
