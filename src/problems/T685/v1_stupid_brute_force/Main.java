package problems.T685.v1_stupid_brute_force;

import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    int[] graph = null;
    TreeSet<Integer> point_numbers = new TreeSet<>();

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        for (int i = n - 1; i >= 0; i--) {
            if (buildGraphWithoutEdge(edges, i)) {
                if (isGoodRootTree(graph)) {
                    return edges[i];
                }
            }
        }
        return null;
    }

    boolean buildGraphWithoutEdge(int[][] edges, int edgeIndex) {
        int n = edges.length;
        graph = new int[n + 1];
        point_numbers.clear();
        for (int i = 0; i < n; i++) {
            if (i != edgeIndex) {
                int p = edges[i][0], ch = edges[i][1];
                if (graph[ch] != 0) return false;//双重父母
                graph[ch] = p;
                point_numbers.add(ch);
                point_numbers.add(p);
            }
        }
        return true;
    }

    /**
     * 此处已经杜绝了一个子节点拥有多个父节点
     * 合法的有向root树有且只有一个根节点才对...
     * 根节点就是没有父母的节点
     * 如果不存在根节点,说明出现了环
     * 如果存在根节点,也可能出现环,因为这个图不一定是一棵树,也可能是一个合法树+一个完全隔离的环
     *
     * @param graph
     * @return
     */
    boolean isGoodRootTree(int[] graph) {
        //首先寻找根节点
        int root=-1;
        for(Integer point:point_numbers){
            if(graph[point]==0){
                root = point;
                break;
            }
        }
        if(root==-1)return false;
        //接下来看从root出发能否到达所有点
        //以root出发的树是不可能出现环的,因为已经杜绝了一个子节点拥有多个父节点
        //但是可能出现环在别处,导致从root出发并不能遍历所有点

        TreeMap<Integer,Set<Integer>> p2children = new TreeMap<Integer,Set<Integer>>(){{
           for(Integer child:point_numbers){
               if(graph[child]!=0){
                   int p = graph[child];
                   if(!this.containsKey(p)){
                       this.put(p,new TreeSet<Integer>());
                   }
                   this.get(p).add(child);
               }
           }
        }};
        //dfs?
        //re-use the []graph?
        int finalRoot = root;
        Stack<Integer> stack = new Stack<Integer>(){{
           this.push(finalRoot);
        }};
        Set<Integer> count_visited = new TreeSet<Integer>();
        final Set<Integer> null_ints  = new TreeSet<Integer>();
        while (!stack.empty()){
            int i = stack.pop();
//            graph[i] = -1;//表示visited
            System.out.print(i+",");

            for(Integer childred:p2children.getOrDefault(i,null_ints)){
//                if(graph[childred]!=-1){
                    stack.push(childred);
//                }
            }
            count_visited.add(i);
        }
        if(count_visited.size()==point_numbers.size()){
            return true;
        }


        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{4, 2},
                    new int[]{1, 5},
                    new int[]{5, 2},
                    new int[]{5, 3},
                    new int[]{2, 4}

            });//[4,2]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 3},
                    new int[]{2, 3},

            });//[2,3]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }
        {
            int[] answer = new Solution().findRedundantDirectedConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{3, 4},
                    new int[]{4, 1},
                    new int[]{1, 5}

            });//[4,1]
            if (answer != null)
                System.out.println(String.format("[%s,%s]", answer[0], answer[1]));
            else System.out.println("null");
        }

    }
}
