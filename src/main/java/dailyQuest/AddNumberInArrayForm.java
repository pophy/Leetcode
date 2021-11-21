package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 * <p>
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 * <p>
 * 2147283647
 */


public class AddNumberInArrayForm {


    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int borrow = 0;
        int i = num.length - 1;

        while (k != 0 || i >= 0 || borrow != 0) {
            int currentNumber;
           if (i >= 0 && k != 0) {
                currentNumber = num[i] + k % 10;
           } else if (i >=0) {
               currentNumber = num[i];
           } else {
               currentNumber = k % 10;
           }
            stack.add((currentNumber + borrow) % 10);
            borrow = (currentNumber + borrow) / 10;
            k = k / 10;
            i--;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    @Test
    public void test() {
        int[] num = {9,9,9};
        addToArrayForm(num,1).stream().forEach(n -> {
            System.out.println(n);
        });
    }

}
