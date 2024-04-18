package Day80;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NumberWaysArriveDestination {

    public static void main(String[] args) {
        int n = 7;
        int [][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(n, roads));
    }

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = roads.length;
        if (m == 1)
            return m;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Long.compare(x.time, y.time));
        int[] ways = new int[n];
        long[] dist = new long[n];
        pq.add(new Pair(0, 0));
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            int nd = pq.peek().node;
            long tm = pq.peek().time;
            pq.remove();
            for (Pair it : adj.get(nd)) {
                int nde = it.node;
                long tme = it.time;
                if (dist[nde] > tme + tm) {
                    dist[nde] = tme + tm;
                    ways[nde] = ways[nd];
                    ways[nde] %= mod;
                    pq.add(new Pair(nde, tme + tm));
                } else if (dist[nde] == tme + tm) {
                    ways[nde] += ways[nd];
                    ways[nde] %= mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }


}

class Pair {
    int node;
    long time;

    public Pair(int node, long time) {
        this.node = node;
        this.time = time;
    }
}