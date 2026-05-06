package com.example.tictactoe;

import java.util.Scanner;

/**
 * UC8: Continuous Turn-Based Game Loop
 */
public class UC8_GameLoop {
    public static void main(String[] args) {
        boolean gameRunning = true;
        boolean userTurn = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Game Loop Started. Enter 'exit' to stop simulation.");
        while (gameRunning) {
            System.out.println("Current turn: " + (userTurn ? "User" : "Computer"));
            System.out.print("Simulate turn? (y/exit): ");
            String input = sc.next();
            if (input.equalsIgnoreCase("exit")) break;
            
            userTurn = !userTurn; // Switch turn
        }
    }
}
