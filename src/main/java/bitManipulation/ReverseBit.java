package bitManipulation;

import org.junit.jupiter.api.Test;

public class ReverseBit {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i <= 31; i++) {
            if (((n >> i) & 1) == 1) {
                ans = ((1 << (31 - i)) | ans);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(reverseBits(5));
        StringBuilder sb = new StringBuilder();

    }
}
