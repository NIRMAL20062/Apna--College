package Graphs.Graph3;
import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // Helper class for Priority Queue
    static class Pair implements Comparable<Pair> {
        int n; // node
        int path; // shortest distance to this node

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; // path-based sorting (ascending)
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize with infinity
        dist[src] = 0; // Source distance is 0

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // always gives min path node first 
        pq.add(new Pair(src, 0));  // add initial source node 

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.n]) {  // if current node is not visited
                vis[curr.n] = true;

                // Relaxation step
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { // Relaxation logic
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));  // add updated node with new distance
                    }
                }
            }
        }

        // Print results
        for (int i = 0; i < dist.length; i++) {
            System.out.println("0 -> " + i + " distance: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Graph edges from image_54aa81.jpg
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        dijkstra(graph, 0);
    }
}

// pseudo code 