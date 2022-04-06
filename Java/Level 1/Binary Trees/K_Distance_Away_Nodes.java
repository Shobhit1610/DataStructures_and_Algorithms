import java.util.ArrayList;

public class K_Distance_Away_Nodes {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void printKNodesFar(Node node, int data, int k) {

        Node requiredNode = findNode(node, data);
        ArrayList<Node> nodeToRootPath = getPathFromNodeToRoot(node, data);

        // K level down from node
        // K-1 level down from parent node
        // k-2 level down from grandparent node

        ArrayList<Node> result = new ArrayList<>();

        result.addAll(findKLevelDownNodes(requiredNode, k--, null));

        for (int i = 0; i < nodeToRootPath.size(); i++) {
            result.addAll(findKLevelDownNodes(nodeToRootPath.get(i), k--, nodeToRootPath.get(i - 1)));
        }
        

    }

    public static ArrayList<Node> findKLevelDownNodes(Node node, int level, Node alreadyVisited) {

        ArrayList<Node> result = new ArrayList<>();

        if (node == null || level < 0) {
            return result;
        } else if (level == 0) {
            result.add(node);
            return result;
        } else if (node == alreadyVisited) {
            return result;
        }

        ArrayList<Node> left = findKLevelDownNodes(node.left, level - 1, alreadyVisited);
        if (!left.isEmpty()) {
            result.addAll(left);
        }
        ArrayList<Node> right = findKLevelDownNodes(node.right, level - 1, alreadyVisited);
        if (!right.isEmpty()) {
            result.addAll(right);
        }

        return result;

    }

    public static Node findNode(Node node, int data) {
        if (node == null)
            return null;
        else if (node.data == data)
            return node;

        Node left = findNode(node.left, data);
        if (left != null)
            return left;

        Node right = findNode(node.right, data);
        if (right != null)
            return right;

        return null;

    }

    public static ArrayList<Node> getPathFromNodeToRoot(Node node, int data) {
        ArrayList<Node> res = new ArrayList<>();

        if (node == null) {
            return res;
        } else if (node.data == data) {
            res.add(node);
            return res;
        }

        ArrayList<Node> left = getPathFromNodeToRoot(node.left, data);
        if (!left.isEmpty()) {
            left.add(node);
            return left;
        }

        ArrayList<Node> right = getPathFromNodeToRoot(node.right, data);
        if (!right.isEmpty()) {
            right.add(node);
            return res;
        }

        return res;

    }

}
