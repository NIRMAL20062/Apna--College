package Graphs.Graph2;

import java.util.*;

public class BipartiteGraph {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        // Initialize all nodes with -1 (no color)
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        // Loop to handle disconnected components
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // If not colored, start BFS
                q.add(i);
                col[i] = 0; // Assign initial color (e.g., Yellow)

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        // Case 3: Neighbor has no color
                        if (col[e.dest] == -1) {
                            int nextCol = (col[curr] == 0) ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } 
                        // Case 1: Neighbor has same color -> NOT Bipartite
                        else if (col[e.dest] == col[curr]) {
                            return false; 
                        }
                        // Case 2: Neighbor has different color -> Continue (OK)
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
           Sample Non-Bipartite Graph (Odd Cycle: 0-1-2-0)
              0 --- 1
               \   /
                 2
        */
        int V = 3;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[0].add(new Edge(0, 2));

        System.out.println("Is Bipartite: " + isBipartite(graph));
    }
}