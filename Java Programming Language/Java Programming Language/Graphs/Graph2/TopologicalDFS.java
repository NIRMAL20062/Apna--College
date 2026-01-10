package Graphs.Graph2;

import java.util.*;
// also directed acyclic graph dag
public class TopologicalDFS {
    static class Edge {
        int src, dest;
        
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Create graph from edge list
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Creating a Directed Acyclic Graph (DAG)
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Topological Sort using DFS
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        // Visit all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        
        // Push current vertex to stack after visiting all neighbors
        stack.push(curr);
    }

    // Main topological sort function
    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // Call DFS for all unvisited vertices
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        /*
         * Graph Structure (DAG):
         *       5        4
         *      / \      / \
         *     2   0    1   0
         *      \ /
         *       3
         *       |
         *       1
         * 
         * Expected Topological Order: 5 4 2 3 1 0 (or other valid orderings)
         */
        
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        System.out.println("Topological Sort (DFS):");
        topologicalSort(graph);
        System.out.println();
    }
}



// graph = [
//     0 → ArrayList<Edge> [Edge(0,1), Edge(0,2)]  // graph[0].size() = 2
//     1 → ArrayList<Edge> [Edge(1,2)]             // graph[1].size() = 1
//     2 → ArrayList<Edge> []                       // graph[2].size() = 0
// ]
// // graph.length = 3 (number of vertices)