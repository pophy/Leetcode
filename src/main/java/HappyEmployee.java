import org.testng.annotations.Test;

import java.util.List;

public class HappyEmployee {

    public int maxHappiness(Employee boss) {
        Info info = process(boss);
        return Math.max(info.attend, info.noAttend);
    }

    public Info process(Employee root) {
        if (root.subordinates.isEmpty()) {
            return new Info(root.happy, 0);
        }
        int attend = root.happy;
        int noAttend = 0;
        for (Employee employee : root.subordinates) {
            Info info = process(employee);
            attend += info.noAttend;
            noAttend += Math.max(info.attend, info.noAttend);
        }
        return new Info(attend, noAttend);
    }

    public static class Info {
        int attend;
        int noAttend;

        public Info(int attend, int noAttend) {
            this.attend = attend;
            this.noAttend = noAttend;
        }
    }

    public static class Employee {
        public int happy; // 这名员工可以带来的快乐值
        List<Employee> subordinates;
    }

    @Test
    public void test() {

    }

}
