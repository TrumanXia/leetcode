package leetcode.graph;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1}, {1, 2, 3}};
        new Main().play(a);
    }

    private void play(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.println(i + ":" + j);
                if (i == 0)
                    return;
            }
        }
    }
}
