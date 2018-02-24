
public class SearchRange {

    public int[] searchRange(int[] num, int target) {
        if (num.length <= 0 ) {
            return new int[]{-1,-1};
        }
        //find first element in array
        int start = 0;
        int end = num.length - 1;
        int mid;
        int firstIndex = -1;
        int lastIndex = -1;
        while (start + 1 < end) {
            mid = start + (end -start)/2;
            if (num[mid] == target) {
                end = mid;
            } else if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[end] == target) {
            firstIndex = end;
        }
        if (num[start] == target) {
            firstIndex = start;
        }
        //find last elemetn in array
        start = 0;
        end = num.length - 1;
        while (start + 1 < end) {
            mid = start + (end -start)/2;
            if (num[mid] == target) {
                start = mid;
            } else if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] == target) {
            lastIndex = start;
        }
        if (num[end] == target) {
            lastIndex = end;
        }
        return new int[]{firstIndex, lastIndex};
    }

    public static void main(String[] args) {
        int[] data = new int[]{5,5,5,5,5,5,5,5,5,5};
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(data,5);
    }
}
