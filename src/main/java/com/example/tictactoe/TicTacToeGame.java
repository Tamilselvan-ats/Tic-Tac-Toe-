package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Tic-Tac-Toe Game Implementation covering UC1 to UC10.
 */
public class TicTacToeGame {

    private static char[][] board = new char[3][3];
    private static char userSymbol;
    private static char computerSymbol;
    private static boolean isUserTurn;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to Console Tic-Tac-Toe!");
        
        // UC1: Initialize and Display Empty Board
        initializeBoard();
        displayBoard();

        // UC2: Toss to decide first player and symbols
        performToss();

        // UC8: Continuous Turn-Based Game Loop
        while (true) {
            if (isUserTurn) {
                userMove();
            } else {
                computerMove();
            }

            displayBoard();

            // UC9: Check Winning Condition
            if (checkWinner(isUserTurn ? userSymbol : computerSymbol)) {
                System.out.println((isUserTurn ? "Human" : "Computer") + " wins!");
                break;
            }

            // UC10: Detect Draw Condition
            if (isBoardFull()) {
                System.out.println("The game is a draw!");
                break;
            }

            // Switch Turns
            isUserTurn = !isUserTurn;
        }
        
        System.out.println("Game Over.");
    }

    // UC1: Initialize all cells with '-'
    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    // UC1: Print the board clearly
    private static void displayBoard() {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // UC2: Randomly decide who plays first and assign symbols
    private static void performToss() {
        System.out.println("Performing toss...");
        if (random.nextInt(2) == 0) {
            System.out.println("Heads! Human plays first.");
            isUserTurn = true;
            userSymbol = 'X';
            computerSymbol = 'O';
        } else {
            System.out.println("Tails! Computer plays first.");
            isUserTurn = false;
            userSymbol = 'O';
            computerSymbol = 'X';
        }
        System.out.println("Human: " + userSymbol + ", Computer: " + computerSymbol);
    }

    private static void userMove() {
        int slot;
        int row, col;
        while (true) {
            // UC3: Accept User Slot Input (1-9)
            slot = getSlotInput();

            // UC4: Convert Slot to Board Index
            int[] indices = convertSlotToIndices(slot);
            row = indices[0];
            col = indices[1];

            // UC5: Validate User Move
            if (isValidMove(row, col)) {
                break;
            } else {
                System.out.println("Invalid move! Slot " + slot + " is already occupied or out of bounds. Try again.");
            }
        }

        // UC6: Place Move on Board
        placeMove(row, col, userSymbol);
    }

    // UC3: User enters slot number
    private static int getSlotInput() {
        System.out.print("Enter your move (slot 1-9): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number between 1 and 9.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    // UC4: Mathematical mapping of slot 1-9 to 0-based row/col
    private static int[] convertSlotToIndices(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    // UC5: Ensure move is within bounds and cell is empty
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    // UC6: Update the board with symbol
    private static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer makes a random valid move (Easy Level)
    private static void computerMove() {
        System.out.println("Computer is making a move...");
        int slot;
        int row, col;
        do {
            slot = random.nextInt(9) + 1;
            int[] indices = convertSlotToIndices(slot);
            row = indices[0];
            col = indices[1];
        } while (!isValidMove(row, col));

        System.out.println("Computer chose slot: " + slot);
        placeMove(row, col, computerSymbol);
    }

    // UC9: Pattern Matching for Winning Condition
    private static boolean checkWinner(char symbol) {
        // Rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
        }
        // Columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        // Diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;

        return false;
    }

    // UC10: No empty cells left
    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false;
            }
        }
        return true;
    }
}
