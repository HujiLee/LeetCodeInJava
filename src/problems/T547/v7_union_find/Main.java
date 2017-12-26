package problems.T547.v7_union_find;



/**
 * Created by Administrator on 2017/12/26 0026.
 */
class Solution {
    class Element {
        int val;
        Element parent;

        public Element(int val) {
            this.val = val;
        }

        Element find(){
            if(parent==null){
                return this;
            }else{
                return parent.find();
            }
        }

        void union(Element element){
            Element myroot = find();
            Element yourroot = element.find();
            if(myroot!=yourroot){
                myroot.parent = yourroot;
            }
        }
    }

    Element[] elements;

    public int findCircleNum(int[][] M) {
        final int N = M.length;
        elements = new Element[N];
        for (int i = 0; i < N; i++) {
            elements[i] = new Element(i);
        }
        for (int x = 0; x < N; x++) {
            for (int y = 0; y <= x; y++) {
                if(M[x][y]==1){
                    elements[x].union(elements[y]);
                }
            }
        }

        int count = 0;
        for(Element element:elements){
            if(element.parent==null){
                count++;
            }
        }


        return count;
    }
}

public class Main {
    public static void main(String[] args) {
   {
            int answer = new Solution().findCircleNum(new int[][]{
                    new int[]{1, 1, 0},
                    new int[]{1, 1, 0},
                    new int[]{0, 0, 1}
            });
            System.out.println(answer);//should be 2
        }
        {
            int[][] ints = new int[100][100];
            for(int i = 0;i<100;i++){
                for(int j=0;j<100;j++){
                    ints[i][j] = 1;
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 1
        }
        {
            int[][] ints = new int[100][100];
            for(int i = 0;i<100;i++){
                for(int j=0;j<100;j++){
                    if(j%2==i%2){
                        ints[i][j] = 1;
                    }else{
                        ints[i][j] = 0;
                    }
                }
            }
            int answer = new Solution().findCircleNum(ints);
            System.out.println(answer);//should be 2
        }
    }
}
