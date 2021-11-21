package search.misc;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (countBits(h) + countBits(m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }

    private int countBits(int num) {
        return Integer.bitCount(num);
    }


}
