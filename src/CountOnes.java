import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Fei on 2/12/2018.
 */
public class CountOnes {

    public int countOnes(int num) {
        // write your code here
        int a;
        int count = 0;
        for(int i = 0; i < 32; i++){
            a = 1 << i;
            if((num & a) != 0){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountOnes countOnes = new CountOnes();
        countOnes.countOnes(13);
        Arrays.sort(args, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}



