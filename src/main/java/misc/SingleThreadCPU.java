package misc;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SingleThreadCPU {

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> queue = new PriorityQueue<>((a, b) -> {
            if (a.processingTime == b.processingTime) {
                return a.id - b.id;
            }
            return a.processingTime - b.processingTime;
        });

        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        Collections.sort(taskList, (a, b) -> a.startTime == b.startTime ? a.processingTime - b.processingTime : a.startTime - b.startTime);
        taskList.stream().forEach(t -> System.out.println(t.id + " s: " + t.startTime + " p: " + t.processingTime));
        int currentTime = 0;
        List<Integer> processedTask = new ArrayList<>();
        for (int i = 0, index = 0; index < taskList.size();) {
            while (i < taskList.size() && taskList.get(i).startTime <= currentTime) {
                queue.add(taskList.get(i));
                i++;
            }
            if (queue.isEmpty()) {
                currentTime = taskList.get(i).startTime;
            } else {
                Task task = queue.poll();
                processedTask.add(task.id);
                currentTime += task.processingTime;
                index++;
            }
        }

        int[] res = new int[processedTask.size()];
        for (int i = 0; i < processedTask.size(); i++) {
            res[i] = processedTask.get(i);
        }
        return res;
    }

    public static class Task {
        public int id;
        public int startTime;
        public int processingTime;

        public Task(int id, int startTime, int processingTime) {
            this.id = id;
            this.startTime = startTime;
            this.processingTime = processingTime;
        }
    }

    @Test
    public void test() {
        int[][] tasks = {
                {1,2},
                {2,4},
                {3,2},
                {4,1}
        };
        Arrays.stream(getOrder(tasks)).forEach(p -> System.out.print(p + ", "));
    }

}
