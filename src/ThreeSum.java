import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            int low = i + 1; int high = nums.length - 1; int sum = 0 - nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);list.add(nums[low]);list.add(nums[high]);
                    result.add(list);
                    while (low < high && nums[low] == nums[low + 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] ds = {1,0,-1,-1,-1,-1,0,1,1,1};
        threeSum.threeSum(ds);
    }

}
