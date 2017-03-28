/**
 * Created by andy on 3/20/17.
 */


public class TreeClassicProblem {
    static class Node{
        int data;
        Node left,right;
        Node(int val){
            data = val;
            left = right = null;
        }
    }/*
    public boolean containsTree(Node t1, Node t2){
        if(t2 == null) return true;
        return subTree(t1, t2);
    }*/

    public boolean subTree(Node r1, Node r2){
        if(r2 == null) return true;
        if(r1 == null) return false;
        if(matchTree(r1, r2)) return true;
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }


    public boolean matchTree(Node r1, Node r2){
        if(r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        //else if(r1.data != r2.data) return false;
        return (r1.data == r2.data) && matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
    }


    public static void main(String[] args){
        TreeClassicProblem tree = new TreeClassicProblem();
        Node T = new Node(1);
        T.left = new Node(2);
        T.right = new Node(4);
        T.left.left = new Node(3);
        T.left.right = new Node(6);
        T.right.right = new Node(5);

        Node S = new Node(2);
        S.left = new Node(3);
        S.right = new Node(6);
        //S.left.left = new Node(3);
        if(tree.subTree(T,S)) System.out.println("Yes");
        else System.out.println("No");
    }

}
