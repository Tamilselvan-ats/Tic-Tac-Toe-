package com.example.tictactoe;

/**
 * UC1: Display Empty Tic-Tac-Toe Board
 */
public class UC1_DisplayEmptyBoard {
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("Empty Tic-Tac-Toe Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
