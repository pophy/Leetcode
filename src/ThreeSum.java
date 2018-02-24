import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> resultList = new ArrayList<>();
            int len = nums.length;
            for (int i = 0; i < len - 2; i++) {
                int j = i + 1;
                int k = len - 1;
                if (nums[i] >0 || nums[len-1] < 0) {
                    break;
                }
                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        List<Integer> result = new ArrayList<Integer>(3);
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        resultList.add(result);
                        while (j<k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j<k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;

                    }
                }
            }
            return resultList;
    }


    public int threeSumClosest(int[] nums,int target) {
        Stack<Integer> stack = new Stack<>();



        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        int res = Integer.MAX_VALUE;int close = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1;
            int k = len - 1;

            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            while (j < k) {
               int sum = nums[i] + nums[j] + nums[k];
                if (nums[i] + nums[j] + nums[k] > target) {
                    if (sum > target) {
                        close = Math.min(sum - target,close);
                        res = sum;
                    }
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    if (target > sum) {
                        close = Math.min(target - sum,close);
                        res = sum;
                    }
                    j++;
                } else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testInt = {0,0,0,0};
        System.out.println(new ThreeSum().threeSum(testInt));
    }

}