import java.util.ArrayList;

public class Remove_Leaves {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void removeLeaves(Node node) {

        // Cannot write like this as will result in Concurrent Exception
        /*
         * for(Node child:node.children)
         * {
         * if(child.children.isEmpty())
         * node.children.remove(child);
         * else
         * removeLeaves(child);
         * }
         */
        for (int i = node.children.size() - 1; i >= 0; i--) {
            Node child = node.children.get(i);
            if (child.children.isEmpty())
                node.children.remove(child);
            else
                removeLeaves(child);

        }

    }

}
