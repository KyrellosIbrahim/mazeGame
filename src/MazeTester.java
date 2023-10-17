import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

       // String filename =  "resource/maze.txt";

        Maze file = new Maze(filename);


       // Maze labyrinth = new Maze("resource/maze.txt");

        System.out.println(file);

        MazeSolver solver = new MazeSolver(file);

        if (solver.traverse(file.startR, file.startC)) {
            System.out.println("The maze was successfully traversed!\nTraverse was called " + solver.traverseCall + " times.");
        }
        else
            System.out.println("There is no possible path.");

        String m = file.toString().replace('o', '.');
        String n = m.replace('C', 'o');

        int crumbs = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == 'o') {
                crumbs++;
            }
        }

        System.out.println("There are " + crumbs + " breadcrumbs.");

        System.out.println(n);
    }
}



// Change grid to 4/4 to 0 for no possible paths