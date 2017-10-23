import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
public class QueueByTwoStack {

    Stack<Integer> push;
    Stack<Integer> pop;

    public QueueByTwoStack() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void add(int num) {
        push.push(num);
    }

    public int poll() {
        if(push.isEmpty() && pop.isEmpty()){
            throw new RuntimeException();
        } else if(pop.isEmpty()) {
            while(!push.isEmpty())
            pop.push(push.pop());
        }
        return pop.pop();     
    }
    
    public int peek(){
        if(push.isEmpty() && pop.isEmpty()) {
            throw new RuntimeException();
        } else if(pop.isEmpty()) {
            while(!push.isEmpty())
            pop.push(push.pop());
        }
        return pop.peek();
    }

    public static void main(String args[]) {
        QueueByTwoStack queue = new QueueByTwoStack();
        queue.add(3);
        queue.add(8);
        queue.add(10);
        System.out.println(queue.poll());
        queue.add(5);
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        
    }

}