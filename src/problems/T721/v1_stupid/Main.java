package problems.T721.v1_stupid;

import java.util.*;

class Solution {
    static class V_SET {
        String name;
        V_SET equals = null;
        TreeSet<String> emails = new TreeSet<>();

        V_SET findRoot() {
            if (equals == null) {
                return this;
            } else {
                V_SET root = equals;
                while (root.equals != null) {
                    root = root.equals;
                }
                equals = root;
                return root;
            }
        }

        @Override
        public String toString() {
            if (equals != null) {
                return String.format("-->%s", equals.toString());
            } else {
                return String.format("[%s:<%s>]", name, emails.toString());
            }
        }
    }

    static V_SET union(V_SET set1, V_SET set2) {
        set1 = set1.findRoot();
        set2 = set2.findRoot();
        if (set1 != set2) {
            set1.name = set2.name;
            set1.emails.addAll(set2.emails);
            set2.equals = set1;
            set2.emails.clear();
            set2.emails = null;
        }
        return set1;
    }

    static void union(List<V_SET> v_sets) {
        if (v_sets.size() == 0) return;
        Iterator<V_SET> iterator = v_sets.iterator();
        V_SET first = iterator.next();
        while (iterator.hasNext()) {
            union(first, iterator.next());
        }
    }

    HashMap<String, ArrayList<V_SET>> email2vsets = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        LinkedList<V_SET> v_accounts = new LinkedList<>();
        for (List<String> account : accounts) {
            V_SET v_set = new V_SET();
            v_set.name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                v_set.emails.add(email);
                if (!email2vsets.containsKey(email)) {
                    email2vsets.put(email, new ArrayList<V_SET>());
                }
                email2vsets.get(email).add(v_set);
            }
            v_accounts.add(v_set);
        }
        for (ArrayList<V_SET> v_sets : email2vsets.values()) {
            if (v_sets.size() > 1) {
                union(v_sets);
            }
        }

        LinkedList<List<String>> result = new LinkedList< List<String>>() {{
            for (V_SET v_set : v_accounts) {
                if (v_set.equals == null) {
                    this.add(new LinkedList<String>() {{
                        this.add(v_set.name);
                        this.addAll(v_set.emails);
                    }});
                }
            }
        }};

        return result;

    }
}

public class Main {
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
        }

    }
}
