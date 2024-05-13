import java.util.ArrayList;

class Node {
    String key;
    Node left, right;

    public Node(String item)
    {
        key = item;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;

    BinaryTree() { root = null; }
    static ArrayList<String> food = new ArrayList<>();

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;

        /* first print the data of node */
        System.out.print(node.key + " ");

        /* then recur on left child */
        printPreorder(node.left);
        food.add(node.key);

        /* now recur on right child */
        printPreorder(node.right);
    }

    void searchFood(ArrayList<String> arl){
        //Function with O(n) time complexity to search
        //Trying to find faster time of O(log(n))
        boolean found = false;
        for (String s : arl) {
            if (s.equals("10Fries")) {
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("\nIt exist");
        }
        else {
            System.out.println("\nIt does not exist");
        }
    }
    // Wrappers over above functions
    void printPreorder() { printPreorder(root); }
    void searchFood(){searchFood(food);}

    public static void main(String[] args) {
        long startTime = System.nanoTime(); //Starting time of program
        Runtime rt = Runtime.getRuntime(); //To get readings of memory usage

        BinaryTree tree = new BinaryTree(); //Creating binary tree
        tree.root = new Node("Menu");
        tree.root.left = new Node("1Food");
        tree.root.right = new Node("2Drinks");

        tree.root.left.left = new Node("3Main-Dish");
        tree.root.left.right = new Node("4Side-Dish");

        tree.root.right.left = new Node("5Alcoholic");
        tree.root.right.right = new Node("6Non-alcoholic");

        tree.root.left.left.left = new Node("7Burger");
        tree.root.left.left.right = new Node("8Pizza");
        tree.root.left.right.left = new Node("9Popcorn");
        tree.root.left.right.right = new Node("10Fries");

        tree.root.right.left.left = new Node("11Beer");
        tree.root.right.left.right = new Node("12Wine");
        tree.root.right.right.left = new Node("13Lemon");
        tree.root.right.right.right = new Node("14Water");

        long endTime = System.nanoTime();
        System.out.println("Adding runtime: " + (endTime - startTime)); //Runtime to create tree

        // Function call
        System.out.println("\nPreorder traversal");
        tree.printPreorder();
        endTime = System.nanoTime();
        System.out.println("\nReading runtime: " + (endTime - startTime)); //Runtime to read tree

        tree.searchFood();
        endTime = System.nanoTime();
        System.out.println("Reading runtime: " + (endTime - startTime)); //Runtime to search tree

        long total_mem = rt.totalMemory();
        long free_mem = rt.freeMemory();
        long used_mem = total_mem - free_mem; //Calculate the memory being used
        System.out.println("\nAmount of used memory: " + used_mem);
        endTime = System.nanoTime();
        System.out.println("Total runtime: " + (endTime - startTime)); //Total runtime for program
    }
}