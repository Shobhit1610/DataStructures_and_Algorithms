import java.util.ArrayList;

public class Linearize_The_Tree_LinearTimeSolution {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // 1.SOLUTION WITH LINEAR SPACE COMPLEXITY

    // HAve to convert whole tree to link list in pre order manner
    public Node linearize(Node node) {

        if (node.children.size() == 0)
            return node;

        else if (node.children.size() == 1)
            return node.children.get(0);

        ArrayList<Node> rightMostOfEachChild = new ArrayList<>();

        for (Node child : node.children) {
            rightMostOfEachChild.add(linearize(child));
        }

        // Size of rightMostOfEachChild and node,children will always be equal
        for (int i = rightMostOfEachChild.size() - 1; i >= 1; i--) {
            Node lastChild = node.children.remove(i);
            Node rightOfSecondLastChild = rightMostOfEachChild.get(i - 1);

            rightOfSecondLastChild.children.add(lastChild);
        }

        return rightMostOfEachChild.get(rightMostOfEachChild.size() - 1);

    }

    // 2. SOLUTION WITH CONSTANT SPACE COMPLEXITY
    public Node linearize_ConstantSpace(Node node) {

        if (node.children.size() == 0)
            return node;

        else if (node.children.size() == 1)
            return node.children.get(0);

        Node rightOfLastChild = linearize(node.children.get(node.children.size() - 1));

        // Size of rightMostOfEachChild and node,children will always be equal
        for (int i = node.children.size() - 1; i >= 1; i--) {
            Node lastChild = node.children.remove(i);
            Node rightOfSecondLastChild = linearize(node.children.get(i - 1));

            rightOfSecondLastChild.children.add(lastChild);
        }

        return rightOfLastChild;

    }

}
