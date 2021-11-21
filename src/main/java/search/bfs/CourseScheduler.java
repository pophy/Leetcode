package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseScheduler {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }
        for (int[] course : prerequisites) {
            indegreeMap.put(course[0], indegreeMap.getOrDefault(course[0], 0) + 1);
            if (courseMap.get(course[1]) == null) {
                courseMap.put(course[1], new ArrayList<>());
            }
            courseMap.get(course[1]).add(course[0]);
        }
        for (Integer course : indegreeMap.keySet()) {
            if (indegreeMap.get(course) == 0) {
                queue.add(course);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            List<Integer> nextCourses = courseMap.get(currentCourse);
            visited.add(currentCourse);
            if (nextCourses != null) {
                for (Integer next : nextCourses) {
                    indegreeMap.put(next, indegreeMap.get(next) - 1);
                    if (indegreeMap.get(next) == 0 && !visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        return visited.size() == numCourses;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> visited = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }
        for (int[] course : prerequisites) {
            indegreeMap.put(course[0], indegreeMap.getOrDefault(course[0], 0) + 1);
            if (courseMap.get(course[1]) == null) {
                courseMap.put(course[1], new ArrayList<>());
            }
            courseMap.get(course[1]).add(course[0]);
        }
        for (Integer course : indegreeMap.keySet()) {
            if (indegreeMap.get(course) == 0) {
                queue.add(course);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            List<Integer> nextCourses = courseMap.get(currentCourse);
            visited.add(currentCourse);
            if (nextCourses != null) {
                for (Integer next : nextCourses) {
                    indegreeMap.put(next, indegreeMap.get(next) - 1);
                    if (indegreeMap.get(next) == 0 && !visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
        }
        if (visited.size() == numCourses) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = visited.get(i);
            }
            return res;

        }
        return new int[0];
    }


    @Test
    public void test() {
        int[][] pre = {
                {1, 0}
        };
        System.out.println(canFinish(2, pre));
    }
}
