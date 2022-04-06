import java.util.ArrayList;
import java.util.Stack;

public class Iterative_Preorder_And_PostOrder_Traversals {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void IterativePreandPostOrder(Node node) {
        // To chhabge recursion to iteraation , we need stack to simulate the recursion
        // But here we dont know if the state of calling function is in preorder , post
        // order so we will maintain a variable as state and attach it to evry node

        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        Stack<NodeWithState> stk = new Stack<>();

        stk.push(new NodeWithState(node));

        while (!stk.isEmpty()) {
            NodeWithState current = stk.pop();
            if (current.state == -1) {
                // Preorder
                preOrder.add(current.node.data);

                NodeWithState newNode = new NodeWithState(current.node);
                newNode.state = current.state + 1;

                stk.push(newNode);
            } else if (current.state == current.node.children.size()) {
                // postorder
                postOrder.add(current.node.data);
            } else {
                NodeWithState newNode = new NodeWithState(current.node);
                newNode.state = current.state + 1;

                stk.push(newNode);

                newNode = new NodeWithState(current.node.children.get(current.state));
                stk.push(newNode);

            }

        }

        for (Integer x : preOrder)
            System.out.print(x + " ");

        System.out.println();

        for (Integer x : postOrder)
            System.out.print(x + " ");

    }

    static class NodeWithState {
        Node node;
        int state;

        public NodeWithState(Node node) {
            this.node = node;
            // _1 state is for preorder and state = children for post order
            state = -1;
        }
    }
}