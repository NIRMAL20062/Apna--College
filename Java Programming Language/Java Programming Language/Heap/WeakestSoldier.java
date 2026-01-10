import java.util.PriorityQueue;

public class WeakestSoldier {
    
    /*
     * Problem: Weakest Rows in Matrix
     * 
     * Given a m x n binary matrix where:
     * - 1 represents a soldier
     * - 0 represents a civilian
     * - Soldiers are always positioned before civilians in each row
     * 
     * Find the K weakest rows.
     * A row i is weaker than row j if:
     * 1. Number of soldiers in row i < number of soldiers in row j, OR
     * 2. Both rows have same soldiers but i < j
     * 
     * Example:
     * Input: 
     * army = [[1,0,0,0],
     *         [1,1,1,1],
     *         [1,0,0,0],
     *         [1,0,0,0]]
     * k = 2
     * 
     * Output: [0, 2] (rows with indices 0 and 2 are weakest with 1 soldier each)
     * 
     * Approach: Use Min Heap with custom comparator
     * Time Complexity: O(m * (n + log m))
     * Space Complexity: O(m)
     */
    
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;
        
        public Row(int soldiers, int idx) {
            this.soldiers = soldiers;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Row r2) {
            if(this.soldiers == r2.soldiers) {
                return this.idx - r2.idx;  // If soldiers are same, smaller index is weaker
            }
            return this.soldiers - r2.soldiers;  // Fewer soldiers means weaker
        }
    }
    
    public static void weakestRows(int army[][], int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>();
        
        // Count soldiers in each row and add to priority queue
        for(int i=0; i<army.length; i++) {
            int count = 0;
            for(int j=0; j<army[i].length; j++) {
                if(army[i][j] == 1) {
                    count++;
                } else {
                    break;  // Since soldiers come before civilians
                }
            }
            pq.add(new Row(count, i));
        }
        
        // Get k weakest rows
        System.out.println("K weakest rows:");
        for(int i=0; i<k; i++) {
            Row weakest = pq.remove();
            System.out.println("Row " + weakest.idx + " with " + weakest.soldiers + " soldiers");
        }
    }
    
    public static void main(String args[]) {
        int army[][] = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        };
        int k = 2;
        
        System.out.println("Army Matrix:");
        for(int i=0; i<army.length; i++) {
            System.out.print("Row " + i + ": ");
            for(int j=0; j<army[i].length; j++) {
                System.out.print(army[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        weakestRows(army, k);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Test Case 2
        int army2[][] = {
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}
        };
        
        System.out.println("\nTest Case 2:");
        System.out.println("Army Matrix:");
        for(int i=0; i<army2.length; i++) {
            System.out.print("Row " + i + ": ");
            for(int j=0; j<army2[i].length; j++) {
                System.out.print(army2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        weakestRows(army2, 3);
    }
}
