package problems.T547.v1_RuntimeError_StackOverFlowError;

class Solution {
    int count = 0;
    int[][] matrix;
    public int findCircleNum(int[][] Matrix) {
        this.matrix = Matrix;
        final int N = Matrix.length;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (Matrix[x][y] == 1) {
                    mark(x, y, --count);
                }
            }
        }

        return -count;
    }

    int get(int x,int y){
        if(x<0||y<0||x>=matrix.length||y>=matrix[x].length) return 0;
        return matrix[x][y];
    }

    void mark(int x, int y, int minus_count) {
        if(x<0||y<0||x>=matrix.length||y>=matrix[x].length)return;
        matrix[x][y] = minus_count;
        if(get(x+1,y)==1)mark(x+1,y,minus_count);
        if(get(x-1,y)==1)mark(x-1,y,minus_count);
        if(get(x,y+1)==1)mark(x,y+1,minus_count);
        if(get(x,y-1)==1)mark(x,y-1,minus_count);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

/**
 * @anchor https://leetcode.com/problems/friend-circles/description/
 */
public class Main {
    public static void main(String[] args) {
        {
            int[][] ints = new int[100][100];
            for(int i = 0;i<100;i++){
                for(int j=0;j<100;j++){
                    ints[i][j] = 1;
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);
        }  {
            int answer = new Solution().findCircleNum(new int[][]{
                    new int[]{1, 1, 0},
                    new int[]{1, 1, 0},
                    new int[]{0, 0, 1}
            });
            System.out.println(answer);
        }
        {
            int answer = new Solution().findCircleNum(new int[][]{
                    new int[]{1, 1, 1, 0},
                    new int[]{1, 1, 0, 0},
                    new int[]{1, 0, 1, 1},
                    new int[]{0, 0, 1, 1},
            });
            System.out.println(answer);
        }


    }
}
