import java.util.*;
import java.io.*;

public class Maze {
    public int startR, startC, endR, endC;
    private static final char TRIED = 'o';
    private static final char PATH = 'C';
    private int numberRows, numberColumns;
    private char[][] grid;

    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                grid[i][j] = scan.next().charAt(0);

                if (grid[i][j] == 'R') {
                    startR = i;
                    startC = j;
                }
                if (grid[i][j] == 'C') {
                    endR = i;
                    endC = j;
                }
            }
        }
    }

    /**
     * Marks the given position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col) {
        if (grid[row][col] != 'C') {
            grid[row][col] = TRIED;
        }
    }

    /**
     * @return the row number of the start
     */
    public int getStartRow() {
        return startR;
    }

    /**
     * @return the column number of the start
     */
    public int getStartCol() {
        return startC;
    }

    /**
     * @return the row number of the goal
     */
    public int getEndRow() {
        return endR;
    }

    /**
     * @return the column number of the goal
     */
    public int getEndCol() {
        return endC;
    }

    /**
     * Marks a given position in the maze as part of the PATH
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col) {
        grid[row][col] = PATH;
    }

    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid, false otherwise
     */
    public boolean validPosition(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length && grid[row][column] != '#' && grid[row][column] != 'o';
    }

    public void print() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n");
        for (char[] row : grid) {
            for (char cell : row) {
                result.append(cell).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
