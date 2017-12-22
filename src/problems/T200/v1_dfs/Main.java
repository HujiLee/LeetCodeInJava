package problems.T200.v1_dfs;

class Solution {

    int count = 0;
    char[][] grid;

    private char get(int x, int y) {
        if (x < 0||y<0) return '0';
        else if(x>=grid.length) return '0';
        else if(y>=grid[x].length) return '0';
        else return grid[x][y];
    }

    private void set(int x, int y,int minus_no){
        if(x<0||y<0||x>=grid.length||y>=grid[x].length) return;
        grid[x][y] = (char)minus_no;
    }
    void mark(int x,int y,int minus_no){
        set(x,y,minus_no);
        if(get(x-1,y)=='1') mark(x-1,y,minus_no);
        if(get(x+1,y)=='1') mark(x+1,y,minus_no);
        if(get(x,y-1)=='1') mark(x,y-1,minus_no);
        if(get(x,y+1)=='1') mark(x,y+1,minus_no);
    }
    public int numIslands(char[][] grid) {
        this.grid = grid;
        for(int x = 0;x<grid.length;x++){
            for(int y = 0;y<grid[x].length;y++){
                if(get(x,y)=='1'){
                    mark(x,y,--count);
                }
            }
        }

        return -count;
    }
}

/**
 * @anchor https://leetcode.com/problems/number-of-islands/description/
 */
public class Main {
    public static void main(String[] args) {
        /*
        * generate java char[][] from sample input string with javascript
        *
        * let s = ["11110", "11010", "11000", "00000"];
        * console.log(s.map(e=>`new char[]{`+e.split('').map(e=>`'${e}'`).join(',')+'}').join(',\n'))
        * */
        {
            int answer = new Solution().numIslands(
                    new char[][]{
                            new char[]{'1', '1', '1', '1', '0'},
                            new char[]{'1', '1', '0', '1', '0'},
                            new char[]{'1', '1', '0', '0', '0'},
                            new char[]{'0', '0', '0', '0', '0'}
                    }
            );
            System.out.println(answer);
        }
        {
            int answer = new Solution().numIslands(
                    new char[][]{
                            new char[]{'1','1','0','0','0'},
                            new char[]{'1','1','0','0','0'},
                            new char[]{'0','0','1','0','0'},
                            new char[]{'0','0','0','1','1'}
                    }
            );
            System.out.println(answer);
        }

    }
}
