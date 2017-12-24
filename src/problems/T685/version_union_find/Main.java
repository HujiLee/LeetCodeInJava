package problems.T685.version_union_find;
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
public class Main {
   public static void main(String[] args) {
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{4, 2},
                    new int[]{1, 5},
                    new int[]{5, 2},
                    new int[]{5, 3},
                    new int[]{2, 4}

            });//[4,2]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 3},
                    new int[]{2, 3},

            });//[2,3]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{3, 4},
                    new int[]{4, 1},
                    new int[]{1, 5}

            });//[4,1]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }

    }
}
