import java.util.*;

public class StackImplementLLOOPS {

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}


	// 💡 Suggested OOP-based Refactor (non-static methods + members):
	static class Stack {
		private Node head = null; // Not static anymore, per instance

		public boolean isEmpty() {
			return head == null;
		}

		public void push(int data) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}

		public int pop() {
			if (isEmpty()) return -1;
			int top = head.data;
			head = head.next;
			return top;
		}

		public int peek() {
			if (isEmpty()) return -1;
			return head.data;
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		System.out.println("Is stack empty? " + stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Top element is: " + stack.peek()); // 30
		System.out.println("Popped element is: " + stack.pop()); // 30
		System.out.println("Popped element is: " + stack.pop()); // 20
		System.out.println("Is stack empty? " + stack.isEmpty()); // false
		System.out.println("Popped element is: " + stack.pop()); // 10
		System.out.println("Is stack empty? " + stack.isEmpty()); // true
	}
}
