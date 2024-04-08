package Day70;

public class NumberEnclaves {

    public static void main(String[] args) {
        int [][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }

    public static int numEnclaves(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                if(i==0 || j==0 || i==m-1 || j==n-1)
                {
                    if(grid[i][j] == 1)
                    {
                        dfs(grid,i,j);
                    }
                }
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static boolean dfs(int[][] grid, int i, int j)
    {
        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != 1)
        {
            return false;
        }

        grid[i][j] = -1;
        boolean left = dfs(grid,i,j-1);
        boolean right = dfs(grid,i,j+1);
        boolean up = dfs(grid,i-1,j);
        boolean down = dfs(grid,i+1,j);

        return left && right && up && down;
    }
}
