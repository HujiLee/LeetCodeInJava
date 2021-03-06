package problems.T547.v6_union_find;

class Solution {
    int[] array;

    public int findCircleNum(int[][] Matrix) {
        final int N = Matrix.length;
        array = new int[N];
        for(int i = 0;i<N;i++){
            array[i] = -1;
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y <= x; y++) {
                if (Matrix[x][y] == 1) {
                    union(x, y);
                }
            }
        }
        int count = 0;
        for (Integer ele : array) {
            if (ele <= -1) {
                count++;
            }
        }

        return count;
    }

    /**
     * @param a
     * @param b
     */
    void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota == rootb) return;
        if (array[roota]!=(array[rootb])) {
            if (array[roota] < array[rootb]) {
                //a tree is taller
                array[rootb] = roota;
            } else {
                array[roota] = rootb;
            }

        } else {
            array[rootb]--;
            array[roota] = rootb;
        }

    }

    /**
     * 不进行路径合并
     *
     * @param a
     * @return
     */
    int find(int a) {
        int child = a;
        int parent = array[a];
        while (parent > -1) {
            child = parent;
            parent = array[parent];
        }
        return child;
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
