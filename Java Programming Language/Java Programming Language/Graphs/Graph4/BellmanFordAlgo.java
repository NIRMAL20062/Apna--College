package Graphs.Graph4;

import java.util.*;

public class BellmanFordAlgo {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;
        int dist[] = new int[V];

        // 1. Initialize distances
        for (int i = 0; i < V; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        dist[src] = 0;

        // 2. Algo - Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            // Iterate through all edges O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    // Relaxation step
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {  // Avoid overflow of Integer.MAX_VALUE  in java if u add in max value it become negative
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // 3. Print the shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To " + i + " distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Adding edges (includes a negative weight)
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4)); // Negative edge
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -1));

        bellmanFord(graph, 0);
    }
}