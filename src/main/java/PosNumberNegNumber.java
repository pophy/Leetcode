import java.util.Arrays;

/**
 * Created by Fei on 2/7/2018.
 */
public class PosNumberNegNumber {

    public void rerange(int[] num) {
        if (num == null || num.length <= 2) {
            return;
        }

        Arrays.sort(num);
        int countPos = 0;
        int countNeg = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= 0) {
                countPos++;
            } else {
                countNeg++;
            }
        }

        int left = 1;int right = num.length - 1;
        if (countPos > countNeg) {
            left = 0; right = num.length - 2;
        }
        if (countPos == countNeg) {
            left = 0; right = num.length - 1;
        }
        while (left < right) {
            swap(num,left,right);
            left += 2;
            right -= 2;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        PosNumberNegNumber number = new PosNumberNegNumber();
        int[] ds = {-33,-19,30,26,21,-9};
        number.rerange(ds);
    }
}
