import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Student: Joseph Grados
 * Professor: Hyesung Park
 * Course: ITEC 2150
 * Date: 11/3/2022
 * Sources: https://github.com/ramakastriot/practiceit/blob/master/chapter14/splitStack.java
 * Purpose: An example of how the function of stacks works
 */
public class SplitStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(new Integer(5));
        s.push(new Integer(-5));
        s.push(new Integer(67));
        s.push(new Integer(-45));
        s.push(new Integer(67));
        s.push(new Integer(9));
        s.push(new Integer(0));
        s.push(new Integer(-42));
        s.push(new Integer(56));
        s.push(new Integer(-7));
        System.out.println(s);

        splitStack(s);
        System.out.println(s);
        Stack<Integer>s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(-2);
        s1.push(-3);
        s1.push(4);
        s1.push(-5);
        s1.push(6);
        s1.push(-7);
        s1.push(8);
        s1.push(-9);
        System.out.println(s1);
        splitStack(s1);
        System.out.println(s1);

    }


    public  static void splitStack(Stack<Integer> s) {
        reverseStack(s);
        Queue<Integer> ex = new LinkedList<Integer>();
        int numNegatives = 0;

        while(!s.isEmpty()) {
            if(s.peek() < 0)
                numNegatives++;
            ex.add(s.pop());
        }

        while(numNegatives > 0) {
            if(ex.peek() < 0) {
                s.push(ex.remove());
                numNegatives--;
            } else {
                ex.add(ex.remove());
            }
        }

        while(!ex.isEmpty()) {
            if(s.peek() == -9){
                s.pop();
                s.push(9);
            }
            s.push(ex.remove());
        }
    }
    public static void reverseStack(Stack<Integer> s) {
        Queue<Integer> reversedStack = new LinkedList<>();
        while(!s.empty()) {
            reversedStack.add(s.pop());
        }
        for (Integer integer : reversedStack) {
            s.push(integer);
        }
    }


}
