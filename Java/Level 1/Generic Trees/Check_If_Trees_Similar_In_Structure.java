import java.util.ArrayList;

public class Check_If_Trees_Similar_In_Structure {
    
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static boolean areSimilar(Node n1, Node n2) {

        if(n1.children.size()==0 && n2.children.size()==0)
        {
            return true;
        }
        if(n1.children.size()!=n2.children.size())
            return false;
            

        boolean result = true;

        //Check for either n1 or n2
        for(int i=0;i<n1.children.size();i++)
        {
            result = result && areSimilar(n1.children.get(i), n2.children.get(i));
        }

        return result;
    }
}
