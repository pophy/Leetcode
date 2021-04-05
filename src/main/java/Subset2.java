import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Fei on 1/31/2018.
 */
public class Subset2 {

    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        Arrays.sort(nums);
        helper(nums,new ArrayList<Integer>(),0);
        return result;
    }

    private void helper(int[] nums, List<Integer> tempList, int index) {
        result.add(new ArrayList(tempList));
        for (int i=index;i<nums.length;i++) {
            //skip dup
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            tempList.add(i);
            helper(nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset2 subset2 = new Subset2();
        int[] ds = {1, 1};
        subset2.subsetsWithDup(ds);
    }

    private String printList(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (Integer i:list) {
            sb.append(i).append("-");
        }
        return sb.toString();
    }

}
