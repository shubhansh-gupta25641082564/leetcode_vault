// Last updated: 21/09/2025, 17:37:00
import java.util.*;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    private void transfer() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public int pop() {
        if (outStack.isEmpty()) transfer();
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) transfer();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
