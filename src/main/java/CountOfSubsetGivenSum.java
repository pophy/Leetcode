import org.testng.annotations.Test;

public class CountOfSubsetGivenSum {

    static int subsetSum(int arr[], int n, int i, int sum) {
        if (i == n) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }
        int count = subsetSum(arr, n, i + 1, sum - arr[i]);
        count += subsetSum(arr, n, i + 1, sum);
        return count;
    }


    @Test
    private void test() {
        int[] m = {1, 3, 2, 5, 4, 9};
        System.out.print(subsetSum(m, m.length, 0, 9));
    }

}
