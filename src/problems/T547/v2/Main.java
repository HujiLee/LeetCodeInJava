package problems.T547.v2;


import java.util.Stack;

class Solution {
    int count = 0;
    int[][] matrix;
    public int findCircleNum(int[][] Matrix) {
        this.matrix = Matrix;
        final int N = Matrix.length;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y <= x; y++) {
                if (Matrix[x][y] == 1) {
                    mark(x, y, --count);
                }
            }
        }

        return -count;
    }

    void mark(int x, int y, int minus_count) {
        if(x<0||y<0||x>=matrix.length||y>=matrix[x].length)return;
        Stack<int[]> stack = new Stack<>();
        int[] temp;
        stack.push(new int[]{x,y});
        while (stack.size()>0){
            temp = stack.pop();
            matrix[temp[0]][temp[1]] = minus_count;
//            System.err.printf("[%s,%s] ",temp[0],temp[1]);
            {
                int $x = temp[0];
                for(int $y=0;$y<=$x;$y++){
                    if($y!=temp[1]&&matrix[$x][$y]==1){
                        stack.push(new int[]{$x,$y});
                    }
                }
            }
            {
                int $y = temp[1];
                for(int $x = $y;$x<matrix[0].length;$x++){
                    if($x!=temp[0]&&matrix[$x][$y]==1){
                        stack.push(new int[]{$x,$y});
                    }
                }
            }

        }


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
            for(int i = 0;i<100;i++){
                for(int j=0;j<100;j++){
                    ints[i][j] = 1;
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 1
        }
        {
            int[][] ints = new int[100][100];
            for(int i = 0;i<100;i++){
                for(int j=0;j<100;j++){
                    if(j%2==i%2){
                        ints[i][j] = 1;
                    }else{
                        ints[i][j] = 0;
                    }
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 2
        }

    }
}
