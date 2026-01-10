class profitLoss {

	// Brute force solution to find the maximum profit from stock prices
	// Time Complexity: O(n^2)
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int currmax = 0;
            for (int j = i + 1; j < prices.length; j++) {  // Fix: use prices.length not -1
                currmax = prices[j] - prices[i];            // Fix: calculate profit
                max = Math.max(currmax, max);               // Fix: add semicolon
            }
        }
        return max;
    }


    // Optimized code for that finds the maximum profit from stock prices
    // Time Complexity: O(n)
    public int maxProfit(int[] prices) {
		

    public static void main(String[] args) {
	   profitLoss pl = new profitLoss();
	   int[] prices = {7, 1, 5, 3, 6, 4};
	   System.out.println("Maximum Profit: " + pl.maxProfit(prices)); // Output: 5
    }
}
