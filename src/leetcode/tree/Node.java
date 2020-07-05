package leetcode.tree;


public class Node {
    private String name;
    private int right;
    private int left;
    private int level;

    public Node(String name, int right, int left, int level) {
        this.name = name;
        this.right = right;
        this.left = left;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name;
    }
}
