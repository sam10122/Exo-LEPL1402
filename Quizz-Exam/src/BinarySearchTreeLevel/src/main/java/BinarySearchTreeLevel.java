import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Question:
 *
 * You are asked to retrieve the elements of the binary search tree
 * at a given level in increasing order (see the TODO below)
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * A Binary Search Tree is a Data Structure that represents
 * a set (no duplicates thus) of integers stored such that
 * for a given node, keys in the left subtree are all smaller that the key in the node
 *                   keys in the right right subtree are larger than the key in the node
 *
 * Your algorithm should have a time complexity of Theta(n)
 * where n is the number of elements in the set.
 *
 * Feel free to add methods or fields in the class but do not modify
 * the signature and behavior of existing code
 *
 */
public class BinarySearchTreeLevel {

    public class Duo{
        int elem;
        int nivel;
        public Duo(int elem, int nivel){
            this.elem = elem;
            this.nivel = nivel;
        }
    }


    private Node root;             // root of BST

    private class Node {

        private int key;           // sorted by key
        private Node left, right;  // left and right subtrees

        public Node(int key) {
            this.key = key;
        }
    }


    public BinarySearchTreeLevel() {
        
    }
 
    public void insert(int key) {
        root = put(root, key);
    }

    private Node put(Node x, int key) {
        if (x == null) return new Node(key);
        if      (key < x.key) x.left  = put(x.left,  key);
        else if (key > x.key) x.right = put(x.right, key);
        return x;
    }

    /**
     * Return the list of values in increasing order stored
     * in the search tree at a given level
     *
     *         2       // level 0
     *       /  \
     *      0    9     // level 1
     *          / \
     *         5   10  // level 2
     *          \
     *           6     // level 3
     *
     * Your algorithm should run in O(n) where n
     * is the number of different values in the tree
     * @param level of the tree to extract
     * @return all the values at the specified levels in increasing order.
     *         If level is not in the possible range, an empty list.
     */
    public List<Integer> getLevel(int level) {
        List<Duo> list = new ArrayList<>();
        recursiveInorder(root,list,0);
        List<Integer> l = new ArrayList<>();
        for(Duo i : list){
            if(i.nivel == level){
                l.add(i.elem);
            }
        }
        return l;
    }

    public  void recursiveInorder(Node root, List<Duo> res, int nivel) {
        if (root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(new Duo(root.key,nivel));
            return;
        }
        else{
            nivel++;
            recursiveInorder(root.left,res,nivel);
            nivel--;
            res.add(new Duo(root.key,nivel));
            nivel++;
            recursiveInorder(root.right,res,nivel);
        }

    }








}