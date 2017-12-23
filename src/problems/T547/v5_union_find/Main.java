package problems.T547.v5_union_find;

import java.util.Collections;

class Solution {
    Integer[] array;

    public int findCircleNum(int[][] Matrix) {
        final int N = Matrix.length;
        array = new Integer[N];
        array = Collections.nCopies(N, -1).toArray(array);
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

    void union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            if(array[roota]<array[rootb]){
                //b tree is smaller
                array[roota]+=array[rootb];
                array[rootb] = roota;
            }else{
                array[rootb]+=array[roota];
                array[roota] = rootb;

            }

        }
    }

    int find(int a) {
        int child = a;
        int parent = array[a];
        if (parent <= -1) return a;

        while (parent > -1) {
            child = parent;
            parent = array[parent];
        }
        //so child is the root
        {
            int it = a;
            int temp;
            while (array[it] != child) {
                temp = it;
                it = array[it];
                array[temp] = child;
            }
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
