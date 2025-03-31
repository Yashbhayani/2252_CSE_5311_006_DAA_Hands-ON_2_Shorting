
class Node {
    int value;
    Node left, right;
    int height;

    public Node(int key) {
        value = key;
        left = right = null;
        height = 1;
    }
}

class Main {
    Node root;

    public Main() {
        root = null;
    }

    // Insert a node into the AVL Tree
    public Node insertNode(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.value) {
            root.left = insertNode(root.left, key);
        } else {
            root.right = insertNode(root.right, key);
        }

        root.height = 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && key < root.left.value) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && key > root.right.value) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && key > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && key < root.right.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Left rotate the subtree rooted at z
    public Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        z.height = 1 + Math.max(getTreeHeight(z.left), getTreeHeight(z.right));
        y.height = 1 + Math.max(getTreeHeight(y.left), getTreeHeight(y.right));

        return y;
    }

    // Right rotate the subtree rooted at z
    public Node rightRotate(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        y.right = z;
        z.left = T3;

        z.height = 1 + Math.max(getTreeHeight(z.left), getTreeHeight(z.right));
        y.height = 1 + Math.max(getTreeHeight(y.left), getTreeHeight(y.right));

        return y;
    }

    // Get the height of the tree
    public int getTreeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Get the balance factor of a node
    public int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return getTreeHeight(root.left) - getTreeHeight(root.right);
    }

    // Inorder traversal of the AVL tree
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.value + " ");
            inorder(root.right);
        }
    }

    // Search for a node with the given key
    public Node searchNode(Node root, int key) {
        if (root == null || root.value == key) {
            return root;
        }

        if (key < root.value) {
            return searchNode(root.left, key);
        }

        return searchNode(root.right, key);
    }

    // Delete a node with a given key
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.value) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.value) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node temp = findMinValueNode(root.right);
            root.value = temp.value;
            root.right = deleteNode(root.right, temp.value);
        }

        root.height = 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Find the node with the minimum value in the given subtree
    public Node findMinValueNode(Node root) {
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static void main(String[] args) {
        Main avl = new Main();

        Node root = null;

        root = avl.insertNode(root, 50);
        root = avl.insertNode(root, 30);
        root = avl.insertNode(root, 40);
        root = avl.insertNode(root, 70);
        root = avl.insertNode(root, 10);
        root = avl.insertNode(root, 60);
        root = avl.insertNode(root, 20);

        System.out.println("Inorder Traversal of AVL Tree:");
        avl.inorder(root);
        System.out.println();

        System.out.println("Minimum Value Node: " + avl.findMinValueNode(root).value);

        root = avl.deleteNode(root, 10);
        System.out.println("Inorder Traversal after deletion of 10:");
        avl.inorder(root);
        System.out.println();

        root = avl.deleteNode(root, 50);
        System.out.println("Inorder Traversal after deletion of 50:");
        avl.inorder(root);
        System.out.println();

        root = avl.deleteNode(root, 20);
        System.out.println("Inorder Traversal after deletion of 20:");
        avl.inorder(root);
        System.out.println();

        System.out.println("Minimum Value Node after deletion of Node 10, 20, 50: " +
                avl.findMinValueNode(root).value);

        root = avl.deleteNode(root, 100);
        System.out.println("Inorder Traversal after deletion of non-existing node:");
        avl.inorder(root);
        System.out.println();
    }
}

