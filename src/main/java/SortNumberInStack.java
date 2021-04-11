import org.testng.annotations.Test;

import java.util.Stack;

public class SortNumberInStack {
    /**
     * 请编写一个程序，对一个栈里的整型数据，按升序进行排序
     * （即排序前，栈里 的数据是无序的，排序后最大元素位于栈顶），
     * 要求最多只能使用一个额外的 栈存放临时数据，但不得将元素复制到别的数据结构中。
     */

    public void solution(Stack<Integer> stack) {
        Stack<Integer> cache = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!cache.isEmpty() && cache.peek() < current) {
                stack.push(cache.pop());
            }
            cache.push(current);
        }
        while (!cache.isEmpty()) {
            stack.push(cache.pop());
        }
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        solution(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
