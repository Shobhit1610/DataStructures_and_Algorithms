import java.util.ArrayList;
import java.util.Stack;

public class Iterative_Preorder_Inorder_Postorder {

    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void iterativePrePostInTraversal(Node node) {
        ArrayList<Node> preOrder = new ArrayList<>();
        ArrayList<Node> inOrder = new ArrayList<>();
        ArrayList<Node> postOrder = new ArrayList<>();

        Stack<NodeWithStates> stk = new Stack<>();
        stk.push(new NodeWithStates(node));

        while (!stk.isEmpty()) {
            NodeWithStates current = stk.peek();
            if (current.state == -1) {
                preOrder.add(current.node);
                current.state = 0;
                if (current.node.left != null)
                    stk.push(new NodeWithStates(current.node.left));

            } else if (current.state == 0) {
                inOrder.add(current.node);
                current.state = 1;
                if (current.node.right != null)
                    stk.push(new NodeWithStates(current.node.right));
            } else {
                postOrder.add(current.node);
                stk.pop();
            }

        }

        for (Node x : preOrder)
            System.out.print(x.data + " ");
        System.out.println();
        for (Node x : inOrder)
            System.out.print(x.data + " ");
        System.out.println();
        for (Node x : postOrder)
            System.out.print(x.data + " ");
    }

    static class NodeWithStates {
        Node node;
        int state;

        public NodeWithStates(Node node) {
            this.state = -1;
            this.node = node;
        }
    }

}
