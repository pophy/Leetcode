package TwoPoints;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

//k = 2
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));


    }

}
