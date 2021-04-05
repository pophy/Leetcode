import java.util.Stack;

/**
 * Created by Fei on 1/16/2018.
 */
public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int third = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            else while (!s.empty() && nums[i] > s.peek()) {
                third = s.peek();
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern132 pattern132 = new Pattern132();
        int[] nums = {1,4,3,2,0};
        pattern132.find132pattern(nums);
    }

}


