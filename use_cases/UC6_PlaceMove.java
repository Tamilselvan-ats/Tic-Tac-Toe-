package com.example.tictactoe;

/**
 * UC6: Place Move on Board
 */
public class UC6_PlaceMove {
    private static char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};

    public static void main(String[] args) {
        placeMove(1, 1, 'X');
        displayBoard();
    }

    private static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
