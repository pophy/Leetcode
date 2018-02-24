import java.util.Stack;

/**
 * Created by Fei on 1/16/2018.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path.length() < 0) {
            return "";
        }
        Stack<String> stack = new Stack();
        String[] tmp = path.split("/");
        for (int i=0;i<tmp.length;i++) {
            String current = tmp[i];
            if (current.equals(".") || current.equals("")) {
                continue;
            } else if (current.equals("..") && stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(current);
            }
        }
        Stack<String> result = new Stack();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        while (!result.isEmpty()) {
            sb.append("/");
            sb.append(result.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.simplifyPath("/");
    }
}
