import java.util.*;

class Graph {
    private int V;
    private Map<Integer, List<int[]>> graph;

    public Graph(int verticesCount) {
        this.V = verticesCount;
        graph = new HashMap<>();
        for (int i = 0; i < verticesCount; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        graph.get(u).add(new int[]{v, w});
    }

    public int[] dijkstra(int start) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, start});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentDistance = current[0];
            int currentVertex = current[1];

            if (currentDistance > distances[currentVertex]) {
                continue;
            }

            for (int[] neighbor : graph.get(currentVertex)) {
                int nextVertex = neighbor[0];
                int weight = neighbor[1];
                int distance = currentDistance + weight;

                if (distance < distances[nextVertex]) {
                    distances[nextVertex] = distance;
                    queue.offer(new int[]{distance, nextVertex});
                }
            }
        }

        return distances;
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
        graph.addEdge(1, 4, -4); // Warning: Dijkstra doesn't support negative edges properly
        graph.addEdge(2, 1, -2);
        graph.addEdge(3, 2, -3);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 0, 2);
        graph.addEdge(4, 2, 7);

        int startNode = 0;
        int[] shortestDistances = graph.dijkstra(startNode);

        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < graph.getVerticesCount(); i++) {
            System.out.println(startNode + " -> " + i + " = " + 
                (shortestDistances[i] == Integer.MAX_VALUE ? "Infinity" : shortestDistances[i]));
        }
    }
}
