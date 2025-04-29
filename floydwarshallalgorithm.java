import java.util.*;

class Graph {
    private int V;
    private List<int[]> edges;

    public Graph(int verticesCount) {
        this.V = verticesCount;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int w) {
        edges.add(new int[]{u, v, w});
    }

    public int[][] floydWarshall() {
        int[][] dist = new int[V][V];

        // Initialize distances
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        // Set initial edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE 
                        && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    public int getVerticesCount() {
        return V;
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 3, 7);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, -4);
        graph.addEdge(2, 1, -2);
        graph.addEdge(3, 2, -3);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 0, 2);
        graph.addEdge(4, 2, 7);

        int[][] shortestPaths = graph.floydWarshall();

        System.out.println("All-pairs shortest distances matrix:");
        System.out.print("     ");
        for (int v = 0; v < graph.getVerticesCount(); v++) {
            System.out.printf("%7d", v);
        }
        System.out.println();

        for (int u = 0; u < graph.getVerticesCount(); u++) {
            System.out.printf("%2d  ", u);
            for (int v = 0; v < graph.getVerticesCount(); v++) {
                if (shortestPaths[u][v] == Integer.MAX_VALUE) {
                    System.out.printf("%7s", "INF");
                } else {
                    System.out.printf("%7d", shortestPaths[u][v]);
                }
            }
            System.out.println();
        }
    }
}
