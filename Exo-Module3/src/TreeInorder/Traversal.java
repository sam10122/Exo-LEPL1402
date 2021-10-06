package TreeInorder;

import java.util.List;
import java.util.Stack;

public class Traversal {

    public static void recursiveInorder(Node root, List<Integer> res) {
        if (root == null){
            return;
        }
        if(root.isLeaf()){
            res.add(root.val);
            return;
        }
        else{
            recursiveInorder(root.left,res);
            res.add(root.val);
            recursiveInorder(root.right,res);
        }

    }


    public static void iterativeInorder(Node root, List<Integer> res){
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node path = root;

        while (path != null || stack.size() > 0)
        {

            while (path !=  null)
            {

                stack.push(path);
                path = path.left;
            }
            path = stack.pop();

            res.add(path.val);

            path = path.right;
        }
    }

}
