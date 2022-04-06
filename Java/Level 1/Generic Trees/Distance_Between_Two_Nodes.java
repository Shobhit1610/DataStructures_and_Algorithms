import java.util.ArrayList;

public class Distance_Between_Two_Nodes {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // Distance = Distance of d1 from lca + Distance of d2 from lca
    public static int distanceBetweenNodes(Node node, int d1, int d2) {

        ArrayList<Integer> ar1 = getPath(node, d1);
        ArrayList<Integer> ar2 = getPath(node, d2);

        int r1 = ar1.size() - 1;
        int r2 = ar2.size() - 1;

        // int lca = 0;
        while (r1 >= 0 && r2 >= 0 && ar1.get(r1) == ar2.get(r2)) {
            // lca = ar1.get(r1);
            r1--;
            r2--;
        }

        int result = r1 + r2 + 2;

        return result;

    }

    public static ArrayList<Integer> getPath(Node node, int data) {

        ArrayList<Integer> res = new ArrayList<>();

        if (node.data == data) {
            res.add(node.data);
            return res;
        }
        if (node.data != data && node.children.size() == 0) {
            return res;
        }

        for (Node child : node.children) {
            res = getPath(child, data);

            if (res.size() > 0) {
                res.add(node.data);
                break;
            }

        }

        return res;

    }

}
