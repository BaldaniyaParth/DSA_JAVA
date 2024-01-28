package Practice;

public class RotateImage {

    public static void main(String[] args) {
        int [][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        transpose(matrix);
        reverseRows(matrix);
        for (int i=0; i< matrix.length; i++){
            for (int j=0; j< matrix.length; j++){
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {

    }
    public static void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseRows(int[][] matrix) {
        for(int r=0; r<matrix.length; r++) {
            int left = 0;
            int right = matrix.length-1;

            while(left < right) {
                int temp = matrix[r][left];
                matrix[r][left] = matrix[r][right];
                matrix[r][right] = temp;

                left++;
                right--;
            }
        }

    }
}
