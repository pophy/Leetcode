package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色
 * <p>
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int i = 0;
        int left = 0;
        int right = nums.length -1;
        while (i <= right) {
            if (nums[i] == 2) {
                swap(nums,i,right--);
            } else if (nums[i] == 0) {
                swap(nums,i++,left++);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] m, int i, int j) {
        int temp = m[i];
        m[i] = m[j];
        m[j] = temp;
    }

    @Test
    public void test() {
        int[] m = {2,0,2,1,1,0};
        sortColors(m);
        Arrays.stream(m).forEach(n -> {
            System.out.print(n + " ");
        });
    }

}
