package problems.T684;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    enum Mark {unknow,visited,root};
    TreeMap<Integer,Set<Integer>> p2ps;
    TreeMap<Integer,Mark> p2ifmarked = new TreeMap<Integer,Mark>();

    public int[] findRedundantConnection(int[][] edges) {
        p2ps = new TreeMap<>();
        for(int[] edge :edges){
            int a = edge[0],b = edge[1];
            if(!p2ps.containsKey(a)){
                p2ps.put(a,new TreeSet<Integer>());
            }
            if(!p2ps.containsKey(b)){
                p2ps.put(b,new TreeSet<Integer>());
            }
            p2ps.get(a).add(b);
            p2ps.get(b).add(a);
            p2ifmarked.put(a,Mark.unknow);
            p2ifmarked.put(b,Mark.unknow);
        }


        dsf(1,new TreeMap<Integer,Mark>(p2ifmarked));
        System.out.println("");
        dsf(2,new TreeMap<Integer,Mark>(p2ifmarked));
        System.out.println("");
        return null;
    }

    void dsf(int gothrough,TreeMap<Integer,Mark> p2icopy,int length){
        System.out.print(gothrough+",");
        p2icopy.put(gothrough,Mark.visited);
        for(Integer linked_points:p2ps.get(gothrough)){
            Mark mark = p2icopy.get(linked_points);
            if(mark==Mark.root&&length>1){
                System.out.print("!!");
            }else if(mark==Mark.unknow){
                dsf(linked_points,p2icopy,length+1);
            }
        }
    }
    void dsf(int from,TreeMap<Integer,Mark> p2icopy){
        System.out.print(from+",");
        p2icopy.put(from,Mark.root);
        for(Integer linked_points:p2ps.get(from)){
            dsf(linked_points,p2icopy,1);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{2, 3},
                    new int[]{3, 4},
                    new int[]{1, 4},
                    new int[]{1, 5}
            });
        }
        {
            int[] answer = new Solution().findRedundantConnection(new int[][]{
                    new int[]{1, 2},
                    new int[]{1, 3},
                    new int[]{2, 3},

            });
        }
    }
}
