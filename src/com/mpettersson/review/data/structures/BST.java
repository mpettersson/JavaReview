package com.mpettersson.review.data.structures;


import java.util.ArrayList;
import java.util.LinkedList;

public class BST<T>{

    class Node<T>{
        public T value;
        public Node left, right;

        public Node(T value){
            this.value = value;
        }
    }

    public Node root;

    public BST(T[] values){
        for(T t : values)
        this.root = createBST(values, 0, values.length - 1);
    }

    public boolean isBalanced(Node<T> node){
        if(getHeightForBalanced(node) == -1){
            return false;
        }
        return true;
    }

    public int getHeightForBalanced(Node<T> node){
        // Base Case
        if(node == null){ return 0; }

        // Get left height, if it's unbalanced return -1
        int l_height = getHeightForBalanced(node.left);
        if(l_height == -1){ return -1; }

        // Get right height, it it's unbalanced return -1
        int r_height = getHeightForBalanced(node.right);
        if(r_height == -1){ return -1; }

        // If Unbalanced return -1
        if(Math.abs(l_height - r_height) > 1){ return -1; }

        // Return the height of the longest subtree:
        return (Math.max(l_height, r_height) + 1);

    }

    public Node<T> createBST(T[] values, int start, int end) {
        if(end < start){
            return null;
        }else{
            int mid = (start + end) / 2;
            Node<T> n = new Node<>(values[mid]);
            n.left = createBST(values, start, mid - 1);
            n.right = createBST(values, mid +1, end);
            return n;
        }
    }

    public void printNodesDFS(){
        if(root != null)
            printNodesDFS(this.root);

    }

    public void printNodesDFS(Node<T> n){
        System.out.println(n.value);
        if(n.left != null)
            printNodesDFS(n.left);
        if(n.right != null)
            printNodesDFS(n.right);
    }



    public void printNodesBFS(){
        Queue<Node> queue = new Queue<>();
        queue.add(this.root);

        while(!queue.isEmpty()){
            Node r = queue.remove();
            System.out.println(r.value);
            if(r.left != null)
                queue.add(r.left);
            if(r.right != null)
                queue.add(r.right);
        }
    }


    // for each level of the tree make a Linked list and add it to an arraylist.
    public void createLevelLinkedListDFS(Node<T> n, ArrayList<LinkedList<Integer>> lists, int level){
        if(n == null) {
            return;
        }
        LinkedList<Integer> list = null;
        if(lists.size() == level) {       // Level isn't in the list
            list = new LinkedList<>();
            // Levels are traversed in order.  So, if this is the first time we've visited level i, we must have
            // seen levels 0 through i - 1.  We can therefore safely add the level at the end.
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add((Integer)n.value);
        Node r = n.right;
        Node l = n.left;
        createLevelLinkedListDFS(r, lists, level + 1);
        createLevelLinkedListDFS(l, lists, level + 1);
    }

    ArrayList<LinkedList<Integer>> createLevelLinkedListDFS(){
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createLevelLinkedListDFS(this.root, lists, 0);
        return lists;
    }

    ArrayList<LinkedList<Node>> createLevelLinkedListBFS(Node root){
        ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
        // Visit the root
        LinkedList<Node> current = new LinkedList<Node>();
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0){
            result.add(current); // Add the previous level
            LinkedList<Node> parents = current; // Go to the next level
            current = new LinkedList<Node>();
            for(Node parent : parents){
                // visit the children
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }


}


class TreeDriver{
    public static void main(String[] args) {
        Integer[] values = new Integer[]{1,3,4,6,7,8,9};
        BST bst = new BST(values);

        System.out.println("DFS");
        bst.printNodesDFS();

        System.out.println("\nBFS");
        bst.printNodesBFS();

        ArrayList<LinkedList<Integer>> bstAL= bst.createLevelLinkedListDFS();
        System.out.println("DFS");

        for(LinkedList l : bstAL){
                for(Object o : l){
                    System.out.println((int)o);

            }
        }

        ArrayList<LinkedList<BST.Node>> bstBFS = bst.createLevelLinkedListBFS(bst.root);
        System.out.println("\nBFS");

        for(LinkedList<BST.Node> l : bstBFS){
            for(BST.Node n : l){
                System.out.println(n.value);
            }
        }
    }

}