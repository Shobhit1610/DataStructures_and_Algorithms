import java.util.ArrayList;

public class Check_If_Tree_Is_Symmetric {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // We can say that if a tree is same as its mirror mage then it is symmetric

    public static boolean IsSymmetric(Node node) {

        return isMirror(node, node);

    }

    public static boolean isMirror(Node n1, Node n2) {
        if (n1.children.size() == 0 && n2.children.size() == 0)
            return true;
        if (n1.children.size() != n2.children.size())
            return false;

        boolean result = true;

        for (int i = 0; i < n1.children.size(); i++) {
            result = result && isMirror(n1.children.get(i), n2.children.get(n2.children.size() - 1 - i));
        }
        return result;
    }

}
