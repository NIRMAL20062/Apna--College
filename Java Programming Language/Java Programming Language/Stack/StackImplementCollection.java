import java.util.*;

public class StackImplementCollection {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println("Stack: " + stack);
		System.out.println("Peek: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Stack: " + stack);
		System.out.println("Is stack empty? " + stack.isEmpty());
		stack.push(4);
		System.out.println("Stack: " + stack);
		System.out.println("Size of stack: " + stack.size());
		System.out.println("Iterating through stack:");
		for (int i : stack) {
			System.out.println(i);
		}
	}
}