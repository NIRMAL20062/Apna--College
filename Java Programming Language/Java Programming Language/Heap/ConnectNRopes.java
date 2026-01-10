import java.util.PriorityQueue;

public class ConnectNRopes {
    
    /*
     * Problem: Connect N Ropes with Minimum Cost
     * 
     * Given N ropes of different lengths, we need to connect these ropes into one rope.
     * The cost to connect two ropes is equal to the sum of their lengths.
     * Find the minimum cost to connect all ropes.
     * 
     * Example:
     * Input: ropes = {4, 3, 2, 6}
     * Output: 29
     * 
     * Explanation:
     * 1. Connect 2 and 3 -> cost = 5, ropes = {4, 5, 6}
     * 2. Connect 4 and 5 -> cost = 9, ropes = {9, 6}
     * 3. Connect 9 and 6 -> cost = 15
     * Total cost = 5 + 9 + 15 = 29
     * 
     * Approach: Use Min Heap (Priority Queue)
     * Always connect two smallest ropes first to minimize cost
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    
    public static int connectRopes(int ropes[]) {
        // Min heap to store rope lengths
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add all ropes to the priority queue
        for(int i=0; i<ropes.length; i++) {
            pq.add(ropes[i]);
        }
        
        int cost = 0;
        
        // Keep connecting until one rope remains
        while(pq.size() > 1) {
            // Remove two smallest ropes
            int min1 = pq.remove();
            int min2 = pq.remove();
            
            // Calculate cost and add to total
            int newRope = min1 + min2;
            cost += newRope;
            
            // Add the new rope back to heap
            pq.add(newRope);
            
            System.out.println("Connect " + min1 + " + " + min2 + " = " + newRope + " | Total cost so far: " + cost);
        }
        
        return cost;
    }
    
    public static void main(String args[]) {
        int ropes[] = {4, 3, 2, 6};
        
        System.out.println("Rope lengths: ");
        for(int rope : ropes) {
            System.out.print(rope + " ");
        }
        System.out.println("\n");
        
        System.out.println("Connecting ropes:");
        int minCost = connectRopes(ropes);
        
        System.out.println("\nMinimum cost to connect all ropes: " + minCost);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Test Case 2
        int ropes2[] = {2, 5, 4, 8, 6, 3};
        System.out.println("\nTest Case 2:");
        System.out.println("Rope lengths: ");
        for(int rope : ropes2) {
            System.out.print(rope + " ");
        }
        System.out.println("\n");
        
        System.out.println("Connecting ropes:");
        int minCost2 = connectRopes(ropes2);
        System.out.println("\nMinimum cost: " + minCost2);
    }
}
