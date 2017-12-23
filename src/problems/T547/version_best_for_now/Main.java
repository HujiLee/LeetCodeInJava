package problems.T547.version_best_for_now;
class Solution {
    void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (visited[j] == 0 && M[i][j] == 1) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res ++;
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
   {
            int answer = new Solution().findCircleNum(new int[][]{
                    new int[]{1, 1, 0},
                    new int[]{1, 1, 0},
                    new int[]{0, 0, 1}
            });
            System.out.println(answer);//should be 2
        }
        {
            int[][] ints = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    ints[i][j] = 1;
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 1
        }
        {
            int[][] ints = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (j % 2 == i % 2) {
                        ints[i][j] = 1;
                    } else {
                        ints[i][j] = 0;
                    }
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 2
        }
    }
}
