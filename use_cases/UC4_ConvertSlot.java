package com.example.tictactoe;

/**
 * UC4: Convert Slot Number (1–9) to Board Index (Row, Column)
 */
public class UC4_ConvertSlot {
    public static void main(String[] args) {
        int slot = 5; // Example input
        int[] indices = convertSlotToIndices(slot);
        System.out.println("Slot " + slot + " maps to: Row " + indices[0] + ", Column " + indices[1]);
    }

    private static int[] convertSlotToIndices(int slot) {
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }
}
