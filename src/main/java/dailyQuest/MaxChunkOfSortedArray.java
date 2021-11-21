package dailyQuest;

import org.junit.jupiter.api.Test;

import java.util.*;

public class MaxChunkOfSortedArray {

    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int[] original = Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        List<Integer> listOriginal = new ArrayList<>();
        List<Integer> listSorted = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            listSorted.add(arr[i]);
            listOriginal.add(original[i]);
            if (haveSameElement(listOriginal,listSorted)) {
                res++;
                listOriginal.clear();
                listSorted.clear();
            }
        }
        return res;
    }

    public int maxChunksToSorted2(int[] arr) {
        Deque<Integer> stack = new LinkedList();
        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty() || stack.peek() <= arr[i]) {
                stack.push(arr[i]);
            } else {
                //merge chunks, max will be the max nunber in new merged chunk
                int max = stack.peek();
                while (!stack.isEmpty() && stack.peek() > arr[i]) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();

    }


    private boolean haveSameElement(List<Integer> l1, List<Integer> l2) {
        Collections.sort(l1);
        Collections.sort(l2);
        return l1.equals(l2);
    }

    @Test
    public void test() {
        int[] arr = {2,3,1,4,5};
       // System.out.println(maxChunksToSorted(arr));
        System.out.println(maxChunksToSorted2(arr));
    }


}
