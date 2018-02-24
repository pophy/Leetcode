
        public class BinarySearch {

            public static int binarySearch (int[] dataSource, int target) {
        if (dataSource == null && dataSource.length <0) {
            return -1;
        }
        int start = 0;
        int end = dataSource.length - 1;                //1,2,3,5,7
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (dataSource[mid] == target) {
                start = mid;
            } else if (dataSource[mid] < target) {
                start = mid;
            } else if (dataSource[mid] > target) {
                end = mid;
            }

        }
        if (dataSource[end] == target) {
            return end;
        }
        if (dataSource[start] == target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSource = {1,2,5,5,8,9};
        int result = binarySearch(dataSource,5);
        System.out.print(result);

    }

}


