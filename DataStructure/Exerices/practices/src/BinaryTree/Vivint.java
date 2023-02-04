package BinaryTree;

public class Vivint {

    private static class Node{
        int data_;
        Node left, right;

        Node(int key) {
            this.data_ = key;
            left = right = null;
        }
    }

    // function to do inorder traversal left -- root -- right
    public static void inOrderTraversal (Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data_ + " ");
        inOrderTraversal(root.right);

    }


    // function that insert an element in bst
    public static Node insert (Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(root.data_ > key) {
            root.left = insert(root.left, key);
        }else{
            root.right = insert(root.right, key);
        }
            return root;
    }

    // function to build a BST
    public static Node BuildBST(int[] keys) {
        Node root = null; // initialization
        for(int key: keys) {
            root = insert(root, key);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] keys = {10,8,1,0,4,6,7};
        Node root = BuildBST(keys);
        inOrderTraversal(root);
    }

    // inset iterative

//    public static Node insertIterative() {
//
//    }
}
