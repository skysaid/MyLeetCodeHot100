package test1;

public class Algorithm79 {
    private boolean flag=false;
    public boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||board[0].length==0)return false;
        int rlen=board.length,clen=board[0].length;
        for (int i=0;i<rlen;i++){
            for (int j=0;j<clen;j++){
                    if (dfs(board,word,1,i,j))return true;             
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int now,int i,int j){
        if (word.length()==now){
            flag=true;
            return true;
        }
        if (flag==true)return true;
        if (i>=board.length||i<0||j>=board[0].length||j<0||board[i][j]!=word.charAt(now))return false;
        char temp=board[i][j];
        board[i][j]='*';
        boolean res1= dfs(board,word,now+1,i+1,j);
        boolean res2= dfs(board,word,now+1,i-1,j);
        boolean res3= dfs(board,word,now+1,i,j-1);
        boolean res4=dfs(board,word,now+1,i,j+1);
        board[i][j]=temp;
        return res1||res2||res3||res4;
    }
}
