import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

public class MagicOp {
    /**
     * 给一个包含n个整数元素的集合a，一个包含m个整数元素的集合b。
     * 定义magic操作为，从一个集合中取出一个元素，放到另一个集合里，
     * 且操作过 后每个集合的平均值都大大于于操作前。
     * 注意以下两点：
     * 1）不可以把一个集合的元素取空，这样就没有平均值了
     * 2）值为x的元素从集合b取出放入集合a，但集合a中已经有值为x的元素，则a的 平均值不变（因为集合元素不会重复），
     * b的平均值可能会改变（因为x被取出 了）
     * 问最多可以进行多少次magic操作？
     */

    public int solution(int[] m, int[] n) {
        int sumM = Arrays.stream(m).sum();
        int sumN = Arrays.stream(n).sum();
        double avgM = sumM / m.length;
        double avgN = sumN / n.length;
        int[] large = m;
        int[] small = n;
        double sumLarge = sumM;
        double sumSmall = sumN;
        if (avgM < avgN) {
            large = n;
            small = m;
            sumLarge = sumN;
            sumSmall = sumM;
        }

        Arrays.sort(small);
        Arrays.sort(large);
        int largeSize = large.length;
        int smallSize = small.length;
        int res = 0;
        for (int i = 0; i < large.length; i++) {
            if (large[i] < sumLarge / largeSize && large[i] > sumSmall / smallSize) {
                res++;
                sumLarge -= large[i];
                largeSize--;
                sumSmall += large[i];
                smallSize++;
            }
        }
        return res;
    }

    public static int maxOps(int[] arr1, int[] arr2) {
        double sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum1 += (double) arr1[i];
        }
        double sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            sum2 += (double) arr2[i];
        }
        if (avg(sum1, arr1.length) == avg(sum2, arr2.length)) {
            return 0;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            sumMore = sum1;
            arrLess = arr2;
            sumLess = sum2;
        } else {
            arrMore = arr2;
            sumMore = sum2;
            arrLess = arr1;
            sumLess = sum1;
        }
        Arrays.sort(arrMore);
        HashSet<Integer> setLess = new HashSet<>();
        for (int num : arrLess) {
            setLess.add(num);
        }
        int moreSize = arrMore.length;
        int lessSize = arrLess.length;
        int ops = 0;
        for (int i = 0; i < arrMore.length; i++) {
            double cur = (double) arrMore[i];
            if (cur < avg(sumMore, moreSize) && cur > avg(sumLess, lessSize)
                    && !setLess.contains(arrMore[i])) {
                sumMore -= cur;
                moreSize--;
                sumLess += cur;
                lessSize++;
                setLess.add(arrMore[i]);
                ops++;
            }
        }
        return ops;
    }

    public static double avg(double sum, int size) {
        return sum / (double) (size);
    }

    @Test
    public void test() {
        int[] arr1 = { 1, 2, 5 };
        int[] arr2 = { 2, 3, 4, 5, 6 };
        System.out.println(solution(arr1,arr2));
        System.out.println(maxOps(arr1,arr2));
    }

}
