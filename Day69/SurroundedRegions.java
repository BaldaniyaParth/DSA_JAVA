package Day69;

public class SurroundedRegions {

    public static void main(String[] args) {
        char [][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(solve(board));
    }

    public static boolean solve(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]!='X')
                DFS(i,0,grid);
            if(grid[i][grid[0].length-1]!='X')
                DFS(i,grid[0].length-1,grid);
        }
        for(int i=0;i<grid[0].length-1;i++){
            if(grid[0][i]!='X')
                DFS(0,i,grid);
            if(grid[grid.length-1][i]!='X')
                DFS(grid.length-1,i,grid);
        }
        swap(grid,'O','X');
        swap(grid,'p','O');
        return false;
    }

    static void swap(char[][] grid,char p, char q){
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==p) grid[i][j]=q;
    }

    static void DFS(int i,int j, char[][] grid){
        if(!(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='O')) return ;
        grid[i][j]='p';
        DFS(i+1,j,grid);
        DFS(i,j+1,grid);
        DFS(i-1,j,grid);
        DFS(i,j-1,grid);
    }
}
