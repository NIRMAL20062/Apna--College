package Graphs.Graph3;
import java.util.ArrayList;
public class GraphAllPaths {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Logic based on image_5436a7.jpg
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        // Base Case: If we reach the target, print the path
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        // Recursive Step: Visit all neighbors
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            
            // Recurse with neighbor as new source, appending current node to path string
            printAllPaths(graph, e.dest, dest, path + src + " ");
        }
    }

    public static void main(String[] args) {
        /*
           Graph from image_5436a7.jpg:
           5 -> 0 -> 3 -> 1
           5 -> 2 -> 3 -> 1
           4 -> 0
           4 -> 1
        */
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        int source = 5, target = 1;
        System.out.println("All paths from " + source + " to " + target + ":");
        
        // Start with an empty string for the path
        printAllPaths(graph, source, target, "");
    }
}