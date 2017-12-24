package problems.T684.v1_stupid_dfs;

import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    enum Mark {unknow, visited, root}

    TreeMap<Integer, Set<Integer>> p2ps;
    TreeMap<Integer, Mark> p2ifmarked = new TreeMap<Integer, Mark>();
    Stack<Integer> find_cycle = new Stack<>();

    public int[] findRedundantConnection(int[][] edges) {
        p2ps = new TreeMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!p2ps.containsKey(a)) {
                p2ps.put(a, new TreeSet<Integer>());
            }
            if (!p2ps.containsKey(b)) {
                p2ps.put(b, new TreeSet<Integer>());
            }
            p2ps.get(a).add(b);
            p2ps.get(b).add(a);
            p2ifmarked.put(a, Mark.unknow);
            p2ifmarked.put(b, Mark.unknow);
        }
        for (Integer key : p2ps.keySet()) {
            try {
                dsf(key, new TreeMap<Integer, Mark>(p2ifmarked));
            } catch (Exception e) {
                break;
            }
        }
        TreeSet<String> int_set = new TreeSet<String>() {{
            for (int i = 0; i <= find_cycle.size() - 2; i++) {
                int a = find_cycle.get(i), b = find_cycle.get(i + 1);
                if (a > b) {
                    this.add(b + "," + a);
                } else {
                    this.add(a + "," + b);
                }
            }
        }};
        for (int i = edges.length - 1; i >= 0; i--) {
            if (int_set.contains(edges[i][0] + "," + edges[i][1])) {
                return edges[i];
            }
        }
        return null;
    }

    void dsf(int gothrough, TreeMap<Integer, Mark> p2icopy, int length) throws Exception {
        Mark mark = p2icopy.get(gothrough);
        if (mark == Mark.unknow) {
            find_cycle.push(gothrough);
            System.out.print(gothrough + ",");
            p2icopy.put(gothrough, Mark.visited);
            for (Integer linked_points : p2ps.get(gothrough)) {
                dsf(linked_points, p2icopy, length + 1);
            }
            find_cycle.pop();
        } else if (mark == Mark.root && length > 1) {
            find_cycle.push(gothrough);
            System.out.print("!!,");
            throw new Exception("cycle!");
//            p2icopy.put(gothrough, Mark.visited);
        }

    }

    void dsf(int from, TreeMap<Integer, Mark> p2icopy) throws Exception {
        find_cycle.clear();
        if (p2icopy.containsKey(from)) {
            find_cycle.push(from);
            System.out.print(from + ",");
            p2icopy.put(from, Mark.root);
            for (Integer linked_points : p2ps.get(from)) {
                dsf(linked_points, p2icopy, 0);
            }
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
            System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
        }
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{3, 4},
                    new int[]{1, 4},
                    new int[]{1, 5}
            });//[1,4]
            System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
        }
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 3},
                    new int[]{2, 3},

            });//[2,3]
            System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
        }
    }
}
