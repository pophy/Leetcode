package misc;

import org.junit.jupiter.api.Test;

public class NumberOfGameRounds {
    public int numberOfRounds(String startTime, String finishTime) {
        int startMinutes = getMinutes(startTime);
        int endMinutes = getMinutes(finishTime);
        return calculateRounds(startMinutes, endMinutes);
    }

    private int getMinutes(String time) {
        String[] array = time.split(":");
        int[] t = new int[2];
        t[0] = Integer.parseInt(array[0]);
        t[1] = Integer.parseInt(array[1]);
        return t[0] * 60 + t[1];
    }

    private int calculateRounds(int start, int end) {
        if (end < start) {
            end += 24 * 60;
        }
        int res = (int) Math.floor(end / 15D) - (int) Math.ceil(start / 15D);
        return res < 0 ? 0 : res;
    }


    @Test
    public void test() {
        System.out.println(numberOfRounds("00:47", "00:57"));
    }
}
