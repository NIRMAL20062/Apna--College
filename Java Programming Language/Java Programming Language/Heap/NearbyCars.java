import java.util.PriorityQueue;

public class NearbyCars {
    
    /*
     * Problem: Find K Nearest Cars to Origin
     * 
     * Given N cars with their (x, y) coordinates on a 2D plane,
     * find the K nearest cars to the origin (0, 0).
     * 
     * Distance from origin = sqrt(x^2 + y^2)
     * 
     * We can use a Max Heap to keep track of K closest cars.
     * Time Complexity: O(N log K)
     * Space Complexity: O(K)
     */
    
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;  // distance squared to avoid floating point
        int idx;     // car index
        
        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq;  // Min heap (smaller distance first)
        }
    }
    

    
    public static void main(String args[]) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }
        
        //nearest K cars
        for(int i=0; i<k; i++) {
            System.out.println("C"+pq.remove().idx);
        }
    }
}
