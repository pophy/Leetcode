package dailyQuest;

import org.junit.jupiter.api.Test;


import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<String> stringStack = new Stack();
        Stack<Integer> counterStack = new Stack();
        stringStack.push("");
        //starting index
        int i = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            //match number
            if (c >= '0' && c <= '9') {
                int j = i + 1;
                while (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                counterStack.push(Integer.parseInt(s.substring(i, j)));
                i = j;
            } else {
                //match string
                if (c == '[') {
                    stringStack.push("");
                } else if (c == ']') {
                    int counter = counterStack.pop();
                    StringBuilder sb = new StringBuilder();
                    String subString = stringStack.pop();
                    for (int k = 0; k < counter; k++) {
                        sb.append(subString);
                    }
                    stringStack.push(stringStack.pop() + sb);
                } else {
                    stringStack.push(stringStack.pop() + c);
                }
                i++;
            }
        }
        return stringStack.pop();
    }


    @Test
    public void test() {
        String str = "3[a12[bc]]";
        System.out.println(decodeString(str));
    }

}
