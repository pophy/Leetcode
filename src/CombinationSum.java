import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei on 2/5/2018.
 */
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        robot(nums,new ArrayList(), target,0);
        return result;
    }

    private void robot(int[] nums, List<Integer> path, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList(path));
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            robot(nums,path,target - nums[i], i);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] ds = {1,2,3,4,5};
        combinationSum.combinationSum(ds,6);
    }
}
