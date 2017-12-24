package problems.T684.v3_union_find;

class Solution {
    int[] set;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        set = new int[n + 1];
        for(int[] edge:edges){
            if(!union(edge[0],edge[1])){
                return edge;
            }
        }
        return null;
    }

    /**
     * @param x x>1
     * @return
     */
    int find(int x) {

        if (set[x] == 0) {
            return x;
        } else {
            return find(set[x]);
        }
    }

    boolean union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx == rooty) return false;
        else {
            set[rootx] = rooty;
            return true;
        }

    }
}

public class Main {
    public static void main(String[] args) {
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 3},
                    new int[]{3, 4},
                    new int[]{1, 5},
                    new int[]{3, 5},
                    new int[]{2, 3}
            });//[3,5]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{3, 4},
                    new int[]{1, 4},
                    new int[]{1, 5}
            });//[1,4]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 3},
                    new int[]{2, 3},

            });//[2,3]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
    }
}
