/**
 * Created by fei on 2/10/18.
 */
public class RemoveElement {

    public int removeElement(int[] num, int n) {
        int i = 0;
        int pointer = num.length - 1;
        while(i <= pointer){
            if (num[pointer] == n) {
                pointer--;
                continue;
            }
            if(num[i] == n){
                num[i] = num[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

    public static void main(String[] args) {
        RemoveElement remove = new RemoveElement();
        int[] ds = {0,4,4,0,0,2,4,4};
        remove.removeElement(ds,4);
    }
}
