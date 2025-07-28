import java.util.Stack;

public class StockSpan {
	public static int[] calculateSpan(int[] prices) {
	   int n = prices.length;
	   int[] span = new int[n];
	   Stack<Integer> stack = new Stack<>();

	   for (int i = 0; i < n; i++) {
		  // Pop elements from stack while the current price is greater than the price at the index stored at the top of the stack
		  while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
			 stack.pop();
		  }
		  // If stack is empty, it means no previous price was greater, so span is i + 1
		  if (stack.isEmpty()) {
			 span[i] = i + 1;
		  } else {
			 // Otherwise, span is the difference between current index and index of last higher price
			 span[i] = i - stack.peek();
		  }
		  // Push current index onto the stack
		  stack.push(i);
	   }
	   return span;
    }

    public static void main(String[] args) {
	   int[] prices = {100, 80, 60, 70, 60, 75, 85};
	   int[] span = calculateSpan(prices);
	   for (int s : span) {
		  System.out.print(s + " ");
	   }
    }
	
}
