import java.util.Arrays;

public class NumUtil {

    public static int[] generateRandomNumbers(int maxSize, int maxValue) {
        int arraySize = (int)(Math.random() * maxSize);
        int[] randomArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = (int)(Math.random() * maxValue);
        }
        return randomArray;
    }
}
