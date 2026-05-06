package com.example.tictactoe;

/**
 * UC5: Validate User Move
 */
public class UC5_ValidateMove {
    private static char[][] board = {{'X', '-', 'O'}, {'-', '-', '-'}, {'-', 'X', '-'}};

    public static void main(String[] args) {
        int row = 0, col = 1; // Valid & Empty
        System.out.println("Validating (0,1): " + isValidMove(row, col));
        
        row = 0; col = 0; // Occupied
        System.out.println("Validating (0,0): " + isValidMove(row, col));
        
        row = 3; col = 0; // Out of bounds
        System.out.println("Validating (3,0): " + isValidMove(row, col));
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }
}
