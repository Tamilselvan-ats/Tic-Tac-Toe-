package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Final Tic-Tac-Toe Game Implementation.
 * Integrates all 10 Use Cases (UC1 - UC10) into a single functional application.
 */
public class TicTacToeGame {

    private static final char EMPTY = '-';
    private static char[][] board = new char[3][3];
    private static char userSymbol;
    private static char computerSymbol;
    private static boolean isUserTurn;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("=== Console Tic-Tac-Toe Game ===");
        
        // UC1: Initialize Board
        initializeBoard();
        
        // UC2: Toss
        performToss();
        
        displayBoard();

        // UC8: Game Loop
        boolean gameFinished = false;
        while (!gameFinished) {
            if (isUserTurn) {
                System.out.println("Your turn (" + userSymbol + ")");
                userMove();
            } else {
                System.out.println("Computer's turn (" + computerSymbol + ")");
                computerMove();
            }

            displayBoard();

            char currentSymbol = isUserTurn ? userSymbol : computerSymbol;
            
            // UC9: Check Winner
            if (checkWinner(currentSymbol)) {
                System.out.println((isUserTurn ? "Congratulations! You" : "Computer") + " won!");
                gameFinished = true;
            } 
            // UC10: Check Draw
            else if (isBoardFull()) {
                System.out.println("It's a Draw!");
                gameFinished = true;
            } else {
                // Switch Turn
                isUserTurn = !isUserTurn;
            }
        }
        
        System.out.println("Thanks for playing!");
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        System.out.println("\n-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static void performToss() {
        System.out.println("Tossing to decide who goes first...");
        if (random.nextInt(2) == 0) {
            System.out.println("Result: USER starts first.");
            isUserTurn = true;
            userSymbol = 'X';
            computerSymbol = 'O';
        } else {
            System.out.println("Result: COMPUTER starts first.");
            isUserTurn = false;
            userSymbol = 'O';
            computerSymbol = 'X';
        }
        System.out.println("You are: " + userSymbol + " | Computer is: " + computerSymbol);
    }

    private static void userMove() {
        int slot;
        while (true) {
            // UC3: Input
            System.out.print("Select a slot (1-9): ");
            if (scanner.hasNextInt()) {
                slot = scanner.nextInt();
                if (slot >= 1 && slot <= 9) {
                    // UC4: Convert
                    int row = (slot - 1) / 3;
                    int col = (slot - 1) % 3;

                    // UC5: Validate
                    if (board[row][col] == EMPTY) {
                        // UC6: Place
                        board[row][col] = userSymbol;
                        break;
                    } else {
                        System.out.println("Slot already occupied! Try another one.");
                    }
                } else {
                    System.out.println("Invalid slot number. Choose 1-9.");
                }
            } else {
                System.out.println("Invalid input. Enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static void computerMove() {
        // UC7: Random Move
        int slot;
        int row, col;
        do {
            slot = random.nextInt(9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;
        } while (board[row][col] != EMPTY);

        System.out.println("Computer chooses slot: " + slot);
        board[row][col] = computerSymbol;
    }

    private static boolean checkWinner(char symbol) {
        // Horizontal, Vertical, Diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) return false;
            }
        }
        return true;
    }
}
