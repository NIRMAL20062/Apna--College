package Graphs.Graph1;

import java.util.*;

public class BFSGraph {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // BFS Traversal
    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();
            // visit node if not visited
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                // add neighbors
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    // Graph creation
    @SuppressWarnings("unchecked")
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 1));
        graph[1].add(new Edge(1, 4, 1));

        graph[2].add(new Edge(2, 5, 1));

        graph[3].add(new Edge(3, 6, 1));
        graph[4].add(new Edge(4, 6, 1));
        graph[5].add(new Edge(5, 6, 1));
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        bfs(graph);
    }
}





// Mental cheat code (never forget this)
// Array → length
// String → length()
// Collection (ArrayList, HashSet, etc.) → size()
// Interface<Type> name = new Implementation<>();



// graph = [
//     0 → ArrayList<Edge> [Edge(0,1), Edge(0,2)]  // graph[0]size() = 2
//     1 → ArrayList<Edge> [Edge(1,2)]             // graph[1].size() = 1
//     2 → ArrayList<Edge> []                       // graph[2].size() = 0
// ]
// graph.length = 3 (number of vertices)