package Graphs.Graph1;

import java.util.*;

public class GraphPath {
    // Helper class to represent a directed edge
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        // Base Case: If current node is the destination
        if (src == dest) {
            return true;
        }

        // Mark the current node as visited
        vis[src] = true;

        // Visit all neighbors of the current source
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            
            // If neighbor is not visited and leads to destination
            if (!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*
           Graph structure used in this example:
           0 ----> 1 ----> 3
           |       |       ^
           v       v       |
           2 ----> 4 ------|
        */
        int v = 5; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 4));
        graph[2].add(new Edge(2, 4));
        graph[4].add(new Edge(4, 3));

        int source = 0, destination = 3;
        
        // Output result
        if (hasPath(graph, source, destination, new boolean[v])) {
            System.out.println("Path exists from " + source + " to " + destination);
        } else {
            System.out.println("No path exists.");
        }
    }
}