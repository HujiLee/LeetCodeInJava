package problems.T721.version_fast;

import java.util.*;

class Solution {
    int[] fa;
    int find(int x)
    {
        if (fa[x]!=x) fa[x]=find(fa[x]);
        return fa[x];
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        fa=new int[n];
        for (int i=0;i<n;i++) fa[i]=i;
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<n;i++)
        {
            List<String> list=accounts.get(i);
            int m=list.size();
            for (int j=1;j<m;j++)
            {
                String s=list.get(j);
                int x=map.getOrDefault(s,-1);
                if (x==-1) map.put(s,i);
                else
                {
                    int a=find(x),b=find(i);
                    fa[b]=a;
                }
            }
        }
        List<List<String>> ans=new ArrayList<>();
        List<List<String>> email=new ArrayList<>();
        for (int i=0;i<n;i++) email.add(new ArrayList<>());
        for (String s:map.keySet())
        {
            int x=find(map.get(s));
            email.get(x).add(s);
        }
        for (int i=0;i<n;i++)
        {
            if (email.get(i).size()==0) continue;
            Collections.sort(email.get(i));
            List<String> list=new ArrayList<>();
            list.add(accounts.get(i).get(0));
            list.addAll(email.get(i));
            ans.add(list);
        }
        return ans;
    }
}


public class Main {
    static void printAnswer(List<List<String>> answer) {
        for (List<String> stringList : answer) {
            for (String s : stringList) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++");
    }

    public static void main(String[] args) {
        /*
        let array = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John233","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]];
       array.map(e=>(`this.add(new LinkedList<String>(){{\n${e.map(i=>`this.add("${i}");`).join("\n")}\n}});`)).join("\n")
         */
        {
            List<List<String>> answer = new Solution().accountsMerge(new LinkedList<List<String>>() {{
                this.add(new LinkedList<String>() {{
                    this.add("John");
                    this.add("johnsmith@mail.com");
                    this.add("john_newyork@mail.com");
                }});
                this.add(new LinkedList<String>() {{
                    this.add("John233");
                    this.add("johnsmith@mail.com");
                    this.add("john00@mail.com");
                }});
                this.add(new LinkedList<String>() {{
                    this.add("Mary");
                    this.add("mary@mail.com");
                }});
                this.add(new LinkedList<String>() {{
                    this.add("John");
                    this.add("johnnybravo@mail.com");
                }});
            }});
            printAnswer(answer);
        }

    }
}
