package com.bridgelabz.assignment;

class MyBinaryNode<K extends Comparable<K>> {
    K key;
    MyBinaryNode<K> left;
    MyBinaryNode<K> right;

    public MyBinaryNode(K key) {
        this.key = key;
        left = null;
        right = null;
    }
}

class MyBinarySearchTree<K extends Comparable<K>> {
    private MyBinaryNode<K> root;

    public void add(K key) {
        root = addRecursively(root, key);
    }

    private MyBinaryNode<K> addRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return new MyBinaryNode<>(key);
        }

        if (key.compareTo(current.key) < 0) {
            current.left = addRecursively(current.left, key);
        } else if (key.compareTo(current.key) > 0) {
            current.right = addRecursively(current.right, key);
        }

        return current;
    }

    public int size() {
        return getSize(root);
    }

    private int getSize(MyBinaryNode<K> node) {
        if (node == null) {
            return 0;
        }

        return 1 + getSize(node.left) + getSize(node.right);
    }

    public boolean search(K key) {
        return searchRecursively(root, key);
    }

    private boolean searchRecursively(MyBinaryNode<K> current, K key) {
        if (current == null) {
            return false;
        }

        if (key.compareTo(current.key) == 0) {
            return true;
        }

        if (key.compareTo(current.key) < 0) {
            return searchRecursively(current.left, key);
        } else {
            return searchRecursively(current.right, key);
        }
    }
}

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        MyBinarySearchTree<Integer> bst = new MyBinarySearchTree<>();
        bst.add(56);
        bst.add(30);
        bst.add(70);

        System.out.println("Size of the binary search tree: " + bst.size());

        int keyToSearch = 63;
        boolean found = bst.search(keyToSearch);
        if (found) {
            System.out.println(keyToSearch + " is found in the binary search tree.");
        } else {
            System.out.println(keyToSearch + " is not found in the binary search tree.");
        }
    }
}
