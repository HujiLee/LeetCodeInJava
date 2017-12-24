package problems.T685.v2_try_union_find;

class Solution {
    int[] parentsof = null;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        parentsof = new int[edges.length + 1];
        int[] A = null, B = null;
        for (int[] edge : edges) {
            int parent = edge[0], child = edge[1];
            int parentsof_child = parentsof[child];
            if (parentsof_child != 0) {
                A = new int[]{parentsof_child, child};
                B = edge;
            } else {
                int root_of_parent = findroot(parent);
                if (root_of_parent == child) {
                    if (A==null){
                        return edge;
                    }else{
                        return A;
                    }

                }
                parentsof[child] = parent;
            }
        }
        if (!validRootTree()) {
            return A;
        }
        return B;
    }

    boolean validRootTree() {
        int root = findroot(1);
        for (int i = 2; i < parentsof.length; i++) {
            int temp = findroot(i);
            if (temp == -1 || temp != root) {
                return false;
            }
        }
        return true;

    }

    int findroot(final int i) {
        int p = parentsof[i];
        int current_child = i;
        while (p != 0) {
            current_child = p;
            p = parentsof[current_child];
            if (p == i) {
                return -1;
            }
        }
        return current_child;
    }
}

public class Main {
    public static void main(String[] args) {
        {
            //!!!
            {
                int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                        new int[]{3,4},
                        new int[]{4, 1},
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{5, 1},
                });//[4,1]
                if (answer != null)
                    System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
                else System.out.println("null");
            }
        }
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{2, 1},
                    new int[]{3, 1},
                    new int[]{4, 2},
                    new int[]{1, 4}
            });//[2,1]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
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
