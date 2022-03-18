package tree;

import tree.balanced.BalancedTree;
import tree.binary.BinaryTree;

public class TreeTest {
    // Driver code
    public static void main(String[] args) {
        System.out.println("AVL Tree Example");
        BalancedTree avl_tree = new BalancedTree();
        avl_tree.insert( 5); avl_tree.insert( 3);
        avl_tree.insert( 2); avl_tree.insert( 4);
        avl_tree.insert( 8); avl_tree.insert( 6);
        avl_tree.insert( 7); avl_tree.insert( 3);
        avl_tree.insert( 9);
        avl_tree.traverse();
        avl_tree.delete(3);
        System.out.println("\nAfter Deletion: ");
        avl_tree.traverse();

        System.out.println("Binary Tree Example");
        BinaryTree tree = new BinaryTree();
        tree.insert( 5); tree.insert( 3);
        tree.insert( 2); tree.insert( 4);
        tree.insert( 8); tree.insert( 6);
        tree.insert( 7); tree.insert( 3);
        tree.insert( 9);
        tree.traverse();
        tree.delete(3);
        System.out.println("\nAfter Deletion: ");
        tree.traverse();
    }
}
