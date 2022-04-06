import java.util.ArrayList;

public class Linearize_The_Tree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // HAve to convert whole tree to link list in pre order manner
    static Node root;
    public static void linearize(Node node) {


        for (Node child : node.children) {

            linearize(child);
        }

        //Now link the head of last children to the tail of second last children
        
        //Have to stop when only one child(leftmost) is left
        while(node.children.size() >1)
        {
            Node lastChildTree = node.children.remove(node.children.size()-1);

            //As last was removed so second last become last
            Node secondLastChildTree = node.children.get(node.children.size()-1);

            Node righmostLeafNodeInSecondLastChildTree = getRightmostLeafNode(secondLastChildTree);
            righmostLeafNodeInSecondLastChildTree.children.add(lastChildTree);
        }


    }

    public static Node getRightmostLeafNode(Node root)
    {
        if(root.children.isEmpty())
            return root;
            
        //Rightmost node occur at 3 time in preorder
        return getRightmostLeafNode(root.children.get(root.children.size()-1));
    }

}
