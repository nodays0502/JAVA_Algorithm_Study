package BOJ.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BOJ_1991 {
    private static class Node{
        char value;
        Node left;
        Node right;

        public Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(char value) {
            this.value = value;
        }
    }
    private static class Tree{
        Node root;
        public void add(char value , char leftValue, char rightValue){
            if(root == null){
                root = new Node(value);
                if(leftValue != '.'){
                    root.left = new Node(leftValue);
                }
                if(rightValue != '.'){
                    root.right = new Node(rightValue);
                }
            }else if(leftValue != '.' || rightValue != '.'){
                Node node = search(root,value);
//                System.out.printf("%c %c %c %c\n",value,leftValue,rightValue,node.value);
                if(node != null){
                    if(leftValue != '.'){
                        node.left = new Node(leftValue);
                    }
                    if(rightValue != '.'){
                        node.right = new Node(rightValue);
                    }
                }
            }
        }
        public Node search(Node now, char value){
            Node temp ;
            if(now == null){
                return null;
            }
            if(now.value == value){
                return now;
            }
            temp = search(now.left,value);
            if(temp != null){
                return temp;
            }
            temp = search(now.right,value);
            return temp;
        }
        public void preOrder(Node root) {
            System.out.print(root.value);
            if(root.left != null) preOrder(root.left);
            if(root.right != null) preOrder(root.right);
        }
        public void inOrder(Node root) {
            if(root.left != null) inOrder(root.left);
            System.out.print(root.value);
            if(root.right != null) inOrder(root.right);
        }
        public void postOrder(Node root) {
            if(root.left != null) postOrder(root.left);
            if(root.right != null) postOrder(root.right);
            System.out.print(root.value);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        Tree tree = new Tree();
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);
            tree.add(parent,leftChild,rightChild);
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
    }
}
