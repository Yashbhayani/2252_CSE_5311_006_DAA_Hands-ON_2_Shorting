class Node {
    int value;
    Node left, right;

    public Node(int key) {
        value = key;
        left = right = null;
    }
}

public class Main {

    // Insert a node into the BST
    public static Node insertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.value) {
            root.left = insertNode(root.left, key);
        } else {
            root.right = insertNode(root.right, key);
        }

        return root;
    }

    // Search for a node with the given key
    public static Node searchNode(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }

        if (key < root.value) {
            return searchNode(root.left, key);
        }

        return searchNode(root.right, key);
    }

    // Delete a node from the BST
    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to be deleted found

            // Case 1: Node has no child or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node has two children
            Node temp = findMinValueNode(root.right);
            root.value = temp.value;
            root.right = deleteNode(root.right, temp.value);
        }

        return root;
    }

    // Find the node with the minimum value in a tree
    public static Node findMinValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Inorder traversal of the BST
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Inserting nodes into the BST
        root = insertNode(root, 50);
        root = insertNode(root, 30);
        root = insertNode(root, 70);
        root = insertNode(root, 40);
        root = insertNode(root, 10);
        root = insertNode(root, 60);
        root = insertNode(root, 20);

        System.out.println("Inorder Traversal of BST:");
        inorder(root);
        System.out.println();

        System.out.println("Minimum Value Node: " + findMinValueNode(root).value);

        // Deleting nodes
        root = deleteNode(root, 10);
        System.out.println("Inorder Traversal after deletion of Node 10:");
        inorder(root);
        System.out.println();

        root = deleteNode(root, 50);
        System.out.println("Inorder Traversal after deletion of Node 50:");
        inorder(root);
        System.out.println();

        root = deleteNode(root, 20);
        System.out.println("Inorder Traversal after deletion of Node 20:");
        inorder(root);
        System.out.println();

        System.out.println("Minimum Value Node after deletion of Node 10, 20, 50: " +
                findMinValueNode(root).value);

        root = deleteNode(root, 100);
        System.out.println("Inorder Traversal after deletion of non-existing node:");
        inorder(root);
        System.out.println();
    }
}
