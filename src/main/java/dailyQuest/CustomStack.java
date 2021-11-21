package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.Stack;

class CustomStack {

    int MAX_SIZE;
    Stack<Integer> stack;
    int[] increment;

    public CustomStack(int maxSize) {
        MAX_SIZE = maxSize;
        //default to 0
        increment = new int[2000];
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() >= MAX_SIZE) {
            return;
        }
        stack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int incrementValue = increment[stack.size() - 1];
        //reset increment
        increment[stack.size() - 1] = 0;
        return stack.pop() + incrementValue;
    }

    public void increment(int k, int val) {
        int incrementSize = Math.min(k,stack.size());
        for (int i = 0; i < incrementSize; i++) {
            increment[i] = increment[i] + val;
        }
    }



}
