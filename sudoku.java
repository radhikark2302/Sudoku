import java.io.*;
import java.util.Scanner;

public class SudokuSolver {
    static final int SIZE = 9; // Sudoku grid size

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE];

        // Read Sudoku from input file
        try (Scanner scanner = new Scanner(new File("test_cases/easy_input.txt"))) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (scanner.hasNextInt()) {
                        board[i][j] = scanner.nextInt();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found!");
            return;
        }

        // Solve Sudoku
        if (solveSudoku(board)) {
            writeSolutionToFile(board, "test_cases/easy_output.txt");
        } else {
            try (PrintWriter writer = new PrintWriter(new File("test_cases/easy_output.txt"))) {
                writer.println("No solution exists.");
            } catch (IOException e) {
                System.out.println("Error writing output file!");
            }
        }
    }

    // Backtracking solver
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // Empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0; // Undo move
                        }
                    }
                    return false; // No valid number found
                }
            }
        }
        return true; // Solved
    }

    // Check if a number can be placed
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num ||
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    // Write solution to file
    private static void writeSolutionToFile(int[][] board, String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    writer.print(board[i][j] + " ");
                }
                writer.println();
            }
        } catch (IOException e) {
            System.out.println("Error writing output file!");
        }
    }
}
