/**
 * Created by Fei on 2/12/2018.
 */
public class TrappingWater {
    public int trapRainWater(int[] A) {
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TrappingWater trappingWater = new TrappingWater();
        int[] ds = {0,1,0,2,1,0,1,3,2,1,2,1};
        trappingWater.trapRainWater(ds);
    }
}
