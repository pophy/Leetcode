package Greedy;

import java.util.Arrays;

public class BoatsSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0, l = 0, r = people.length-1;
        while (l <= r) {
            if (people[r] + people[l] > limit) {
                count++;
                r--;
            } else {
                l++;
                r--;
                count++;
            }
        }
        return count;
    }
}
