package Day76;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int [][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length ;
        int m = grid[0].length ;

        // base case
        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1){
            return -1 ;
        }

        Queue<Pair> q = new LinkedList<>() ;

        // create dist array
        int[][] dist = new int[n][m] ;

        dist[0][0] = 1 ;
        grid[0][0] = 1 ;
        q.add(new Pair(1,0,0)) ;

        while(!q.isEmpty()){
            Pair it = q.peek() ;
            int dis = it.first ;
            int r = it.second ;
            int c = it.third ;

            q.remove() ;
            int[] delRow={0,0,-1,1,-1,-1,1,1};
            int[] delCol={-1,1,0,0,-1,1,-1,1};


            for(int i = 0 ;i < 8 ; i++){

                int nrow = r + delRow[i] ;
                int ncol = c + delCol[i] ;

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0){
                    dist[nrow][ncol] = dis + 1 ;
                    grid[nrow][ncol] = 1 ;
                    if(nrow == n - 1 && ncol == m - 1){
                        return dis + 1 ;
                    }
                    q.add(new Pair(dis + 1, nrow, ncol)) ;
                }


            }
        }

        if(dist[n - 1][m - 1] == 0){
            return -1 ;
        }

        return dist[n - 1][m - 1] ;

    }

}


class Pair{
    int first ;
    int second ;
    int third ;

    public Pair(int i ,int j,int k){
        this.first = i ;
        this.second = j ;
        this.third = k ;

    }
}