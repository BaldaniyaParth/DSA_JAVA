package Day79;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static void main(String[] args) {
        int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        int [] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<int[]>[] adjList = new List[n + 1];

        for (int i = 1; i <= n; i++)
            adjList[i] = new ArrayList<>();

        for (int time[] : times)
            adjList[time[0]].add(new int[]{time[1], time[2]});


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});

        dist[k] = 0;

        while (!pq.isEmpty()) {

            int [] curr = pq.poll();
            int currcost = curr[1];

            for (int w[] : adjList[curr[0]]) {
                if (currcost + w[1] < dist[w[0]]) {
                    dist[w[0]] = currcost + w[1];
                    pq.offer(new int[] {w[0], currcost + w[1]});
                }
            }
        }

        int minDist = 0;
        for (int i = 1; i <= n; i++)
            minDist = Math.max(minDist, dist[i]);

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
