package hashMapRelated;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDomain {

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null) {
            return null;
        }
        Map<String, Integer> countMap = new HashMap();
        for (String domainPair : cpdomains) {
            String[] pair = domainPair.split(" ");
            int count = Integer.parseInt(pair[0]);
            String fullDomain = pair[1];
            String[] domainArray = fullDomain.split("\\.");
            for (int i=0; i<domainArray.length; i++) {
                String key = "";
                for (int j = i; j<domainArray.length; j++) {
                    key += domainArray[j];
                    key += ".";
                }
                key = key.substring(0, key.length() - 1);
                countMap.put(key, countMap.getOrDefault(key,0) + count);
            }
        }
        List<String> result = new ArrayList();
        for (String key : countMap.keySet()) {
            int count = countMap.get(key);
            result.add(count + " " + key);
        }
        return result;
    }


    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return true;
        }
        Map<Character, Integer> countMap = new HashMap();
        for (int i=0; i<s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i),0) + 1);
        }
        boolean flag = false;
        for (Character c : countMap.keySet()) {
            if (countMap.get(c) % 2 == 0) {
                continue;
            }
            if (countMap.get(c) % 2 != 0 && !flag) {
                flag = true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        String[] data = {"9001 discuss.leetcode.com"};
        //System.out.println(subdomainVisits(data));
        System.out.println(canPermutePalindrome("aab"));
    }

}
