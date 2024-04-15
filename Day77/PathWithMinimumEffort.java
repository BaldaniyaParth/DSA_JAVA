package Day77;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int currDistance = curr.distance;
            int row = curr.row;
            int col = curr.col;

            if (row == n - 1 && col == m - 1) {
                return currDistance;
            }

            for (int[] dir : dirs) {
                int nRow = row + dir[0];
                int nCol = col + dir[1];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int nDistance = Math.max(currDistance, Math.abs(heights[nRow][nCol] - heights[row][col]));

                    if (nDistance < dist[nRow][nCol]) {
                        dist[nRow][nCol] = nDistance;
                        pq.add(new Pair(nDistance, nRow, nCol));
                    }
                }
            }
        }

        return -1;
    }
}

class Pair {
    int distance;
    int row;
    int col;

    public Pair(int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}