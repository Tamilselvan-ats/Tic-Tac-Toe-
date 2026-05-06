package com.example.tictactoe;

import java.util.Random;

/**
 * UC2: Toss to Decide First Player and Symbol
 */
public class UC2_Toss {
    private static char userSymbol;
    private static char computerSymbol;
    private static boolean isUserTurn;
    private static final Random random = new Random();

    public static void main(String[] args) {
        performToss();
    }

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
        System.out.println("Current Turn: " + (isUserTurn ? "Human" : "Computer"));
        System.out.println("Human Symbol: " + userSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
    }
}
