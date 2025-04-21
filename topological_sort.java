import java.util.*;
import java.util.function.BiConsumer;


public class Main {

    // Helper method to perform DFS from a given node.
    private static void dfs(String node, Map<String, List<String>> graph, Set<String> visited, List<String> stack) {
        visited.add(node);
        // Get neighbors; if the node is not a key, then there are no neighbors.
        List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, stack);
            }
        }
        // After visiting all neighbors, push the node onto the stack.
        stack.add(node);
    }

    // The topological sort function.
    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        Set<String> visited = new HashSet<>();
        List<String> stack = new ArrayList<>();

        // Collect all vertices (both keys and neighbors) in a sorted set to mimic sorted order
        // as in the Python version ("for v in sorted(graph_vertices)").
        Set<String> allVertices = new TreeSet<>(graph.keySet());
        for (List<String> neighbors : graph.values()) {
            allVertices.addAll(neighbors);
        }

        // Process each vertex in sorted order.
        for (String vertex : allVertices) {
            if (!visited.contains(vertex)) {
                dfs(vertex, graph, visited, stack);
            }
        }

        // Reverse the stack to get the correct topological order.
        Collections.reverse(stack);
        return stack;
    }

    public static void main(String[] args) {
        // Create the graph as a Map where each key is a vertex and its value is a list of adjacent vertices.
        Map<String, List<String>> graph = new HashMap<>();

        // Helper function to add edges to the graph.
        // If the vertex key is not present, initialize with an empty list.
        BiConsumer<String, List<String>> addEdges = (vertex, edges) -> {
            graph.computeIfAbsent(vertex, k -> new ArrayList<>()).addAll(edges);
        };

        // Add the edges similar to the Python code.
        addEdges.accept("m", Arrays.asList("q", "r", "x"));
        addEdges.accept("n", Arrays.asList("q", "u", "o"));
        addEdges.accept("q", Arrays.asList("t"));
        addEdges.accept("u", Arrays.asList("t"));
        addEdges.accept("o", Arrays.asList("r", "s", "v"));
        addEdges.accept("r", Arrays.asList("u", "y"));
        addEdges.accept("s", Arrays.asList("r"));
        addEdges.accept("p", Arrays.asList("s", "z", "o"));
        addEdges.accept("y", Arrays.asList("v"));
        addEdges.accept("v", Arrays.asList("x", "w"));
        addEdges.accept("w", Arrays.asList("z"));

        // Perform the topological sort.
        List<String> result = topologicalSort(graph);

        // Print the results.
        System.out.println("Topological Sort Order:");
        System.out.println(result);
    }
}
