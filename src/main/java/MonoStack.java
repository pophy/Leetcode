import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MonoStack {

    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int popIndex = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0] = leftLessIndex;
                res[popIndex][1] = i;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }

    public static int[][] getNearLess(int[] m) {
        int[][] res = new int[m.length][2];
        Stack<LinkedList<Integer>> stack = new Stack<>();
        for (int i = 0; i < m.length; i++) {
            while (!stack.isEmpty() && m[stack.peek().getLast()] > m[i]) {
                List<Integer> popIndexList = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek().getLast();
                for (int index:popIndexList) {
                    res[index][0] = leftIndex;
                    res[index][1] = i;
                }
            }
            if (!stack.isEmpty() && m[stack.peek().getLast()] == m[i]) {
                stack.peek().addLast(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                stack.push(list);
            }

        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop().getLast();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek().getLast();
            res[popIndex][0] = leftIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }


    public int maxAreaMin(int[] arr) {
        int size = arr.length;
        int[] sums = new int[size];
        sums[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < size; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int j = stack.pop();
                max = Math.max(max, (stack.isEmpty() ? sums[i - 1] : (sums[i - 1] - sums[stack.peek()])) * arr[j]);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, (stack.isEmpty() ? sums[size - 1] : (sums[size - 1] - sums[stack.peek()])) * arr[j]);
        }
        return max;
    }


    @Test
    public void test() {
        int[] m = {2,8,7,4,1,5,3};
        int[] n = {2,8,7,4,1,5,3};
        Arrays.stream(getNearLess(m)).forEach(i->{
            System.out.print(i[0] + "," + i[1] + " ");
        });
        System.out.println("=====================");
        Arrays.stream(getNearLessNoRepeat(m)).forEach(i->{
            System.out.print(i[0] + "," + i[1] + " ");
        });
    }

}
