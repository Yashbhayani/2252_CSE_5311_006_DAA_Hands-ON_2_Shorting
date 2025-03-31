class Node {
    int data;
    String color;
    Node left, right, parent;

    public Node(int data) {
        this.data = data;
        this.color = "red";
        this.left = this.right = this.parent = null;
    }
}

public class Main {
    private final Node TNULL;
    private Node root;

    public Main() {
        TNULL = new Node(0);
        TNULL.color = "black";
        root = TNULL;
    }

    // Left rotate
    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != TNULL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Right rotate
    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != TNULL) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    // Insert node
    public void insertNode(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = "red";

        Node y = null;
        Node x = root;

        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;

        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = "black";
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        fixInsertNode(node);
    }

    // Fix the tree after inserting a node
    public void fixInsertNode(Node k) {
        while (k.parent.color.equals("red")) {
            if (k.parent == k.parent.parent.right) {
                Node u = k.parent.parent.left;

                if (u.color.equals("red")) {
                    u.color = "black";
                    k.parent.color = "black";
                    k.parent.parent.color = "red";
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = "black";
                    k.parent.parent.color = "red";
                    leftRotate(k.parent.parent);
                }
            } else {
                Node u = k.parent.parent.right;

                if (u.color.equals("red")) {
                    u.color = "black";
                    k.parent.color = "black";
                    k.parent.parent.color = "red";
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = "black";
                    k.parent.parent.color = "red";
                    rightRotate(k.parent.parent);
                }
            }

            if (k == root) {
                break;
            }
        }

        root.color = "black";
    }

    // Inorder traversal
    public void inorder(Node node) {
        if (node != TNULL) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Utility to print the tree structure
    public void printTree() {
        printHelper(root, "", true);
    }

    public void printHelper(Node node, String indent, boolean last) {
        if (node != TNULL) {
            System.out.print(indent);

            if (last) {
                System.out.print("R----");
                indent += "     ";
            } else {
                System.out.print("L----");
                indent += "|    ";
            }

            String sColor = node.color;
            System.out.println(node.data + "(" + sColor + ")");
            printHelper(node.left, indent, false);
            printHelper(node.right, indent, true);
        }
    }

    public static void main(String[] args) {
        Main rbt = new Main();

        rbt.insertNode(50);
        rbt.insertNode(30);
        rbt.insertNode(40);
        rbt.insertNode(70);
        rbt.insertNode(10);
        rbt.insertNode(60);
        rbt.insertNode(20);

        System.out.println("Inorder Traversal of Red-black Tree:");
        rbt.inorder(rbt.root);
        System.out.println();

        System.out.println("Tree structure of Red-black Tree:");
        rbt.printTree();
    }
}
