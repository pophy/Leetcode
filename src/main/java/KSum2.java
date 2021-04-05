import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei on 2/5/2018.
 */
public class KSum2 {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        result.clear();
        Arrays.sort(A);
        ArrayList<Integer> list = new ArrayList<Integer>();
        robot(A,0,k,target,list);
        return result;
    }

    private void robot(int[] nums, int index, int k, int target, List<Integer> path) {
        if (path.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(path));
            }
            return ;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            robot(nums, i + 1, k, target - nums[i], path);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        KSum2 kSum2 = new KSum2();
        int[] ds = {1,2,3,4};
        kSum2.kSumII(ds,2,5);
        System.out.println();
    }
}
