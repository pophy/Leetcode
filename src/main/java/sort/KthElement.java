package sort;

import org.junit.jupiter.api.Test;

public class KthElement {

    /**
     * Kth Largest Element in an Array (Medium)
     */
    public int kthElement(int[] m, int k) {  //return value of kth element
        if (m == null && m.length == 0) {
            return -1;
        }
        int start = 0;
        int end = m.length-1;
        int n = m.length - k;

        while (true) {
            int index = partition(m,start, end);
            if (index == n) {
                return m[index];
            }
            if (index > n) {
                end = index - 1;
            } else {
                start=  index + 1;
            }
        }
    }


    public int partition(int[] array, int left, int right) {
        int pivot = left;
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (array[l] > array[pivot] && array[r] < array[pivot]) {
                swap(array,l,r);
                l++;
                r--;
            }
            if (array[l] <= array[pivot]) {
                l++;
            }
            if (array[r] >= array[pivot]) {
                r--;
            }
        }
        swap(array,pivot,r);
        return r;
    }

    private void swap(int[] m, int i, int j) {
        int temp = m[i];
        m[i] = m[j];
        m[j] = temp;
    }

    @Test
    public void test() {
        int[] m = {3,1,2,7,5};
        System.out.println(kthElement(m,3));
        //test i++ vs ++i
        int i = 3;
        int a = i++;
        i = 3;
        int b = ++i;
        System.out.println("a = " + a);
        System.out.println("B = " + b);


    }

}
