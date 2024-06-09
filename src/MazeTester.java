import java.util.*;
import java.io.*;

/**
 * Updated MazeTester uses A* algorithm to determine if a maze can be traversed.
 */
public class MazeTester {
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: "); // you must include the ".txt". i.e. "maze1.txt"
        String filename = scan.nextLine();

        Maze maze = new Maze(filename);
        System.out.println("Original maze:");
        maze.print();

        MazeSolver solver = new MazeSolver(maze);

        if (solver.traverse(maze.getStartRow(), maze.getStartCol(), maze.getEndRow(), maze.getEndCol())) {
            System.out.println("The maze was successfully traversed!\nTraverse was called " + solver.traverseCall + " times.");
        } else {
            System.out.println("There is no possible path.");
        }

        String mazeString = maze.toString();
        String breadcrumbMaze = mazeString.replace('o', '.').replace('C', 'o');

        int crumbs = 0;
        for (char ch : breadcrumbMaze.toCharArray()) {
            if (ch == 'o') {
                crumbs++;
            }
        }

        System.out.println("There are " + crumbs + " breadcrumbs.");
        System.out.println("Final maze:");
        System.out.println(breadcrumbMaze);
    }
}
