import java.util.Arrays;

public class Main {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int[] bellmanFord(Edge[] edges, int verticesCount, int start) {
        int[] distances = new int[verticesCount];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int i = 0; i < verticesCount - 1; i++) {
            for (Edge edge : edges) {
                if (distances[edge.u] != Integer.MAX_VALUE && distances[edge.u] + edge.w < distances[edge.v]) {
                    distances[edge.v] = distances[edge.u] + edge.w;
                }
            }
        }

        for (Edge edge : edges) {
            if (distances[edge.u] != Integer.MAX_VALUE && distances[edge.u] + edge.w < distances[edge.v]) {
                throw new RuntimeException("Graph contains a negative weight cycle");
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        Edge[] edges = {
            new Edge(0, 1, 6),
            new Edge(0, 3, 7),
            new Edge(1, 2, 5),
            new Edge(1, 3, 8),
            new Edge(1, 4, -4),
            new Edge(2, 1, -2),
            new Edge(3, 2, -3),
            new Edge(3, 4, 9),
            new Edge(4, 0, 2),
            new Edge(4, 2, 7),
        };

        String[] vertices = {"A", "B", "C", "D", "E"};
        int startNode = 0;

        int[] shortestDistances = bellmanFord(edges, vertices.length, startNode);

        System.out.println("Shortest distances from " + vertices[startNode] + ":");
        for (int i = 0; i < vertices.length; i++) {
            System.out.println(vertices[startNode] + " -> " + vertices[i] + " = " + 
                (shortestDistances[i] == Integer.MAX_VALUE ? "Infinity" : shortestDistances[i]));
        }
    }
}
