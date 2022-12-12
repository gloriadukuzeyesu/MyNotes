package BinaryTree;

import com.sun.source.tree.Tree;

public class LowestCommonAncestor {
    // treeNode class
    static class TreeNode{
        int val_;
        TreeNode left_;
        TreeNode right_;

        TreeNode(){
        }
        TreeNode(int val){
            val_ = val;
        }
        TreeNode ( int val, TreeNode left, TreeNode right) {
            val_ = val;
            left_ = left;
            right_ = right;
        }

        // equals () will compare the values instead of the object
        @Override
        public boolean equals ( Object obj ){
            if( obj == null){
                return false;
            }
            else{
                return this.val_ == ((TreeNode) obj).val_;
            }
        }
    }

    public static TreeNode lowestCommonAncestor( TreeNode p, TreeNode q, TreeNode root){
        if( root == null ){
            return null;
        }
        if( root.equals(p) || root.equals(q)){
            return root;
        }
        TreeNode left = lowestCommonAncestor(p,q,root.left_);
        TreeNode right = lowestCommonAncestor(p,q,root.right_);

        if(left != null && right != null) return root;

        return (left != null) ? left:right;
    }

    public static void  main (String[] args){
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode ( 1);
        TreeNode root = new TreeNode ( 3, left, right);
        left.left_ = new TreeNode(6);
        left.right_ = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        right.left_ = new TreeNode(0);
        right.right_ = new TreeNode(8);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        TreeNode ancestor = lowestCommonAncestor(p,q,root);
        System.out.println("Ancestor for " + p.val_ + " and " + q.val_ + " is " + ancestor.val_);
    }
}
