package problems.T200.v2_union;

import java.util.HashSet;

class Solution {
    static class NODE {
        NODE direct_parent = null;
        private int x, y;

        public NODE(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            if (direct_parent == null) {
                return String.format("{%s,%s}", x, y);
            } else {
                return String.format("{%s,%s}->%s", x, y, direct_parent.toString());
            }
        }
    }

    NODE[][] nodes;

    public int numIslands(char[][] grid) {
        {
            NODE[][] nodes = new NODE[grid.length][];
            for (int y = 0; y < nodes.length; y++) {
                nodes[y] = new NODE[grid[y].length];
            }
            for (int x = 0; x < nodes.length; x++) {
                for (int y = 0; y < nodes[x].length; y++) {
                    if (grid[x][y] == '1') {
                        nodes[x][y] = new NODE(x, y);
                        if (y > 0 && nodes[x][y - 1] != null) {
                            nodes[x][y].direct_parent = nodes[x][y - 1];
                        }
                    }
                }
            }
            this.nodes = nodes;
        }
        if (nodes.length == 0) return 0;
        int height = nodes[0].length;
        for (int y = 0; y < height; y++) {
            for (int x = 1; x < nodes.length; x++) {
                if (nodes[x][y] != null) {
                    if (nodes[x - 1][y] != null) {
                        union(new int[]{x, y}, new int[]{x - 1, y});
                    }
                }
            }
        }
        HashSet<NODE> nodeHashSet = new HashSet<>();

        for (int x = 0; x < nodes.length; x++) {
            for (int y = 0; y < nodes[x].length; y++) {
                if (nodes[x][y] != null) {
                   nodeHashSet.add(findRoot(x,y));
                }
            }
        }


        return nodeHashSet.size();
    }

    void union(int[] Node1, int[] Node2) {
        NODE root1 = findRoot(Node1[0], Node1[1]);
        NODE root2 = findRoot(Node2[0], Node2[1]);
        if (root1 != null && root2 != null && root1 != root2) {
            int rand = (int) (Math.random() * 1000);
            if (rand % 2 == 1) {
                root1.direct_parent = root2;
            } else {
                root2.direct_parent = root1;
            }
        }
    }

    NODE findRoot(int x, int y) {
        if (x < 0 || y < 0 || x >= nodes.length || y >= nodes[x].length) return null;
        if (nodes[x][y] != null) {
            NODE node = nodes[x][y];
            while (node.direct_parent != null) {
                node = node.direct_parent;
            }
            return node;
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int answer = new Solution().numIslands(
                    new char[][]{
                            new char[]{'1','1','1','1','1','1'},
                            new char[]{'1','0','0','0','0','1'},
                            new char[]{'1','0','1','1','0','1'},
                            new char[]{'1','0','0','0','0','1'},
                            new char[]{'1','1','1','1','1','1'}
                    }
            );
            System.out.println(answer);
        }
        {
            int answer = new Solution().numIslands(
                    new char[0][0]
            );
            System.out.println(answer);
        }
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
                            new char[]{'1', '1', '0', '0', '0'},
                            new char[]{'1', '1', '0', '0', '0'},
                            new char[]{'0', '0', '1', '0', '0'},
                            new char[]{'0', '0', '0', '1', '1'}
                    }
            );
            System.out.println(answer);
        }

    }
}
