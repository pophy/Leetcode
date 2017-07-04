import java.util.*;


public class PalindromePartitioning {

    /**
     find the longest Palindrome substring, given a String s such as abbasdabba -> abba 
     */
    public static String findLongestPalindromeString1 (String s) {
        if (s == null) {
            return null;            
        }
        if (s.length() == 1) {
            return s;
        }
        //each palindrome string, its center will match pattern xyx or xx, scan the whole string, get all xyx and xx, then expand string until get the longest string
        List<Integer> odds = new ArrayList<Integer>();
        List<Integer> evens = new ArrayList<Integer>();
        char[] chars = s.toCharArray();
        for (int i=1;i<s.length();i++) {
            if (chars[i] == chars[i-1]) {
                evens.add(i);
            }
            if (i != chars.length-1) {
                if (chars[i-1] == chars[i+1]) {
                    odds.add(i);
                }
            }
        }
        String returnStr = "";

        for (Integer index:odds) {
            StringBuffer tempStr = new StringBuffer();
            tempStr.append(chars[index]);
            int i = 1;
            while (index + i < chars.length && index - i >= 0) {
                if (chars[index-i] == chars[index+i]) {
                    tempStr.insert(0,chars[index-i]);
                    tempStr.append(chars[index+i]);
                    i++;
                } else {
                    break;
                }
            }
            if (tempStr.length() > returnStr.length()) {
                returnStr = tempStr.toString();
            }
        }
        for (Integer index:evens) {
            StringBuffer tempStr = new StringBuffer();
            tempStr.append(chars[index-1]);
            tempStr.append(chars[index]);
            int i = 1;
            while (index + i < chars.length && index - i > 0) {
                if (chars[index-i-1] != chars[index+i]) {
                    break;
                } else {
                    tempStr.insert(0,chars[index-i-1]);
                    tempStr.append(chars[index+i]);

                    i++;
                }
            }
            if (tempStr.length() > returnStr.length()) {
                returnStr = tempStr.toString();
            }
        }
        return returnStr;
    }


     //Determine whether an integer is a palindrome. 
    public static boolean isPalindromeNumber (int number) {
        if (number < 0) {
            return false;       //todo
        }
        char[] numbers = String.valueOf(number).toCharArray();
        if (numbers.length == 1) {
            return true;
        }

        Map<String,String> test = new HashMap<String, String>(200,0.8f);

        for (int i=0;i<numbers.length;i++) {
            int j = numbers.length-i-1;
            if (i > j) {
                break;                
            }
            if (numbers[i] != numbers[j]) {
                return false;                
            }
            
        }
        return true;
    }
    
    //Do this without extra space.
    public static boolean isPalindromNumberNoExtraSpace (int number) {
        if (number < 0) {
            return false;            
        }
        int div = 1;
        while (number/div >= 10) {
            div = div*10;            
        }
        
        while (number != 0) {
            int leftNum = number/div;
            int rightNum = number%10;
            if (leftNum != rightNum) {
                 return false;
            }
            number = number%div/10;
            div /= 100;
        }
        return true;
    }
    
    

    public static void main (String[] args) {
       // System.out.println("--------" + PalindromePartitioning.findLongestPalindromeString1("mym"));
        System.out.println("--------" + PalindromePartitioning.isPalindromNumberNoExtraSpace(11111));
    }
}
