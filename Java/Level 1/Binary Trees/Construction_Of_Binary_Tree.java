import java.util.Stack;

public class Construction_Of_Binary_Tree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // Use three states -1 for preorder, 0 for inorder , 1 for postorder
    public static Node construct(Integer[] arr) {

        Stack<NodeWithStates> stk = new Stack<>();
        NodeWithStates root = new NodeWithStates(arr[0]);
        stk.push(root);

        for (int i = 1; i < arr.length; i++) {

            NodeWithStates currentNode = null;
            if (arr[i] != null)
                currentNode = new NodeWithStates(arr[i]);

            NodeWithStates x = stk.peek();
            if (x.state == -1) {
                x.state = 0;
                if (currentNode != null)
                    x.node.left = currentNode.node;

            } else if (x.state == 0) {
                x.state = 1;
                if (currentNode != null)
                    x.node.right = currentNode.node;

            } else if (x.state == 1) {
                stk.pop();
            }

            if (currentNode != null)
                stk.push(currentNode);

        }
        return root.node;
    }

    static class NodeWithStates {
        Node node;
        int state = -1;

        public NodeWithStates(Node node) {
            this.node = node;
        }

        public NodeWithStates(int data) {
            this.node = new Node(data, null, null);
        }

    }
}
