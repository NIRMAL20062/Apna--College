package Graphs.Graph3;

import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSorting {
    static class Edge {
        int src, dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        // Handle connected components
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        // Print the stack contents (this is the sorted order)
        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    // Kahn's Algorithm (BFS) for Topological Sorting
    public static void topSortBFS(ArrayList<Edge>[] graph) {
        int V = graph.length;
        int[] indegree = new int[V];

        // Compute indegree of each vertex
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        int processed = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();
            order.add(curr);
            processed++;

            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                indegree[e.dest]--;
                if (indegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        if (processed != V) {
            System.out.println("Graph has a cycle; topological sort not possible.");
            return;
        }

        for (int node : order) {
            System.out.print(node + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        // Push current node to stack AFTER visiting all its neighbors
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Example Graph: 5->0, 5->2, 2->3, 3->1, 4->1, 4->0
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        System.out.println("Topological Sort Order (DFS):");
        topSort(graph);

        System.out.println();
        System.out.println("Topological Sort Order (BFS/Kahn):");
        topSortBFS(graph);
    }
}