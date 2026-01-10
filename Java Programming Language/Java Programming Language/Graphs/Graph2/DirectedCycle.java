package Graphs.Graph2;

import java.util.*;

public class DirectedCycle {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        // Loop for connected components
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true; // Add to current recursion path

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            
            // Case 1: Neighbor is already in the current recursion stack
            if (stack[e.dest]) {
                return true;
            }
            
            // Case 2: Neighbor not visited, recurse further
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false; // Backtrack: remove from stack
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Create a directed cycle: 0 -> 2 -> 3 -> 0
        graph[0].add(new Edge(0, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));

        System.out.println("Cycle exists: " + isCycle(graph));
    }
}