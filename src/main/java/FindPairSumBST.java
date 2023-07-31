import java.util.ArrayList;
import java.util.HashSet;

class Node{
    int data;
    Node left,right;
    Node(int val){
        data=val;
        left=right=null;
    }
}

class BinarySearchTree{
    Node root;
    BinarySearchTree(){
        root=null;
    }
    BinarySearchTree(int val){
        root = new Node(val);
    }
    void insert(int key){
        root=insertRec(root,key);
    }

     Node insertRec(Node root, int key) {
        if(root==null)
            return new Node(key);
        if(key>root.data)
            root.right= insertRec(root.right,key);
        else
           root.left= insertRec(root.left,key);
        return root;
    }

    void inorder()
    {
        inorderRec(root);
    }

     void inorderRec(Node root) {
        if (root!=null)
        {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);

        }
    }

    void inorderRecResultStoreList(Node root, ArrayList<Integer> V) {

        if (root!=null)
        {
            inorderRecResultStoreList(root.left,V);
            //System.out.print(root.data + " ");
            V.add(root.data);
            inorderRecResultStoreList(root.right,V);

        }
    }


    static void inorderRecResultStoreSet(Node root, int sum, HashSet<Integer> V) {

        if (root!=null)
        {
            inorderRecResultStoreSet(root.left,sum,V);
            //System.out.print(root.data + " ");
            if(V.contains(sum- root.data))
            {
                System.out.println("found "+root.data +" + "+(sum- root.data)+"="+sum);
                return;
            }
            else
                V.add(root.data);
            inorderRecResultStoreSet(root.right,sum,V);

        }
    }
}
public class FindPairSumBST {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.insert(16);
        tree.insert(25);
        int sum=28;
        // Print inorder traversal of the BST
        //tree.inorder();
       //FindPairSum2Pointer(tree,sum);
        //System.out.println();
        //for(int i=0;i<list.size();i++)
          //  System.out.print(list.get(i)+" ");
        FindPairSumHashing(tree,sum);
    }
    static void FindPairSumHashing(BinarySearchTree tree,int sum){
        HashSet<Integer> set=new HashSet<>();
        tree.inorderRecResultStoreSet(tree.root,sum,set);
    }
   static void FindPairSum2Pointer(BinarySearchTree tree,int sum){
        ArrayList<Integer> list=new ArrayList<>();
        tree.inorderRecResultStoreList(tree.root, list);
        int i=0;
        int j=list.size()-1;
        while(i<j)
        {
            if(list.get(i)+list.get(j)==sum){
                System.out.println("found "+list.get(i) +" + "+list.get(j)+"="+sum);
                return;
            }
             else if (list.get(i)+list.get(j)>sum)
             {
               j--;
             }else
                 i++;
        }
       System.out.println("not found");
    }

}
