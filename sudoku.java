import java.io.*;
import java.util.*;

public class SudokuSolver {
    private static final int SIZE = 9;

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];

        // Read Sudoku from input file
        try (Scanner sc = new Scanner(new File("input.txt"))) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (sc.hasNextInt()) {
                        board[i][j] = sc.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: input.txt not found.");
            return;
        }

        System.out.println("Original Sudoku Board:");
        printBoard(board);

        if (solveSudoku(board)) {
            System.out.println("\nSolved Sudoku Board:");
            printBoard(board);
            saveSolution(board);
        } else {
            System.out.println("\nNo solution exists.");
        }
    }

    // Backtracking Algorithm
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  // Empty cell found
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true; // Success
                            }
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    // Check if number placement is valid
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num || 
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Save solution to output.txt
    private static void saveSolution(int[][] board) {
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (int[] row : board) {
                for (int num : row) {
                    writer.print(num + " ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error writing to output.txt");
        }
    }
}
