import java.awt.*;
import java.util.HashMap;

public class Day6 {

    static HashMap<Long, Long> cache= new HashMap<>();

    public static int factorial(int num){
        if(num <= 1)
            return 1;
        return num* factorial(num -1);
    }
    public static Long findFibonacciNumber(Long fibonacciNumber){

        if(fibonacciNumber == 0 || fibonacciNumber == 1 )
            return fibonacciNumber;
        return (findFibonacciNumber(fibonacciNumber -1) + findFibonacciNumber(fibonacciNumber -2));
    }

    public static Long findFibonacciNumberOptimised(Long fibonacciNumber){
        if(cache.containsKey(fibonacciNumber))
            return cache.get(fibonacciNumber);
        if(fibonacciNumber == 0 || fibonacciNumber == 1 )
            return fibonacciNumber;
        Long fib = (findFibonacciNumberOptimised(fibonacciNumber -1) + findFibonacciNumberOptimised(fibonacciNumber -2));
        cache.put(fibonacciNumber, fib);
        return fib;
    }

    public static void preorder(Node node) {
        if (node != null)
        {
            System.out.print(node.getValue() + ", " );
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }
    public static void postorder(Node node) {
        if (node != null)
        {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.print(node.getValue() + ", " );

        }
    }

    public static void inorder(Node node) {
        if (node != null)
        {
            inorder(node.getLeft());
            System.out.print(node.getValue() + ", " );
            inorder(node.getRight());

        }
    }

    public static boolean search(Node node, int target) {
        if(node == null) return false;
        if(node.getValue() < target)
            return search(node.getRight(), target);
        else if(node.getValue() > target)
            return search(node.getLeft(), target);
        else
            return true;
    }

    public static Node insert(Node node, int value) {
        if(node == null){
            return node = new Node(value);
        }
        if(node.getValue() < value){
            node.setRight(insert(node.getRight(), value));
        }
        else if(node.getValue() > value){
            node.setLeft(insert(node.getLeft(), value));
        }
        return node;
    }

    public static int findMin(Node node) {
        if(node == null)  throw new IllegalArgumentException("Tree is empty");
        while(node.getLeft() != null){
            node = node.getLeft();
        }
        return node.getValue();
    }

    public static int findMax(Node node) {
        if(node == null)  throw new IllegalArgumentException("Tree is empty");
        while(node.getRight() != null){
            node = node.getRight();
        }
        return node.getValue();
    }

    public static  void main(String[] args){
        int num = 4;
        System.out.println("Factorial of " + num + " is " + factorial(num));
        long fibonacciNumber = 50;
//        System.out.println("Fibonacci at " + fibonacciNumber + " is " + findFibonacciNumber(fibonacciNumber));
        System.out.println("Fibonacci at " + fibonacciNumber + " is " + findFibonacciNumberOptimised(fibonacciNumber));


        Node node3 = new Node(3);
        Node node4 = new Node(7);
        Node node5 = new Node(20);
        Node node1 = new Node(5, node3, node4);
        Node node2 = new Node(15, null , node5);
        Node root = new Node(10, node1, node2);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);

        int target = 22;
        System.out.println();
        System.out.println("Does tree contains " + target + ": " + search(root, target));

        int value = 12;
        Node n = insert(root, value);
        if(n != null){
            if(n.getLeft() != null && n.getLeft().getValue() == value)
                System.out.println(value + " is inserted on left of " + n.getValue());
            else
                System.out.println(value + " is inserted on right of " + n.getValue());
        }
        else
            System.out.println("Node already exists");

        System.out.println("Minimum value in tree is " + findMin(root));
        System.out.println("Maximum value in tree is " + findMax(root));
    }

}
