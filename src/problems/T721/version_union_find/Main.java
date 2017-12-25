package problems.T721.version_union_find;

import java.util.*;

class Solution {


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<String, String>();
        Map<String, Integer> emailToID = new HashMap<String, Integer>();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap<Integer, List<String>>();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList<String>()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<List<String>>(ans.values());
    }
}
class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
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
