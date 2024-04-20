package Day82;

import java.util.ArrayList;
import java.util.List;

public class NumberOperationsMakeNetworkConnected {

    static boolean[] seen;
    static List<Integer>[] adj;

    private static void dfs(int node) {
        seen[node] = true;

        for (var neighbor : adj[node])
            if (!seen[neighbor])
                dfs(neighbor);
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1) return -1;

        seen = new boolean[n];
        adj = new ArrayList[n];

        for (var i=0; i<n; i++)
            adj[i] = new ArrayList<>();

        for (var con : connections) {
            adj[con[0]].add(con[1]);
            adj[con[1]].add(con[0]);
        }
        var groups = 0;

        for (var i=0; i<n; i++) {
            if (!seen[i]) {
                dfs(i);
                groups++;
            }
        }
        return groups - 1;
    }
    public static void main(String[] args) {
        int n = 4;
        int [][] connections = {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected(n,connections));
    }


}
