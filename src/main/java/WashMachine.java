import org.testng.annotations.Test;

import java.util.Arrays;

public class WashMachine {

    /**
     * 有n个打包机器从左到右一字排开，上方有一个自动装置会抓取一批放物品到每个打 包机上，
     * 放到每个机器上的这些物品数量有多有少，由于物品数量不相同，
     * 需要工人 将每个机器上的物品进行移动从而到达物品数量相等才能打包。每个物品重量太大、
     * 每次只能搬一个物品进行移动，为了省力，只在相邻的机器上移动。请计算在搬动最 小轮数的前提下，
     * 使每个机器上的物品数量相等。如果不能使每个机器上的物品相同， 返回-1。
     * 例如[1,0,5]表示有3个机器，每个机器上分别有1、0、5个物品，经过这些轮后：
     * 第一轮：1 0 <- 5 => 1 1 4
     * 第二轮：1 <-1<- 4 => 2 1 3
     * 第三轮： 2 1 <- 3 => 2 2 2 移动了3轮，每个机器上的物品相等，所以返回3
     * <p>
     * 例如[2,2,3]表示有3个机器，每个机器上分别有2、2、3个物品， 这些物品不管怎么移动，都不能使三个机器上物品数量相等，返回-1
     */

    public int solution(int[] m) {
        int sum = Arrays.stream(m).sum();
        int size = m.length;
        if (sum % size != 0) return -1;
        int avg = sum / size;
        int[] A = new int[m.length];
        int[] B = new int[m.length];
        int preSum = 0;
        for (int i = 0; i < m.length; i++) {
            preSum += m[i];
            A[i] = preSum;
        }
        int res = -1;
        for (int i = 0; i < m.length; i++) {
            int leftNeed = i == 0 ? 0 : avg * i - (A[i] - m[i]);
            int rightNeed = i == size - 1 ? 0 : avg * (size - i - 1) - (sum - A[i]);
            if ((leftNeed < 0 && rightNeed < 0) || (leftNeed > 0 && rightNeed > 0)) {
                B[i] = Math.abs(leftNeed) + Math.abs(rightNeed);
            } else {
                B[i] = Math.max(Math.abs(leftNeed),Math.abs(rightNeed));
            }
            res = Math.max(B[i],res);
        }
        return res;
    }

    @Test
    public void test(){
        int[] m = {8,1,5,6};
        System.out.println(solution(m));
    }

}
