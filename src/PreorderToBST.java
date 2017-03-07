/**
 * Created by andy on 3/7/17.
 */
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }

}

public class PreorderToBST {
    public int pIndex = 0;

    public Node constructTree(int[] preorder, int data, int min, int max){
        if(pIndex  < preorder.length){
            if(preorder[pIndex] > min && preorder[pIndex] < max){
                Node root = new Node(data);
                pIndex ++;
                if(pIndex < preorder.length){
                    root.left = constructTree(preorder, preorder[pIndex], min, data);
                    root.right = constructTree(preorder, preorder[pIndex], data, max);
                }
                return root;
            }
        }
        return null;
    }



    public Node reconstructTree(int[] preorder, int data, int start, int end){
        if(start < end){
            Node root = new Node(data);
            int mid = start;
            while(preorder[mid] <= data) mid ++;
            mid -- ;
            root.left = reconstructTree(preorder, preorder[start +1], start+1, mid);
            root.right = reconstructTree(preorder, preorder[mid +1], mid+1, end);
            return root;
        }
        if(start == end) return new Node(data);
        return null;
    }


    public void displayTree(Node root){
        if(root != null){
            displayTree(root.left);
            System.out.println(" " + root.data);
            displayTree(root.right);
        }
    }

    public static void main(String[] args){
        PreorderToBST p = new PreorderToBST();
        int[] preOrder = {20,10,5,1,7,15,30,25,35,32,40};
        //Node root = p.constructTree(preOrder, preOrder[0], Integer.MIN_VALUE, Integer.MAX_VALUE);

        Node root = p.reconstructTree(preOrder, preOrder[0], 0, preOrder.length - 1);
        System.out.println("Inorder Traversal: ");
        p.displayTree(root);
    }

}
