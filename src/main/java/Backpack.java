import org.testng.annotations.Test;


public class Backpack {

    public int getMaxProfit(int bagSize, int[] weights, int[] values) {
        return process(bagSize, weights, values, 0);
    }

    private int process(int remainingSize, int[] weights, int[] values, int index) {
        if (index == values.length) {
            return 0;
        }
        if (remainingSize < weights[index]) {
            return 0;
        }
        int take = process(remainingSize - weights[index], weights, values, index + 1) + values[index];
        int noTake = process(remainingSize, weights, values, index + 1);
        return Math.max(take, noTake);
    }

    /**
     * 牛牛准备参加学校组织的春游,
     * 出发前牛牛准备往背包里装入一些零食,
     * 牛牛的背包容 量为w。 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
     * 牛牛想知道在总体积不超过背包容量的情况下，他一共有多少种零食放法(总体积为0也 算一种放法)。
     */
    public int solution(int[] v, int W) {
        int[][] cache = new int[W + 1][v.length + 1];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = -1;
            }
        }
        subsetSum(v, 0, W, cache);
        int res = 0;
        for (int i = 0; i <= W; i++) {
            res += subsetSum(v, 0, i, cache);
        }
        return res;
    }

    static int subsetSum(int arr[], int i, int sum, int[][] cache) {
        if (sum < 0) {
            return 0;
        }
        if (i == arr.length) {
            if (sum == 0) {
                cache[sum][i] = 1;
                return 1;
            }
            cache[sum][i] = 0;
            return 0;
        }
        if (cache[sum][i] != -1) {
            return cache[sum][i];
        }
        int count = subsetSum(arr, i + 1, sum - arr[i], cache);
        count += subsetSum(arr, i + 1, sum, cache);
        cache[sum][i] = count;
        return count;
    }

    //==================

    public static int bagPutSnakes(int w, int[] v) {
        if(w<0||v.length==0||v==null){ //过滤掉数组为空或者长度为零，背包容量为负数的情况
            return 0;
        }
        int[][] dp = new int[v.length][w+1];
        //dp[i][j]表示的是从i前面个零食中选背包容量为j一共有多少种装零食的方法
        //容量为0的时候方法数为1
        for (int i = 0; i < v.length; i++) {
            dp[i][0] = 1;
        }
        //只能选v[0]这一种零食的时候.判断容量是否够放这种零食如果够的话方法数为2不够的话为1
        for (int j = 0; j <= w; j++) {
            dp[0][j] = v[0] <= j ? 2 : 1;
        }
        //到达dp[i][j]时有两种选择方法
/*       1.不选择i这个零食,那么就直接应用dp[i-1][j]的结果
         2.选择i这个零食(前提是j容量的背包能放下这个零食)，
  那么就是求选择了i零食后剩余的容量j-v[i]有多少种放零食的方法(参考前面已经完成的j-v[i]容量放零食的过程)
*/
        for(int i=1;i<v.length;i++){
            for (int j = 0; j <=w ; j++) {
                if(v[i]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-v[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[v.length-1][w];
    }


    @Test
    public void test() {
        int[] weight = {2, 3, 5};
        int[] values = {10, 2, 5};
        System.out.println(getMaxProfit(5, weight, values));
    }

    @Test
    public void test2() {
        int[] m = {1, 3, 4, 5, 2};
        System.out.println(solution(m, 7));
        System.out.println(bagPutSnakes(7,m));
    }

}
