import java.util.*;

class Node implements Comparable<Node> {
    int row, col;
    double gCost, hCost;
    Node parent;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    double fCost() {
        return gCost + hCost;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.fCost(), other.fCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

public class MazeSolver {
    private final Maze maze;
    public int traverseCall = 0;
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1} // cardinal directions
    };


    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    /**
     * Attempts to traverse the maze using the A* algorithm.
     *
     * @param startRow row index of the starting point
     * @param startCol column index of the starting point
     * @param endRow row index of the goal
     * @param endCol column index of the goal
     * @return true if the maze has been solved, false otherwise
     */
    public boolean traverse(int startRow, int startCol, int endRow, int endCol) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        HashSet<Node> closed = new HashSet<>();
        Node start = new Node(startRow, startCol);
        Node goal = new Node(endRow, endCol);
        start.gCost = 0;
        start.hCost = heuristic(start, goal);
        heap.add(start);

        while (!heap.isEmpty()) {
            Node current = heap.poll();
            maze.tryPosition(current.row, current.col); // mark as tried

            // check if we reached the goal
            if (current.equals(goal)) {
                markPath(current);
                return true; // Path found
            }

            closed.add(current);

            for (int[] direction : DIRECTIONS) {
                int newRow = current.row + direction[0];
                int newCol = current.col + direction[1];

                // Check if the neighbor is valid and not in the closed set
                if (maze.validPosition(newRow, newCol) && !closed.contains(new Node(newRow, newCol))) {
                    Node neighbor = new Node(newRow, newCol);
                    double tentativeGCost = current.gCost + 1;

                    // if the neighbor is not in the closed set, or we found a shorter path
                    if (!heap.contains(neighbor) || tentativeGCost < neighbor.gCost) {
                        neighbor.gCost = tentativeGCost;
                        neighbor.hCost = heuristic(neighbor, goal);
                        neighbor.parent = current;

                        if (!heap.contains(neighbor)) {
                            heap.add(neighbor);
                        }
                    }
                }
            }
        }

        return false; // No path found
    }

    /**
     * Heuristic function for A* algorithm. Uses Manhattan distance.
     *
     * @param a the start node
     * @param b the goal node
     * @return the Manhattan distance between a and b
     */
    private double heuristic(Node a, Node b) {
        return Math.abs(a.row - b.row) + Math.abs(a.col - b.col);
    }

    /**
     * marks the path by backtracking from the goal node
     *
     * @param node the goal node
     */
    private void markPath(Node node) {
        while (node != null) {
            maze.markPath(node.row, node.col);
            node = node.parent;
        }
    }
}
