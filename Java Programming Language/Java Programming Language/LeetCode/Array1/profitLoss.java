class profitLoss {

    // Optimized code that finds the maximum profit from stock prices
    // Time Complexity: O(n)
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        
        return maxProfit;
    }
		

    public static void main(String[] args) {
	   profitLoss pl = new profitLoss();
	   int[] prices = {7, 1, 5, 3, 6, 4};
	   System.out.println("Maximum Profit: " + pl.maxProfit(prices)); // Output: 5
    }
}
