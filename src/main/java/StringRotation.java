import org.testng.annotations.Test;

public class StringRotation {

    public boolean isStringRotation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        str1 += str1;
        if (str1.contains(str2)) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
       String a="cdab", b="abcd", aa="1ab2",bb="ab12",aaa="2ab1",bbb="ab12";
        System.out.println(isStringRotation(a,b));
        System.out.println(isStringRotation(aa,bb));
        System.out.println(isStringRotation(aaa,bbb));
    }

}
