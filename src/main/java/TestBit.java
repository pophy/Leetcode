import org.testng.annotations.Test;

import java.util.Arrays;

public class TestBit {

    public int getNumberAppearOnce(int[] nums) {
        return Arrays.stream(nums).reduce((a,b) -> a^b).getAsInt();
    }

    public int[] getNumberAppearOnceWithTwoNumbers(int[] nums) {//return int[] -> {a,b}
        int eor = getNumberAppearOnce(nums); // a^b
        int rightOne = eor & (~eor + 1);

        int numA = Arrays.stream(nums).filter(a -> (a & eor) == 0).reduce((a,b) -> a^b).getAsInt();
        int numB = eor ^ numA;
        return new int[]{numA,numB};
    }

    @Test
    public void test1() {
        int[] nums = {1,2,3,3,2,1,5};
        System.out.println(getNumberAppearOnce(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1,2,3,3,2,1,5,7};
        int[] res = getNumberAppearOnceWithTwoNumbers(nums);
        System.out.println(res[0] + " " + res[1]);
    }

}
