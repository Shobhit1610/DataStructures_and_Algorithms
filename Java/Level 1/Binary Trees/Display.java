public class Display {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public void display(Node node) {
        if (node == null)
            return;

        String result = "";

        if (node.left != null)
            result += node.left.data;
        result += "<-";
        result += node.data;
        result += "->";
        if (node.right != null)
            result += node.right.data;

        System.out.println(result);

        System.out.println(node.left);
        display(node.left);
        display(node.right);
    }
}