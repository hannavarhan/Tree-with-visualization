
import java.util.ArrayList;

class Node<T>{
    T data;
    Node<T> left;
    Node<T> right;
    int xpos = 0;
    int ypos = 0;

    Node(T value) {
        data = value;
        right = null;
        left = null;
    }
}

class BinaryTree<T extends Comparable<T>> {

    private Node<T> root;
    int totalNodes = 0;
    int maxHeight = 0;

    BinaryTree() {
        root = null;
    }

    Node<T> getRoot() {
        return root;
    }

    public  boolean containsValue(T value) throws NullPointerException {
        if(root == null) {
            throw new NullPointerException("TREE IS EMPTY!");
        }
        Node<T> current = root;
        while (current != null && value.compareTo(current.data) != 0) {
            if (value.compareTo(current.data) < 0)
                current = current.left;
            else
                current = current.right;
        }
        return current != null;
    }

    public T maxInsideTop() throws NullPointerException {
        if(root == null) {
            throw new NullPointerException("TREE IS EMPTY!");
        }
        if(root.right == null && root.left == null) {
            throw new NullPointerException("IT`S A SINGLE ROOT!");
        }
        Node<T> max = root;
        Node<T> current = root;
        while(current != null) {
            if(current.data.compareTo(max.data) > 0 && (current.left != null || current.right != null)) {
                max = current;
            }
            current = current.right;
        }
        return max.data;
    }

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        Node<T> previous = root;
        Node<T> current = value.compareTo(previous.data) < 0 ? previous.left : previous.right;
        while (current != null) {
            previous = current;
            if (value.compareTo(current.data) < 0)
                current = current.left;
            else if (value.compareTo(current.data) > 0)
                current = current.right;
            else
                return false;
        }
        current = new Node(value);
        if (value.compareTo(previous.data) < 0)
            previous.left = current;
        else
            previous.right = current;
        return true;
    }

    public boolean delete(T value) throws NullPointerException {
        if(root == null) {
            throw new NullPointerException("TREE IS EMPTY!");
        }

        Node<T> previousFindNode = null, findNode = root;
        while (findNode != null && value.compareTo(findNode.data) != 0) {
            previousFindNode = findNode;
            if (value.compareTo(findNode.data) < 0)
                findNode = findNode.left;
            else
                findNode = findNode.right;
        }
        if (findNode == null)
            return false;

        if (findNode.right == null) {
            if (previousFindNode == null)
                root = findNode.left;
            else if (previousFindNode.left == findNode)
                previousFindNode.left = findNode.left;
            else
                previousFindNode.right = findNode.left;
        } else {
            Node<T> current = findNode;
            if (current.right.left == null) {
                current.data = current.right.data;
                current.right = current.right.right;
            } else {
                current = current.right;
                while (current.left.left != null)
                    current = current.left;
                findNode.data = current.left.data;
                current.left = current.left.right;
            }
        }
        return true;
    }

    public ArrayList<T> toArray() throws NullPointerException {
        if(root == null)
            throw new NullPointerException("TREE IS EMPTY");
        return toArray(root);
    }

    private ArrayList<T> toArray(Node<T> element) {
        ArrayList<T>  result = new ArrayList<>();
        if(element.left != null) {
            ArrayList<T> temp = toArray(element.left);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
        }
        result.add(element.data);
        if (element.right != null) {
            ArrayList<T> temp = toArray(element.right);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
        }
        return result;
    }

    //обходы
    public ArrayList<T> printNLR() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("TREE IS EMPTY!");
        return printNLR(root);
    }

    private ArrayList<T> printNLR(Node<T> current) {
        ArrayList<T> result = new ArrayList<>();
        if (current != null) {
            result.add(current.data);
            ArrayList<T> temp = printNLR(current.left);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
            temp = printNLR(current.right);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
        }
        return result;
    }

    public ArrayList<T> printLNR() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("TREE IS EMPTY!");
        return printLNR(root);
    }

    private ArrayList<T> printLNR(Node<T> current) {
        ArrayList<T> result = new ArrayList<>();
        if (current != null) {
            ArrayList<T> temp = printNLR(current.left);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
            result.add(current.data);
            temp = printNLR(current.right);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
        }
        return result;
    }

    public int treeHeight(Node<T> t) {
        if(t == null) {
            return -1;
        } else return 1 + max(treeHeight(t.left), treeHeight(t.right));
    }

    private int max(int a, int b) {
        if (a > b) {
            return a;
        } else return b;
    }

    public void computeNodePositions() {
        int depth = 1;
        inorderTraversal(root, depth);
    }

    public void inorderTraversal(Node<T> t, int depth) {
        if (t.left != null) {
            inorderTraversal(t.left, depth + 1);
        }
        t.xpos = totalNodes + 1;
        t.ypos = depth;
        if (t.right != null) {
            inorderTraversal(t.right, depth + 1);
        }
    }

    public ArrayList<T> printLRN() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("TREE IS EMPTY!");
        return printLRN(root);
    }

    private ArrayList<T> printLRN(Node<T> current) {
        ArrayList<T> result = new ArrayList<>();
        if (current != null) {
            ArrayList<T> temp = printNLR(current.left);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
            temp = printNLR(current.right);
            for(int i = 0; i < temp.size(); i++) {
                result.add(temp.get(i));
            }
            result.add(current.data);
        }
        return result;
    }

    public T minValue() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty!");
        Node<T> current = root;
        while (current.left.left != null)
            current = current.left;
        return current.left.data;
    }

    public T maxValue() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty!");
        Node<T> current = root;
        while (current.right.right != null)
            current = current.right;
        return current.right.data;
    }

    public void printHeightNLR() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty!");
        int height = 0;
        printHeightNLR(root, height);
    }

    private void printHeightNLR(Node<T> current, int height) {
        if (current != null) {
            System.out.println(current.data + ", height: " + height);
            printHeightNLR(current.left, ++height);
            --height;
            printHeightNLR(current.right, ++height);
            or
            System.out.println(current.data + ", height: " + height);
            printHeightNLR(current.left, height + 1);
            printHeightNLR(current.right, height + 1);
        }
    }

    public void printHeightLNR() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty!");
        int height = 0;
        printHeightLNR(root, height);
    }

    private void printHeightLNR(Node<T> current, int height) {
        if (current != null) {
            printHeightLNR(current.left, ++height);
            --height;
            System.out.println(current.data + ", height: " + height);
            printHeightLNR(current.right, ++height);
            or
            printHeightLNR(current.left, height + 1);
            System.out.println(current.data + ", height: " + height);
            printHeightLNR(current.right, height + 1);

        }
    }*/

    public int printHeightLRN() throws IllegalArgumentException {
        if (root == null)
            throw new IllegalArgumentException("Tree is empty!");
        int height = 0;
        height = printHeightLRN(root, height);
        return height;

    }

    private int printHeightLRN(Node<T> current, int height) {
        if (current != null) {
            printHeightLRN(current.left, ++height);
            printHeightLRN(current.right, height);
            --height;
            System.out.println(current.data + ", height: " + height);
        }
        return height;
    }
}
