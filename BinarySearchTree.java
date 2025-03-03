public class BinarySearchTree {
    public static void main(String[] args) {
        TreeNodeRecord root = null;
        root = insert(root, 8);
        root = insert(root, 2);
        root = insert(root, 16);
        root = insert(root, 5);
        root = insert(root, 3);
        System.out.println("Pre-order traversal...");
        preOrder(root);
        System.out.println("\nIn-order traversal...");
        inOrder(root);
        System.out.println("\nPost-order traversal...");
        postOrder(root);
    }
    private static TreeNodeRecord insert(TreeNodeRecord node,int value) {
        if (node == null) {
            return new TreeNodeRecord(value, null, null);
        }
        if (value < node.value()) {
            return new TreeNodeRecord(node.value(), insert(node.leftChild(), value), node.rightChild());
        } else if (value > node.value()) {
            return new TreeNodeRecord(node.value(), node.leftChild(), insert(node.rightChild(), value));
        }
        return node;
    }
    private static void preOrder(TreeNodeRecord entry) {
        if (entry == null) {
            return;
        }
        System.out.print(entry.value() + " -> ");
        preOrder(entry.leftChild());
        preOrder(entry.rightChild());
    }
    private static void inOrder(TreeNodeRecord entry) {
        if (entry == null) {
            return;
        }
        inOrder(entry.leftChild());
        System.out.print(entry.value() + " -> ");
        inOrder(entry.rightChild());
    }
    private static void postOrder(TreeNodeRecord entry) {
        if (entry == null) {
            return;
        }
        postOrder(entry.leftChild());
        postOrder(entry.rightChild());
        System.out.print(entry.value() + " -> ");
    }
}