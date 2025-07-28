import java.util.Stack;
public class ReverseStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Original Stack: " + stack);
		pushAtBottom(stack, 4);
		System.out.println("Stack after pushing 4 at bottom: " + stack);

		// Reverse the stack
		reverseStack(stack);
		System.out.println("Reversed Stack: " + stack);
		
	}

	// Function to push an element at bottom of stack
	public static void pushAtBottom(Stack<Integer> stack, int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			return;
		}
		int temp = stack.pop();
		pushAtBottom(stack, x);
		stack.push(temp);
	}

	// Function to reverse the stack
	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int temp = stack.pop();
		reverseStack(stack);
		pushAtBottom(stack, temp);
	}
}