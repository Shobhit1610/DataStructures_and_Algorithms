import java.util.ArrayList;

public class Check_If_Trees_Mirror_In_Structure {
 

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static boolean areMirror(Node n1, Node n2) {

        if(n1.children.size()==0 && n2.children.size()==0)
            return true;

        if(n1.children.size()!=n2.children.size())
            return false;    

        boolean result = true;

        for(int i=0;i<n1.children.size();i++)
        {
            result = result && areMirror(n1.children.get(i), n2.children.get(n2.children.size()-1-i));
        }

        return result;
    }
}
