import java.util.ArrayList;

public class MultiSolver_For_Tree {

    class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // Find size , min , MAX , HEIGHT in one iteration only

    int size = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int height = 0;

    public void multiSolverHelper(Node node, int level) {

        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, level);

        for (Node child : node.children) {
            multiSolverHelper(child, level + 1);
        }

    }
}