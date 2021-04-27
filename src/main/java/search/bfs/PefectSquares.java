package search.bfs;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PefectSquares {

    public int solution(int n) {
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
      //  int[] visited = new int[n+1];
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j <= cur; j++) {
                    int next = cur - j*j;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return steps;
                    }
                    queue.add(next);
//                    if (visited[next] != 1) {
//                        queue.add(next);
//                        visited[next] = 1;
//                    }
                }
            }
        }
        return steps;
    }

    @Test
    public void test() {
        System.out.println(solution(775));
    }


}
