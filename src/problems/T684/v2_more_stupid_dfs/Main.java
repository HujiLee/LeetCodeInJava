package problems.T684.v2_more_stupid_dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    enum Mark {unvisitied, visited, root}

    /**
     * 假设..edges的长度大于等于点的个数
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        ArrayList<Mark> marks = new ArrayList<Mark>() {{
            for (int i = 0; i <= n; i++) {
                this.add(Mark.unvisitied);
            }
        }};
        Stack<Integer> cycle = null;
        for (int i = 1; i <= n; i++) {
            cycle = dsfFrom(i, new ArrayList<Mark>(marks), graph);
            if (cycle != null) {
//          System.out.println(cycle);
                //reuse  graph
                for (int j = 0; j <= cycle.size() - 2; j++) {
                    int a = cycle.get(j), b = cycle.get(j + 1);
                    graph[a][b] = false;
                    graph[b][a] = false;
                }
                for (int k = edges.length - 1; k >= 0; k--) {
                    if (!graph[edges[k][0]][edges[k][1]]) {
                        return edges[k];
                    }
                }
            }
        }
        return null;
    }

    Stack<Integer> dsfFrom(int from, List<Mark> marks, final boolean[][] graph) {
        System.out.print(from + ",");
        marks.set(from, Mark.root);
        Stack<Integer> stack = new Stack<Integer>() {{
            this.add(from);
        }};
        while (stack.size() == 1 || (stack.size() > 1 && !stack.firstElement().equals(stack.lastElement()))) {
            int top = stack.lastElement();
            boolean flag = true;
            for (int x = 0; x < graph[top].length; x++) {
                if (graph[top][x])
                    if (marks.get(x) == Mark.unvisitied) {
                        System.out.print(x + ",");
                        marks.set(x, Mark.visited);
                        stack.push(x);
                        flag = false;
                        break;
                    } else if (marks.get(x) == Mark.root && stack.size() > 2) {
                        System.out.println();
                        stack.push(x);
                        flag = false;
                        break;
                    }
            }
            if (flag) {
                stack.pop();
            }

        }
        if (stack.empty()) {
            return null;
        } else {
            assert stack.size() >= 4;
            return stack;
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
