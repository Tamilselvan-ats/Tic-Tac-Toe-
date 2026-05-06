package com.example.tictactoe;

import java.util.Scanner;

/**
 * UC3: Accept User Slot Input (1–9)
 */
public class UC3_AcceptInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int slot = getSlotInput();
        System.out.println("User entered slot: " + slot);
    }

    private static int getSlotInput() {
        System.out.print("Enter your move (slot 1-9): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
