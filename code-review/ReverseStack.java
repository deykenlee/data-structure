
import java.util.Stack;

/**
 * 利用递归和栈操作实现栈逆序，没有使用额外空间。
 * 如果使用新栈，那么一个弹，一个压就好
 * 
 * 主要思想如下：釜底抽薪式，每次将栈底元素弹出，直到栈空，再将元素一个个压回
 */
public class ReverseStack {
    public static int getLastNum(Stack<Integer> s) {
        /**
         * 将栈的最后一个元素弹栈并返回
         */
        int num = s.pop();
        if (s.isEmpty()) {
            //如果弹出后栈为空，则代表num是最后一个元素
            return num;
        } else {
            //如果不为空，递归调用该方法，直到最后一个元素被弹出并返回
            int last = getLastNum(s);
            return last;
        }
    }

    public static void reverse(Stack<Integer> s) {
        
        if (s.isEmpty()) {
            return;
        }
        //一直将栈底元素弹出，直到栈空，再依次将弹出的元素压回
        int i = getLastNum(s);
        reverse(s);
        s.push(i);
        
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < 10; i++) {
            s.push(i);
        }
        ReverseStack.reverse(s);
        System.out.print(s.pop());
    }

}