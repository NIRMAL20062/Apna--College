import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello, World!";
        String reversed = reverseString(input);
        
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }

    // Function to reverse a string using a stack
    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // StringBuilder is more efficient than string concatenation
        StringBuilder reversed = new StringBuilder();

        // Pop characters to build the reversed string
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
