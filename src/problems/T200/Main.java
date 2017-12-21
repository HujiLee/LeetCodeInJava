package problems.T200;

class Solution {
    static class Node{
        Node parent;
    }
    public int numIslands(char[][] grid) {
        Node[][] nodes  = new Node[grid.length][]
        for(int i = 0;i<grid.length;i++){
            nodes[i] = new Node[grid[i].length];
            for(int j = 0;j<nodes[i].length;j++) {
                nodes[i][j] = null;
            }
        }
        return -1;
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
        }

    }
}
