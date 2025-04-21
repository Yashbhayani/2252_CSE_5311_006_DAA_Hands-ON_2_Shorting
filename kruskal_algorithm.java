import java.util.*;

class UnionFind {
    private Map<String, String> parent = new HashMap<>();
    private Map<String, Integer> rank = new HashMap<>();

    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    public String findNode(String node) {
        if (!parent.get(node).equals(node)) {
            parent.put(node, findNode(parent.get(node)));  // Path compression
        }
        return parent.get(node);
    }

    public void union(String u, String v) {
        String rootU = findNode(u);
        String rootV = findNode(v);

        if (!rootU.equals(rootV)) {
            int rankU = rank.get(rootU);
            int rankV = rank.get(rootV);

            if (rankU > rankV) {
                parent.put(rootV, rootU);
            } else if (rankU < rankV) {
                parent.put(rootU, rootV);
            } else {
                parent.put(rootV, rootU);
                rank.put(rootU, rankU + 1);
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    String u, v;
    int weight;

    public Edge(String u, String v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Main {
    private Set<String> nodes = new HashSet<>();
    private List<Edge> edges = new ArrayList<>();

    public void addEdge(String u, String v, int weight) {
        edges.add(new Edge(u, v, weight));
        nodes.add(u);
        nodes.add(v);
    }

    public void kruskalAlgorithm() {
        UnionFind uf = new UnionFind();
        for (String node : nodes) {
            uf.makeSet(node);
        }

        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        for (Edge edge : edges) {
            if (!uf.findNode(edge.u).equals(uf.findNode(edge.v))) {
                mst.add(edge);
                totalWeight += edge.weight;
                uf.union(edge.u, edge.v);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println("Edge (" + edge.u + ", " + edge.v + ") with weight " + edge.weight);
        }

        System.out.println("Total weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        Main graph = new Main();

        graph.addEdge("a", "b", 4);
        graph.addEdge("a", "h", 8);
        graph.addEdge("b", "h", 11);
        graph.addEdge("b", "c", 8);
        graph.addEdge("c", "i", 2);
        graph.addEdge("c", "f", 4);
        graph.addEdge("c", "d", 7);
        graph.addEdge("d", "e", 9);
        graph.addEdge("d", "f", 14);
        graph.addEdge("e", "f", 10);
        graph.addEdge("f", "g", 2);
        graph.addEdge("g", "h", 1);
        graph.addEdge("g", "i", 6);
        graph.addEdge("h", "i", 7);

        graph.kruskalAlgorithm();
    }
}
