package greedy.mst;

import java.util.*;

public class Kruskal {

    int vertices ;
    List<Edge> allEdges = new ArrayList<>() ;

    public  Kruskal(int vertices){
        this.vertices = vertices ;
    }

    public void addEdge(int source , int destination, int weight){
        Edge edge = new Edge(source, destination, weight) ;
        allEdges.add(edge) ;
    }

    // Remove parallel edges and self-loops
    public List<Edge> filterEdges() {
        Map<String, Edge> edgeMap = new HashMap<>();

        for (Edge edge : allEdges) {
            if (edge.source != edge.destination) { // Skip self-loops
                String key = Math.min(edge.source, edge.destination) + "-" + Math.max(edge.source, edge.destination);

                // Keep the edge with the minimum weight if there are parallel edges
                if (!edgeMap.containsKey(key) || edgeMap.get(key).weight > edge.weight) {
                    edgeMap.put(key, edge);
                }
            }
        }

        return new ArrayList<>(edgeMap.values()); // Return the filtered edges
    }

    public void krusualMST(){
        List<Edge> mst = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(vertices);

        // Remove parallel edges and self-loops
        List<Edge> filteredEdges = filterEdges();

        // Sort all edges by weight
        Collections.sort(filteredEdges);

        // Iterate over sorted edges and apply union-find
        for (Edge edge : allEdges) {
            int rootSource = disjointSet.find(edge.source);
            int rootDestination = disjointSet.find(edge.destination);

            // If including this edge doesn't form a cycle
            if (rootSource != rootDestination) {
                mst.add(edge); // Include this edge in the MST
                disjointSet.union(rootSource, rootDestination);
            }
        }

        // Print the MST
        printMST(mst);
    }

    // Method to print the MST
    public void printMST(List<Edge> mst) {
        System.out.println("Minimum Spanning Tree (MST):");
        for (Edge edge : mst) {
            System.out.println("Edge: (" + edge.source + " -> " + edge.destination + ") weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {

        int vertices = 6 ;
        Kruskal graph = new Kruskal(vertices) ;

        // Adding edges to the graph (source, destination, weight)
        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 2, 8);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 5, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 2);
        graph.krusualMST();
    }

}
