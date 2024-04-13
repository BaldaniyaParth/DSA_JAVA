package Day75;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    public static void main(String[] args) {
        int [][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] recst) {
        vis[src] = true;
        recst[src] = true;
        for (int x : adj.get(src)) {
            if (!vis[x] && dfs(adj, x, vis, recst)) {
                return true;
            } else if (recst[x]) {
                return true;
            }
        }
        recst[src] = false;
        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            adj.add(list);
        }
        boolean[] vis = new boolean[n];
        boolean[] recst = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, recst);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < recst.length; i++) {
            if (!recst[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
