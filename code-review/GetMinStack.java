import java.util.Stack;

public class GetMinStack {
    Stack<Integer> data;
    Stack<Integer> min;

    public GetMinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    public void push(int num) {
        data.push(num);
        if (min.isEmpty() || min.peek() >= num) {
             min.push(num);
        }
    }

    public int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException();
        }
        int out = data.pop();
        if (min.peek() >= out) {
            min.pop();
        }
        return out;
    }

    public int getMin() {
        if (min.isEmpty()) {
            throw new RuntimeException();
        }
        return min.peek();
    }

    public static void main(String args[]) {
        GetMinStack minStack = new GetMinStack();
        for (int i = 8; i > 0; i--) {
            minStack.push(i);
        }
        System.out.print(minStack.getMin());
    }
}