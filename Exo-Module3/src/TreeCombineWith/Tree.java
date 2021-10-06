public class Tree {

    public Node root;

    public Tree(Node root){
        this.root = root;
    }

    public Tree combineWith(Tree o){
        if(o == null || o.root == null){
            return this;
        }
        if(this.root == null){
            return o;
        }
        int addVal = o.root.val + this.root.val;
        Tree left = new Tree(this.root.left).combineWith(new Tree(o.root.left));
        Tree right = new Tree(this.root.right).combineWith(new Tree(o.root.right));
        Tree result = new Tree(new Node(addVal,left.root,right.root));
        return result;
    }
}