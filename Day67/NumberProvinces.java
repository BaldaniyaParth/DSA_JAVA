package Day67;

public class NumberProvinces {

    public static void main(String[] args) {
        int [][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] mat) {
        int ans=0,n=mat.length;
        boolean visit[]=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                ans++;
                dfs(i,visit,mat);
            }
        }
        return ans;
    }
    public static void dfs(int node,boolean[] visit,int[][] mat){
        visit[node]=true;
        for(int i=0;i<mat.length;i++){
            if(!visit[i] && mat[node][i]==1) dfs(i,visit,mat);
        }
    }
}
