import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ChooseJob {

    /**
     * sort job by difficulty asc and then money desc
     * only keep job that
     *
     */
    public static int[] getMoneys(Job[] job, int[] ability) {
        int[] res = new int[ability.length];
        Arrays.sort(job,(a,b) ->{
            return a.hard != b.hard? a.hard - b.hard : b.money - a.money;
        });
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        Job pre = job[0];
        treeMap.put(pre.hard,pre.money);
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                treeMap.put(pre.hard,pre.money);
            }
        }
        for (int i = 0; i < ability.length; i++) {
            Map.Entry<Integer,Integer> entry = treeMap.floorEntry(ability[i]);
            if (entry != null) {
                res[i] = entry.getValue();
            } else {
                res[i] = 0;
            }
        }

        return res;
    }


    public static int[] getMoneys1(Job[] job, int[] ability) {
        Arrays.sort(job,(o1,o2)-> {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;
    }

    public static class Job {
        public int money;
        public int hard;

        public Job(int money, int hard) {
            this.money = money;
            this.hard = hard;
        }
    }

    @Test
    public void test(){
        Job job1 = new Job(5,3);
        Job job2 = new Job(7,5);
        Job job3 = new Job(2,1);
        Job job4 = new Job(7,3);
        Job job5 = new Job(4,2);
        Job job6 = new Job(6,2);
        Job[] jobs = {job1,job2,job3,job4,job5,job6};
        int[] ability = {2,4,3,1,5,3};
        Arrays.stream(getMoneys(jobs, ability)).forEach(job->{
            System.out.print(job + " ");
        });
        System.out.println("");
        Arrays.stream(getMoneys1(jobs, ability)).forEach(job->{
            System.out.print(job + " ");
        });
    }
/**
 * 3,5 | 5,7 | 1,2 | 3,7 | 2,4 | 2,8
 *
 * 1,2 * 2,6 * 3,7
 *
 */

}
