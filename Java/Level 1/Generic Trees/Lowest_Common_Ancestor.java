import java.util.ArrayList;

public class Lowest_Common_Ancestor {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {

        ArrayList<Integer> ar1 = getPath(node, d1);
        ArrayList<Integer> ar2 = getPath(node, d2);

        int r1 = ar1.size() - 1;
        int r2 = ar2.size() - 1;

        // We will check for common part from starting of root so have to check for
        // common part from back of both array

        int result = 0;
        while (r1 >= 0 && r2 >= 0) {
            if (ar1.get(r1) == ar2.get(r2))
                result = ar1.get(r1);
            else
                break;
            r1--;
            r2--;    
        }

        return result;

    }

    public static ArrayList<Integer> getPath(Node root, int data) {

        ArrayList<Integer> res = new ArrayList<>();

        if(root.data==data)
        {
            res.add(root.data);
            return res;
        }
        if(root.data!=data && root.children.size()==0)
        {
            return res;
        }

        for(Node child :root.children)
        {
            res = getPath(child, data);
            if(res.size()>0)
            {
                res.add(root.data);
                break;
            }
        }

        return res;

    }

}
