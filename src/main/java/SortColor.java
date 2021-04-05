public class SortColor {


    public void sortColors(int[] A) {
        if(A==null || A.length<2) return;
        int low = 0;
        int high = A.length-1;
        for(int i = low; i<=high;) {
            if(A[i]==0) {
                swap(A,i++,low++);
            }else if(A[i]==2) {
                //swap A[i] and A[high] and high--;
                swap(A,i,high--);
            }else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public static void main(String[] args) {
        SortColor sortColor = new SortColor();
        int[] ds = {2,0,2,1,2,1,2,0,1};
        sortColor.sortColors(ds);
    }
}
