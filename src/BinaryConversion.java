/**
 * Created by Fei on 2/10/2018.
 */
public class BinaryConversion {

    private static String convertBinary(int sum) {
        StringBuffer binary = new StringBuffer();
        while (sum != 0 && sum != 1) {
            binary.insert(0, sum % 2);
            sum = sum / 2;
            if (sum == 0 || sum == 1) {
                binary.insert(0, sum % 2);
            }
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        BinaryConversion.convertBinary(13);
    }
}
