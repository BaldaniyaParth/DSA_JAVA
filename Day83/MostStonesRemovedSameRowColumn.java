package Day83;

import java.util.Arrays;

public class MostStonesRemovedSameRowColumn {

    public static void main(String[] args) {
        int [][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for(int[] stone: stones) {
            unionAndFind.union(stone[0]+10001, stone[1]);
        }
        return n-unionAndFind.getDisjointSetCount();
    }
}

class UnionAndFind {
    int[] parent;
    int count;

    UnionAndFind(int n) {
        parent = new int[20002];
        Arrays.fill(parent, -1);
    }

    public int getDisjointSetCount() {
        int count = 0;
        for(int i=0;i<parent.length;i++){
            if(i==parent[i]) {
                count++;
            }
        }
        return count;
    }
    int find(int x) {
        if(parent[x]==-1) {
            parent[x]=x;
            count++;
        }
        if(parent[x]==x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX==parentY) {
            return;
        }
        parent[parentX]=parentY;
        count--;
    }
}