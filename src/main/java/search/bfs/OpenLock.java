package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.*;

public class OpenLock {

    private static int[] direcations = {1, -1};

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet(Arrays.asList(deadends));
        if (set.contains("0000")) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add("0000");
        endSet.add(target);
        int step = 0;
        while (!startSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextSet = new HashSet<>();
            for (String current : startSet) {
                if (endSet.contains(current)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    for (int direction : direcations) {
                        StringBuilder sb = new StringBuilder(current);
                        char nextChar = (char) (current.charAt(j) + direction);
                        if (nextChar == ':') {
                            nextChar = '0';
                        }
                        if (nextChar == '/') {
                            nextChar = '9';
                        }
                        sb.setCharAt(j, nextChar);
                        String nextWord = sb.toString();
                        if (!set.contains(nextWord) && !visited.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                return step + 1;
                            }
                            nextSet.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }

            if (nextSet.size() < endSet.size()) {
                startSet = endSet;
                endSet = nextSet;
            } else {
                startSet = nextSet;
            }
            step++;
        }
        return -1;
    }

    /**
     * ["8887","8889","8878","8898","8788","8988","7888","9888"]
     * "8888"
     *
     * ["0201","0101","0102","1212","2002"]
     * "0000"
     */

    @Test
    public void test() {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadends,"0202"));
    }

}
