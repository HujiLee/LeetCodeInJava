package problems.T743.v1_WA;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
class Solution {
    /**
     * 这个问题应该就是单源最短路径的一种形式
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] path_shortest_length = new int[N + 1];
        for (int i = 0; i < path_shortest_length.length; i++) {
            if (i != K) {
                path_shortest_length[i] = Integer.MAX_VALUE;
            }
        }
        int[][] graph = new int[N + 1][N + 1];
        for (int[] row : graph) {
            for (int i = 0; i < row.length; i++) {
                row[i] = Integer.MAX_VALUE;
            }
        }
        for (int[] record : times) {
            graph[record[0]][record[1]] = record[2];
        }
        path_shortest_length[K] = 0;
        HashSet<Integer> calced_set = new HashSet<Integer>() {{
            this.add(K);
        }};
        HashSet<Integer> could_reach_set = new HashSet<Integer>();
        for (int i = 1; i <= N; i++) {
            if (graph[K][i] != Integer.MAX_VALUE) {
                could_reach_set.add(i);
                path_shortest_length[i] = graph[K][i];
            }
        }
        while (could_reach_set.size()>0) {
            Iterator<Integer> it = could_reach_set.iterator();
            int next = it.next();
            could_reach_set.remove(next);
            calced_set.add(next);
            for (int i = 1; i <= N; i++) {
                if (graph[next][i] != Integer.MAX_VALUE) {
                    if (!calced_set.contains(i)) {
                        could_reach_set.add(i);
                    }
                    int temp = graph[next][i] + path_shortest_length[next];
                    if (temp < path_shortest_length[i]) {
                        path_shortest_length[i] = temp;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(path_shortest_length[i]>max) {
                max = path_shortest_length[i];
            }
        }

        if(max==Integer.MAX_VALUE){
            return -1;
        }else {
            return max;
        }

    }
}

/**
 * @anchor https://leetcode.com/problems/network-delay-time/
 */
public class Main {
    public static void main(String[] args) {
        {
            int answer =  new Solution().networkDelayTime(new int[][]{
                            new int[]{1,2,1},

                    }
                    , 2,
                    2);
        }
        {
            int answer =  new Solution().networkDelayTime(new int[][]{
                            new int[]{2,1,1},
                            new int[]{2,3,1},
                            new int[]{3,4,1}
                    }
                    , 4,
                    2);
        }
        {
            int answer =  new Solution().networkDelayTime(new int[][]{
                            new int[]{1, 2, 1},
                            new int[]{1, 3, 1},
                            new int[]{2, 4, 2},
                            new int[]{4, 1, 2},
                            new int[]{4, 3, 4},
                            new int[]{3, 1, 1},
                            new int[]{5, 4, 3}
                    }
                    , 5,
                    5);//6
        }

        {
            int answer =  new Solution().networkDelayTime(new int[][]{
                            new int[]{1, 2, 1},
                            new int[]{1, 3, 1},
                            new int[]{2, 4, 2},
                            new int[]{4, 1, 2},
                            new int[]{4, 3, 4},
                            new int[]{3, 1, 1},
                            new int[]{5, 4, 3}
                    }
                    , 5,
                    2);//-1
        }


    }
}
