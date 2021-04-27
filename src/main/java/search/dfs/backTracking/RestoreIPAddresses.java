package search.dfs.backTracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"].
 */
public class RestoreIPAddresses {

    List<String> addresses;

    public List<String> restoreIpAddresses(String s) {
        addresses = new ArrayList<>();
        if (s.length() < 0 && s.length() > 13) {
            return addresses;
        }

        dfs(s, 0, new StringBuilder());
        return addresses;
    }

    private void dfs(String s, int step, StringBuilder stringBuilder) {
        if (s.length() == 0 || step == 4) {
            if (s.length() == 0 && step == 4) {
                addresses.add(stringBuilder.toString());
                return;
            }
        }

        if (s.length() > (4 - step) * 3) {
            return;
        }

        for (int i = 0; i < 3 && i < s.length(); i++) {
            //2002552550  255.255.255.0
            String currentDigit = s.substring(0, i + 1);
            String restDigit = s.substring(i + 1);
            // currentDigit < 255 & not be like 00
            if (i != 0 && s.charAt(i) == '0') {
                break;
            }
            if (Integer.valueOf(currentDigit) > 255) {
                break;
            }
            if (stringBuilder.length() != 0) {
                currentDigit = "." + currentDigit;
            }
            stringBuilder.append(currentDigit);
            dfs(restDigit, step + 1, stringBuilder);
            //backtracking
            stringBuilder.delete(stringBuilder.length() - currentDigit.length(), stringBuilder.length());
        }

    }


    @Test
    public void test() {
        System.out.println(restoreIpAddresses("0000"));
    }
}
