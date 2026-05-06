package com.example.tictactoe;

import java.util.Random;

/**
 * UC7: Computer Makes a Random Move (Easy Level)
 */
public class UC7_ComputerMove {
    private static char[][] board = {{'X', 'O', 'X'}, {'-', 'X', '-'}, {'O', '-', '-'}};
    private static final Random random = new Random();

    public static void main(String[] args) {
        computerMove();
        displayBoard();
    }

    private static void computerMove() {
        System.out.println("Computer is picking a random move...");
        int slot;
        int row, col;
        do {
            slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (board[row][col] != '-');
        
        System.out.println("Computer chooses slot: " + slot);
        board[row][col] = 'O';
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
