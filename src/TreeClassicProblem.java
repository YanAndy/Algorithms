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




    public int shortestDistance(Node root, Node n1, Node n2){
      Node lca = findLCA(root, n1, n2);
      int d1 = pathLength(lca, n1);
      int d2 = pathLength(lca, n2);

      System.out.println("Distance from " + lca.data + " to " + n1.data + " is " + d1);
      System.out.println("Distance from " + lca.data + " to " + n2.data + " is " + d2);
      return d1 + d2;
    }

    public Node findLCA(Node root, Node n1, Node n2){
        if(root == null || n1 == root || n2 == root) return root;
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }

    public int pathLength(Node root, Node n){
        if(root == null) return -1;
        //int x = -1;
        if(root == n) return 0;
        if(pathLength(root.left, n) >= 0) return pathLength(root.left, n) +1;
        if(pathLength(root.right, n) >= 0) return pathLength(root.right, n) +1;
        else return -1;
    }


    public static void main(String[] args){
        TreeClassicProblem tree = new TreeClassicProblem();
        /*
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
        else System.out.println("No");*/

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        Node n2 = root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        Node n1 = root.left.right.right = new Node(45);
        System.out.println("LCA of n1 and n2: " + tree.findLCA(root, n1, n2).data);
        System.out.println("Distance between 45 and 20 is : "
                + tree.shortestDistance(root, n1, n2));
    }

}
