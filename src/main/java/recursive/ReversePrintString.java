package recursive;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ReversePrintString {

    public void print(String str) {
        System.out.println(help(str, 0));
    }

    private String help(String str, int index) {
        if (index == str.length()) {
            return "";
        }
        return help(str, index + 1) + str.charAt(index);
    }

    @Test
    public void test() {
        print("abcd");
    }
}


