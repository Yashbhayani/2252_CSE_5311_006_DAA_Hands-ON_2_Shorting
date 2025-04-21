import java.util.*;

public class Main {
    private Map<String, List<String>> graph;

    public Main() {
        graph = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        graph.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        graph.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void depthFirstSearch(String startNode) {
        Set<String> visitedNodes = new HashSet<>();
        dfsRecursive(startNode, visitedNodes);
    }

    private void dfsRecursive(String node, Set<String> visitedNodes) {
        if (visitedNodes.contains(node)) {
            return;
        }

        System.out.print(node + " ");
        visitedNodes.add(node);

        for (String neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visitedNodes.contains(neighbor)) {
                dfsRecursive(neighbor, visitedNodes);
            }
        }
    }

    public static void main(String[] args) {
        Main graph = new Main();

        graph.addEdge("u", "v");
        graph.addEdge("u", "x");
        graph.addEdge("v", "y");
        graph.addEdge("x", "v");
        graph.addEdge("y", "x");
        graph.addEdge("w", "y");
        graph.addEdge("w", "z");
        graph.addEdge("z", "z");

        System.out.println("Depth First Search starting from node 'u':");
        graph.depthFirstSearch("u");
        System.out.println();
    }
}
