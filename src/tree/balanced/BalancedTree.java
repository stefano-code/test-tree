package tree.balanced;
import tree.Node;
import tree.RotationTree;

public class BalancedTree implements RotationTree {
    private Node root;

    public void insert(int value) {
        root = insertNode(root, value);
    }
    public void delete(int value) {
        deleteNode(root, value);
    }
    public void traverse() {
        traverseInOrder(root);
    }
    public Node rightRotation(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }
    public Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
    private int getBalanceFactor(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
    private Node insertNode(Node node, int item) {
        if (node == null)
            return (new Node(item));
        if (item < node.value)
            node.left = insertNode(node.left, item);
        else if (item > node.value)
            node.right = insertNode(node.right, item);
        else
            return node;

        node.height = 1 + max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (item < node.left.value) {
                return rightRotation(node);
            } else if (item > node.left.value) {
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        if (balanceFactor < -1) {
            if (item > node.right.value) {
                return leftRotation(node);
            } else if (item < node.right.value) {
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        return node;
    }
    private Node nodeWithMimumValue(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }
    private void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    private Node deleteNode(Node root, int item) {
        if (root == null)
            return root;
        if (item < root.value)
            root.left = deleteNode(root.left, item);
        else if (item > root.value)
            root.right = deleteNode(root.right, item);
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                Node temp = nodeWithMimumValue(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }
        if (root == null)
            return root;

        root.height = max(height(root.left), height(root.right)) + 1;
        int balanceFactor = getBalanceFactor(root);
        if (balanceFactor > 1) {
            if (getBalanceFactor(root.left) >= 0) {
                return rightRotation(root);
            } else {
                root.left = leftRotation(root.left);
                return rightRotation(root);
            }
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(root.right) <= 0) {
                return leftRotation(root);
            } else {
                root.right = rightRotation(root.right);
                return leftRotation(root);
            }
        }
        return root;
    }
}
