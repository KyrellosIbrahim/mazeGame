import java.util.*;
import java.io.*;

/**
 * Maze represents a maze of characters. The goal is to get from the
 * top left corner to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Maze
{
    public int startR, startC, endR, endC;
    private static final char TRIED = 'o';
    private static final char PATH = 'C';

    private int numberRows, numberColumns;
    //private int[][] grid;
    private char[][] grid;

    /**
     * Constructor for the Maze class. Loads a maze from the given file.
     * Throws a FileNotFoundException if the given file is not found.
     *
     * @param filename the name of the file to load
     * @throws FileNotFoundException if the given file is not found
     */
    public Maze(String filename) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {
                grid[i][j] = scan.next().charAt(0);

                if (grid[i][j] == 'R') {
                    System.out.println("Row: " + i + " Column: " + j);

                    startR = getStartR(i, j);
                    startC = getStartC(i, j);
                }
                if (grid[i][j] == 'C') {
                    System.out.println("Row: " + i + " Column: " + j);

                    endR = getEndR(i, j);
                    endC = getEndC(i, j);
                }
            }
        }
    }

    /**
     * Marks the specified position in the maze as TRIED
     *
     * @param row the index of the row to try
     * @param col the index of the column to try
     */
    public void tryPosition(int row, int col)
    {
        //might need to add if statement here
        if(grid[row][col] != 'C') {
            grid[row][col] = TRIED;
        }
    }

    /**
     * Return the starting point of the maze
     * @return the row number
     */
    public int getStartR(int r, int c)
    {
        if(grid[r][c] == 'R')
            System.out.println("Row: " + r + " Column: " + c);
        return r;
    }

    /**
     * Return the starting point of the maze
     * @return the column number
     */
    public int getStartC(int r, int c)
    {
        if(grid[r][c] == 'R')
            System.out.println("Row: " + r + " Column: " + c);
        return c;
    }

    /**
     * return the ending point of the maze
     * @return the row number
     */
    public int getEndR(int r, int c)
    {
        if(grid[r][c] == 'C')
            System.out.println("Row: " + r + " Column: " + c);
        return r;

    }


    /**
     * return the ending point of the maze
     * @return the column number
     */
    public int getEndC(int r, int c)
    {
        if(grid[r][c] == 'C')
            System.out.println("Row: " + r + " Column: " + c);
        return c;
    }

    /**
     * Marks a given position in the maze as part of the PATH
     *
     * @param row the index of the row to mark as part of the PATH
     * @param col the index of the column to mark as part of the PATH
     */
    public void markPath(int row, int col)
    {
        grid[row][col] = PATH;
    }
    /**
     * Determines if a specific location is valid. A valid location
     * is one that is on the grid, is not blocked, and has not been TRIED.
     *
     * @param row the row to be checked
     * @param column the column to be checked
     * @return true if the location is valid
     */
    public boolean validPosition(int row, int column)
    {
        boolean result = false;

        // check if cell is in the bounds of the matrix
        if (row >= 0 && row < grid.length && column >= 0 && column < grid[row].length)

            //  check if cell is not blocked and not previously tried
            if (grid[row][column] != '#' && grid[row][column] != 'o')
                result = true;

        return result;
    }

    /**
     * Returns the maze as a string.
     *
     * @return a string representation of the maze
     */
    public String toString()
    {
        String result = "\n";

        for (int row=0; row < grid.length; row++)
        {
            for (int column=0; column < grid[row].length; column++)
                result += grid[row][column] + "";
            result += "\n";
        }

        return result;
    }
}
