import java.util.stream.IntStream;
import java.util.Scanner;

public class Sudoku {
    private static final int BOARD_SIZE = 9;
    private static final int BOARD_START_INDEX = 0;
    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int SUBSECTION_SIZE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] board = new int[9][9];
        
        // Input Sudoku board values from the user
        System.out.println("Enter the Sudoku puzzle (9x9 grid):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        
        // Solve the Sudoku puzzle
        solve(board);
        
        // Print the solved Sudoku board
        System.out.println("Solved Sudoku puzzle:");
        printBoard(board);
    }

    // Method to solve the Sudoku puzzle using backtracking
    static boolean solve(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        // Recursively solve the puzzle with the current value
                        if (isValid(board, row, column) && solve(board)) {
                            return true;
                        }
                        // Backtrack if the current value doesn't lead to a solution
                        board[row][column] = NO_VALUE;
                    }
                    return false; // No valid solution found
                }
            }
        }
        return true; // Puzzle solved successfully
    }
    
    // Method to check if the current state of the Sudoku board is valid
    static boolean isValid(int[][] board, int row, int column) {
        return (rowConstraint(board, row)
          && columnConstraint(board, column) 
          && subsectionConstraint(board, row, column));
    }
    
    // Method to check if the constraint is satisfied for a row
    static boolean rowConstraint(int[][] board, int row) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
          .allMatch(column -> checkConstraint(board, row, constraint, column));
    }
    
    // Method to check if the constraint is satisfied for a column
    static boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
    }
    
    // Method to check if the constraint is satisfied for a subsection
    static boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;
    
        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;
    
        // Check each cell within the subsection
        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }
    
    // Method to check if a value satisfies the constraint for a given row or column
    static boolean checkConstraint(
        int[][] board, 
        int row, 
        boolean[] constraint, 
        int column) {
            if (board[row][column] != NO_VALUE) {
                if (!constraint[board[row][column] - 1]) {
                    constraint[board[row][column] - 1] = true;
                } else {
                    return false; // Constraint violated
                }
            }
            return true; // Constraint satisfied
        }
    
    // Method to print the Sudoku board
    static void printBoard(int[][] board) {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }
}
