package problems.T743.v3;

import java.util.*;

/**
 * Created by Administrator on 2017/12/16 0016.
 */
class Solution {
    class IndexAndDist implements Comparable<IndexAndDist>{
        int index;
        int dist = Integer.MAX_VALUE;

        @Override
        public String toString() {
            return String.format("[%s:%s]",index,dist);
        }


        @Override
        public int compareTo(IndexAndDist o) {
            return this.dist-o.dist;
        }
    }
    /**
     * 这个问题应该就是单源最短路径的一种形式
     *
     * @param times
     * @param N
     * @param K
     * @return
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        IndexAndDist[] path_shortest_length = new IndexAndDist[N+1];
        for (int i = 1; i <= N; i++) {
            path_shortest_length[i] = new IndexAndDist();
            path_shortest_length[i].index = i;
            if(i==K){
                path_shortest_length[i].dist = 0;
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

        HashSet<Integer> calced_set = new HashSet<Integer>() {{
            this.add(K);
        }};
        PriorityQueue<IndexAndDist> could_reach_set = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (graph[K][i] != Integer.MAX_VALUE) {
                path_shortest_length[i].dist = graph[K][i];
                could_reach_set.add(path_shortest_length[i]);
            }
        }
        while (could_reach_set.size()>0) {
            IndexAndDist next_object = could_reach_set.poll();
            int next = next_object.index;
            for (int i = 1; i <= N; i++) {
                if (graph[next][i] != Integer.MAX_VALUE) {
                    int temp = graph[next][i] + path_shortest_length[next].dist;
                    if (temp < path_shortest_length[i].dist) {
                        path_shortest_length[i].dist = temp;
                        could_reach_set.add(path_shortest_length[i]);
                        /**
                         *  之前是重新建立了一个PriorityQueue,把could_reach_set里的元素一个个填进去,来达到重新排序的效果
                         *  其实只需要could_reach_set.add(path_shortest_length[i]),就能保证,队列的第一个元素是最小元素
                         *  这样可能造成最小元素在队列的后面重复出现,但不影响结果
                         *  毕竟我们只需要队列的第一个元素是最小元素就行了
                         */
                    }
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if(path_shortest_length[i].dist>max) {
                max = path_shortest_length[i].dist;
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
                    3);//59
        }
    }
}
