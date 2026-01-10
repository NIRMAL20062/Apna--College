package Graphs.Graph2;

import java.util.*;

public class GraphCycle {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Main function to handle disconnected components
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // Initial parent for a new component is -1
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true; // Cycle exists in one of the parts
                }
            }
        }
        return false;
    }

    // Helper function (DFS logic)
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // Case 3: Neighbor not visited
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } 
            // Case 1: Neighbor visited and neighbour is NOT the parent -> CYCLE FOUND
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            // Case 2: Neighbor is parent -> Do nothing (continue loop)
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Creating a cycle: 0-1, 1-2, 2-0

        //this is graph structure
        // 0---1
        // | / |
        // 2
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[0].add(new Edge(0, 2));

        if (detectCycle(graph)) {
            System.out.println("Cycle detected in the graph!");
        } else {
            System.out.println("No cycle found.");
        }
    }
}