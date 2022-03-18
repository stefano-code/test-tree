package tree.binary;
import tree.Node;
import tree.Tree;

public class BinaryTree implements Tree{
    private Node root;

    public void insert(int value)
    {
        if(root == null) {
            root = new Node(value);
            return;
        }
        insert(root, value);
    }
    @Override
    public void delete(int value) {
        delete(root, value);
    }
    @Override
    public void traverse() {
        traverseInOrder(root);
    }

    private void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }


    private Node delete(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.value)
            root.left = delete(root.left, key);
        else if (key > root.value)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.value = minValue(root.right);
            root.right = delete(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.value;
        while (root.left != null) {
            minv = root.left.value;
            root = root.left;
        }
        return minv;
    }


    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
}

        /*
        In informatica, un albero binario di ricerca bilanciato è un albero binario di ricerca la cui altezza, grazie a particolari condizioni che la sua struttura deve soddisfare, rimane limitata. Queste condizioni implicano delle operazioni di inserimento ed eliminazione più complesse rispetto a quelle di semplici alberi binari, ma garantiscono che esse vengano eseguite in O(log n).

                         System.out.println(" Inserted " + value + " to left of " + node.value);
                                         System.out.println("  Inserted " + value + " to right of " + node.value);
         */
