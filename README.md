# Description
The Rat Maze Game is a program that solves a maze represented as a grid. The maze is loaded from a file and consists of walls (#), open paths (.), a start point (R), and a goal (C). The program uses the A* algorithm to find the optimal path from the start to the goal, marking the path with 'o' and backtracking if necessary. If a path is found, the maze is printed with the solved path represented by 'o'. If no path is found, the program prints a message indicating so.

## Classes
### Maze.java
This class represents the maze grid and contains methods for loading the maze from a file, marking positions as tried or part of the path, and checking the validity of a position.

### MazeSolver.java
This class contains the A* algorithm implementation for solving the maze. It uses a priority queue to explore the maze and backtracks to find the optimal path.

### MazeTester.java
This class contains the main method for testing the maze solver. It loads a maze from a file, solves it using MazeSolver, and prints the result.

## How to Run
1. Compile all Java files (`Maze.java`, `MazeSolver.java`, `MazeTester.java`).
2. Run `MazeTester`.
3. Enter the name of the file containing the maze (e.g., `maze1.txt`).
4. The program will print the original maze, attempt to solve it, and print the final maze with the solved path (if found).
