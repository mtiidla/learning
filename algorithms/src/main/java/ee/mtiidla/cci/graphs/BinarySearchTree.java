package ee.mtiidla.cci.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

    public static class Node implements TreePrinter.PrintableNode {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return String.valueOf(data);
        }
    }

    public List<Integer> preOrderTraversal(Node node) {
        return preOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> preOrderTraversal(Node node, List<Integer> array) {
        if (node != null) {
            array.add(node.data);
            preOrderTraversal(node.left, array);
            preOrderTraversal(node.right, array);
        }
        return array;
    }

    public List<Integer> inOrderTraversal(Node node) {
        return inOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> inOrderTraversal(Node node, List<Integer> array) {
        if (node != null) {
            inOrderTraversal(node.left, array);
            array.add(node.data);
            inOrderTraversal(node.right, array);
        }
        return array;
    }

    public List<Integer> postOrderTraversal(Node node) {
        return postOrderTraversal(node, new ArrayList<>());
    }

    private List<Integer> postOrderTraversal(Node node, List<Integer> array) {
        if (node != null) {
            postOrderTraversal(node.left, array);
            postOrderTraversal(node.right, array);
            array.add(node.data);
        }
        return array;
    }

    public Node fromSortedArray(int[] array) {
        return fromSortedArray(array, 0, array.length - 1);
    }

    private Node fromSortedArray(int[] array, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        Node node = new Node(array[mid]);

        node.left = fromSortedArray(array, start, mid - 1);
        node.right = fromSortedArray(array, mid + 1, end);

        return node;
    }

    public Node search(Node root, int value) {
        if (root == null || root.data == value) {
            return root;
        } else if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public List<Integer> inOrderTraversalIterative(Node root) {
        return inOrderTraversalIterative(root, new ArrayList<>());
    }


    private List<Integer> inOrderTraversalIterative(Node root, List<Integer> values) {
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                values.add(root.data);
                root = root.right;
            }
        }

        return values;
    }

    public List<Integer> preOrderTraversalIterative(Node root) {
        return preOrderTraversalIterative(root, new ArrayList<>());
    }

    private List<Integer> preOrderTraversalIterative(Node root, List<Integer> values) {
        Stack<Node> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                values.add(root.data);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return values;
    }

}
