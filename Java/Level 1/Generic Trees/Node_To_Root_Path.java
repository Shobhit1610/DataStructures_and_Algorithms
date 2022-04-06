import java.util.ArrayList;

public class Node_To_Root_Path {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        ArrayList<Integer> res = new ArrayList<>();

        if (node.data == data) {
            res.add(node.data);
            return res;
        }
        if (node.data != data && node.children.size() == 0) {
            return res;
        }

        for (Node child : node.children) {
            res = nodeToRootPath(child, data);

            if (res.size() > 0) {
                res.add(node.data);
                break;
            }

        }

        return res;

    }

}
