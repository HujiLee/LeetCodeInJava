package problems.T743.version_ashish53v;

import java.util.*;

/**
 * @author ashish53v@leetcode
 * @anchor https://discuss.leetcode.com/topic/113451/simple-java-solution-using-bfs-similar-to-dijkstra-s-shortest-path-algorithm-with-explanation
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int r = times.length, max = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < r; i++) {
            int[] nums = times[i];
            int u = nums[0];
            int v = nums[1];
            List<Integer> list = map.getOrDefault(u, new ArrayList<>());

            list.add(i);

            map.put(u, list);
        }
        if (map.get(K) == null) {
            return -1;// no immediate neighbor of node K, so return -1
        }
        int[] dist = new int[N + 1];//dist[i] is the time taken to reach node i from node k
        Arrays.fill(dist, max);

        dist[K] = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(K);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int t = dist[u];
            List<Integer> list = map.get(u);// get the indices of all the neighbors of node u
            if (list == null)
                continue;

            for (int n : list) {
                int v = times[n][1];
                int time = times[n][2];// time taken to reach from u to v
                if (dist[v] > t + time) {// if time taken to reach v from k is greater than time taken to reach from k to u + time taken to reach from u to v, then update dist[v]
                    dist[v] = t + time;
                    queue.add(v);// as we have found shorter distance to node v, explore all neighbors of v
                }
            }
        }

        int res = -1;

        for (int i = 1; i <= N; i++) {
            int d = dist[i];
            if (d == max) {// if d is max, it means node i can not be reached from K, so return -1
                return -1;
            }
            res = d > res ? d : res;
        }

        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        int answer = new Solution().networkDelayTime(new int[][]{
                        new int[]{4, 2, 76},
                        new int[]{1, 3, 79},
                        new int[]{3, 1, 81},
                        new int[]{4, 3, 30},
                        new int[]{2, 1, 47},
                        new int[]{1, 5, 61},
                        new int[]{1, 4, 99},
                        new int[]{3, 4, 68},
                        new int[]{3, 5, 46},
                        new int[]{4, 1, 6},
                        new int[]{5, 4, 7},
                        new int[]{5, 3, 44},
                        new int[]{4, 5, 19},
                        new int[]{2, 3, 13},
                        new int[]{3, 2, 18},
                        new int[]{1, 2, 0},
                        new int[]{5, 1, 25},
                        new int[]{2, 5, 58},
                        new int[]{2, 4, 77},
                        new int[]{5, 2, 74},
                }
                , 5,
                3);

    }
}
