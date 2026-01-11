package Graphs.Graph4;

import java.util.*;

// this code use for finding Minimum Spanning Tree using Prim's Algorithm
public class PrimsAlgorithm {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Helper class for Priority Queue based on image_7e1ed5.jpg
    static class Pair implements Comparable<Pair> { 
        int v;    // vertex
        int cost; // edge weight

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost; // ascending order of cost
        }
    }

    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length]; //
        PriorityQueue<Pair> pq = new PriorityQueue<>(); //
        
        // Start with node 0
        pq.add(new Pair(0, 0));
        
        int finalCost = 0; // Total weight of MST

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                
                // Add all non-visited neighbors to PQ
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    if (!vis[e.dest]) {
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        System.out.println("Final cost of MST = " + finalCost);
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Creating a weighted undirected graph
        graph[0].add(new Edge(0, 1, 10));
        graph[1].add(new Edge(1, 0, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[2].add(new Edge(2, 0, 15));
        graph[0].add(new Edge(0, 3, 30));
        graph[3].add(new Edge(3, 0, 30));
        graph[1].add(new Edge(1, 3, 40));
        graph[3].add(new Edge(3, 1, 40));
        graph[2].add(new Edge(2, 3, 50));
        graph[3].add(new Edge(3, 2, 50));

        prims(graph);
    }
}