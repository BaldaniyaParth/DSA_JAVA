package Day72;

import java.util.Arrays;

public class IsGraphBipartite {

    public static void main(String[] args) {
        int [][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph)
    {
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);

        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(graph,i,color,0)==false)
                    return false;
            }
        }
        return true;
    }
    public static boolean dfs(int graph[][], int V, int color[], int col)
    {
        color[V] = col;

        for(int i: graph[V])
        {
            if(color[i]==-1)
            {
                if(dfs(graph,i,color,1-col)==false)
                    return false;
            }
            else if(color[i]==col)
                return false;
        }
        return true;
    }

}

