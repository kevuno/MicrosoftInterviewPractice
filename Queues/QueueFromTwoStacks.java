import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    public static class MyQueue<E>{
        private Stack<E> pop_stack = new Stack<E>();
        private Stack<E> push_stack = new Stack<E>();

        
        public void enqueue(E element){
            push_stack.push(element);
        }
        
        public void dequeue(){
            int pop_size = pop_stack.size();
            int push_size = push_stack.size();
            if (pop_size == 0){
                if(push_size > 0){
                    for(int i = 0; i < push_size; i++){
                        pop_stack.push(push_stack.pop());
                    }
                }
            }
            pop_stack.pop();
        }
        
        public E peek(){
            int pop_size = pop_stack.size();
            int push_size = push_stack.size();
            if (pop_size == 0){
                if(push_size > 0){
                    for(int i = 0; i < push_size; i++){
                        pop_stack.push(push_stack.pop());
                    }
                }
            }
            return pop_stack.peek();
        }
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
