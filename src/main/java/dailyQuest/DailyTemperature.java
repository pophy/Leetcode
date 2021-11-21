package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        int[] res = new int[temperatures.length];
        //monotone stack - 单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }

    @Test
    public void test() {
        int[] temp = {73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temp)).forEach(t -> {
            System.out.print(t + ", ");
        });
    }

}
