package problems.T130.v1_dfs;

class Solution {
    char[][] board;
    final char Riku = 'R';
    public void solve(char[][] in_out_board) {
        this.board = in_out_board;
        for(int x = 0;x<board.length;x++){
            for(int y = 0;y<board[x].length;y++){
                if(x==0||y==0||x==board.length-1||y==board[x].length-1){
                    if(get(x,y)=='O'){
                        fillR(x,y);
                    }
                }
            }
        }
        for(char[] line:board){
            for(int i = 0;i<line.length;i++){
                if(line[i]=='O'){
                    line[i]='X';
                }
            }
        }
        for(char[] line:board){
            for(int i = 0;i<line.length;i++){
                if(line[i]=='R'){
                    line[i]='O';
                }
            }
        }
        System.out.print("");
    }

    char get(int x,int y){
        if(x<0||y<0||x>=board.length||y>=board[x].length){
            return Riku;
        }else{
            return board[x][y];
        }
    }

    void set(int x,int y,char ch){
        if(x<0||y<0||x>=board.length||y>=board[x].length){
            return;
        }
        board[x][y] = ch;
    }

    void fillR(int x,int y){
        set(x,y,Riku);
        if(get(x-1,y)=='O')fillR(x-1,y);
        if(get(x+1,y)=='O')fillR(x+1,y);
        if(get(x,y-1)=='O')fillR(x,y-1);
        if(get(x,y+1)=='O')fillR(x,y+1);
    }

    @Override
    public String toString() {
        if(board==null){
            return "[nu;;]";
        }else{
            StringBuffer buffer = new StringBuffer();
            for(char[] chars:board){
                for(char ch:chars){
                    buffer.append(ch);
                    buffer.append(",");
                }
                buffer.append("\n");
            }
            return buffer.toString();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        {
            char[][] board = new char[][]{
                    new char[]{'X', 'X', 'X', 'X'},
                    new char[]{'X', 'O', 'O', 'X'},
                    new char[]{'X', 'X', 'O', 'X'},
                    new char[]{'X', 'O', 'X', 'X'},
            };
            Solution s = new Solution();
            s.solve(board);
            System.out.println(s);

        }

    }
}
