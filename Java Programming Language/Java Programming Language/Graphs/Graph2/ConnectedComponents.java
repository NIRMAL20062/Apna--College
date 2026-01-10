package Graphs.Graph2;

import java.util.*;

public class ConnectedComponents {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // 1. The Main DFS Loop (Handles multiple components)
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                // Found a new component - start DFS from here
                System.out.print("Component: ");
                dfsUtil(graph, i, vis);
                System.out.println(); // New line for next component
            }
        }
    }

    // 2. The Helper Function (Standard DFS recursion)
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // Mark and visit
        vis[curr] = true;
        System.out.print(curr + " ");

        // Visit neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsUtil(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 7; // As seen in your image (nodes 0-3 and nodes 4-6)
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Component 1 (Nodes 0, 1, 2, 3)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        // Component 2 (Nodes 4, 5, 6)
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        dfs(graph);
    }
}