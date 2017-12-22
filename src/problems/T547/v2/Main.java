package problems.T547.v2;


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
        {
            int $y = y+1;
            while ($y<matrix[x].length){
                if(get(x,$y)==1){
                    matrix[x][$y] = minus_count;
                }
                $y++;
            }
        }
        {
            int $y = y-1;
            while ($y>=0){
                if(get(x,$y)==1){
                    matrix[x][$y] = minus_count;
                }
                $y--;
            }
        }
        {
            int $x = x+1;
            while ($x<matrix.length){
                if(get($x,y)==1){
                    matrix[$x][y] = minus_count;
                }
                $x++;
            }

        }
        {
            int $x = x-1;
            while ($x>=0){
                if(get($x,y)==1){
                    matrix[$x][y] = minus_count;
                }
                $x--;
            }

        }


    }
}
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
        }

    }
}
