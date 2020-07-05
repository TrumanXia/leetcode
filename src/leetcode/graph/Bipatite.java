package leetcode.graph;

public class Bipatite {
    public static void main(String[] args) {
        int[][] a = {{1},{0,3},{3},{1,2}};
        System.out.println(new Bipatite().isBipartite(a));
    }

    /*public boolean isBipartite(int[][] graph) {
        int numOfVertexes = graph.length;
        int[] colored = new int[numOfVertexes];
        colored[0] = 1;
        for (int v = 0; v < numOfVertexes; v++) {
            for (int w = 0; w < graph[v].length; w++) {

                if (colored[graph[v][w]] == 0) {
                    colored[graph[v][w]] = 3 - colored[v];
                } else if (colored[graph[v][w]] != 3 - colored[v]) {
                    return false;
                }
            }
        }
        return true;
    }*/

    public boolean isBipartite(int[][] graph) {
        int numOfVertexes = graph.length;
        int[] colored = new int[numOfVertexes];
        colored[0] = 1;
        for (int v = 0; v < numOfVertexes; v++) {
            for (int w = 0; w < graph[v].length; w++) {

                if (colored[graph[v][w]] == 0) {
                    colored[graph[v][w]] = 3 - colored[v];
                } else if (colored[graph[v][w]] != 3 - colored[v]) {
                    return false;
                }
            }
        }
        return true;
    }
}
