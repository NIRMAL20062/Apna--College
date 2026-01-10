package Graphs.Graph1;

import java.util.ArrayList;

public class GraphExample {

    // Edge class
    static class Edge {
        int src;      // Source vertex
        int dest;     // Destination vertex  
        int wt;       // Weight of the edge
    
        Edge(int s, int d, int w) {  // Constructor
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }


    // Entry point of the program.
    public static void main(String[] args) {

        /*
                (5)
            0 -------- 1
              \      / \
              (1)\  /   \(3)
                   2      3
                   |
                  (2)
                   |
                   4
        */

        int V = 5; // Number of vertices
        @SuppressWarnings("unchecked")
        // Create adjacency list
        ArrayList<Edge>[] graph = new ArrayList[V]; //array of ArrayLists (adjacency list representation) for storing edges for each vertex

        // Initialize lists
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (undirected graph - add both directions)
        // 0-1 edge
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));

        // 0-2 edge
        graph[0].add(new Edge(0, 2, 1));
        graph[2].add(new Edge(2, 0, 1));

        // 1-2 edge
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 1-3 edge
        graph[1].add(new Edge(1, 3, 3));
        graph[3].add(new Edge(3, 1, 3));

        // 2-4 edge
        graph[2].add(new Edge(2, 4, 2));
        graph[4].add(new Edge(4, 2, 2));

        // Print graph (dry-run friendly)
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.dest + ", " + e.wt + ") ");
            }
            System.out.println();
        }
    }
}