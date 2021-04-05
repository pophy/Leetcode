import java.util.Stack;

/**
 * Created by Fei on 2/10/2018.
 */
public class DeleteDigits {
    public String DeleteDigits(String A, int k) {
        // write your code here
        String res = "";
        if(A == null || A.length() == 0){
            return res;
        }
        //为了使得剩下的数最小，要尽可能地把高位的大的数删掉
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for(int i = 0; i < A.length(); i++){
            char curt = A.charAt(i);
            while(!stack.isEmpty() && stack.peek() > curt && count < k){
                stack.pop();
                count++;
            }
            stack.push(curt);
        }

        Stack<Character> temp = new Stack<Character>();
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        while(!temp.isEmpty()){
            res = res + temp.pop();
        }

        //count < k case
        if(count < k){
            int num = k - count;
            res = res.substring(0, res.length() - num);
        }

        //front 0 case
        int i = 0;
        while(i < res.length() && res.charAt(i) == '0'){
            i++;
        }
        if(i == res.length()){
            res = "0";
        }else{
            res = res.substring(i);
        }

        return res;
    }

    public static void main(String[] args) {
        DeleteDigits deleteDigits = new DeleteDigits();
        String ds = "4321";
        deleteDigits.DeleteDigits(ds,2);
    }
}
