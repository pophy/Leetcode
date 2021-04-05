import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fei on 2/12/2018.
 */
public class NumbersbyRecursion {

    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(n < 1){
            return res;
        }

        helper(n, 0, res);
        return res;
    }

    //ans在这里可以看成前一位的值，在递归过程中会乘以n－1次10，即10^(n-1)
    private void helper(int n, int ans, List<Integer> res){
        if(n==0){
            if(ans>0){
                res.add(ans);
            }
            return;
        }

        int i;
        for(i=0; i<=9; i++){
            helper(n-1, ans*10+i, res);
        }
    }

    public static void main(String[] args) {
        NumbersbyRecursion numbersbyRecursion = new NumbersbyRecursion();
        numbersbyRecursion.numbersByRecursion(3);
    }
}
