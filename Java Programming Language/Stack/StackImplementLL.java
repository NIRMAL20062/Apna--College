import java.util.*;
public class StackImplementLL {



	static class Node{
		int Data ;
		Node next;
		Node(int data){
			this.Data = data;
			this.next = null;
		}

	}
// 🔍 Core Observations:
// 🔸 1. Use of static everywhere in Stack
// You're doing:

// static Node head = null;
// And every method is:


// public static ...
// 🧠 This means:

// There is only one shared head for all instances of Stack.

// Even if you make two stacks, they’ll both point to the same memory, behaving unexpectedly.

// 📉 That's not object-oriented programming (OOP). You should design the Stack class so each object has its own linked list.


	static class Stack {
		static Node head = null; // initializing the head of the stack as null 
	

		// Making a isEmpty function
		public static boolean isEmpty() {
			return head == null;
		}

		// Making a push function
		public static void push(int data) {
			Node newNode = new Node(data);
			if (head == null) {
				head = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
		}

		// Making a pop function
		public static int pop() {
			if (isEmpty()) {
				return -1; // Stack is empty
			} else {
				int topData = head.Data;
				head = head.next; // Move head to the next node
				return topData;
			}
		}

		// Making a peek function
		public static int peek() {	
			if (isEmpty()) {
				return -1; // Stack is empty
			} else {
				return head.Data; // Return the data of the top node
			}
		}
	}


	public static void main(String[] args) {
		
		Stack stack = new Stack();
		System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true
		stack.push(10);
		stack.push(20);
		stack.push(30);
		
		System.out.println("Top element is: " + stack.peek()); // Should print 30
		
		System.out.println("Popped element is: " + stack.pop()); // Should print 30
		System.out.println("Popped element is: " + stack.pop()); // Should print 20
		
		System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
		
		System.out.println("Popped element is: " + stack.pop()); // Should print 10
		System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true
	}

}

