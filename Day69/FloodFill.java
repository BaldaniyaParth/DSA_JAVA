package Day69;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {
        int [][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;
        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] visit, int orgColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if(visit[sr][sc] || image[sr][sc] != orgColor) {
            return;
        }
        // store color in sr and sc position and also store true
        image[sr][sc] = color;
        visit[sr][sc] = true;
        // left call
        helper(image, sr, sc - 1, color, visit, orgColor);
        // right call
        helper(image, sr, sc + 1, color, visit, orgColor);
        // up call
        helper(image, sr - 1, sc, color, visit, orgColor);
        // down call
        helper(image, sr + 1, sc, color, visit, orgColor);
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visit = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visit, image[sr][sc]);
        return image;
    }
}
