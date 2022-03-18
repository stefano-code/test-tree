package tree;

public class Node {
    public int value;
    public int height;  // used for balanced tree
    public Node left, right;

    public Node(int d) {
        value = d;
        height = 1;
    }
}
