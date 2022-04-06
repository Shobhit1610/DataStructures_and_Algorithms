import java.util.ArrayList;
import java.util.Stack;

public class Level_Order_Linewise_ZigZag {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrderZZ(Node node) {

        Stack<Node> mainStk = new Stack<>();
        Stack<Node> childStk = new Stack<>();
        int level = 0;

        mainStk.push(node);
        level++;

        while (!mainStk.isEmpty()) {

            while (!mainStk.isEmpty()) {
                Node current = mainStk.pop();
                System.out.print(current.data + " ");

                if (level % 2 == 1) {

                    for (int i = 0; i < current.children.size(); i++) {
                        childStk.push(current.children.get(i));
                    }

                } else {

                    for (int i = current.children.size() - 1; i >= 0; i--) {
                        childStk.push(current.children.get(i));
                    }
                }
            }
            Stack<Node> temp = null;
            temp = mainStk;
            mainStk = childStk;
            childStk = temp;

            System.out.println();
            level++;
        }

    }
}
