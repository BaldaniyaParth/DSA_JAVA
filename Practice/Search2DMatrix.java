package Practice;

public class Search2DMatrix {

    public static void main(String[] args) {
        int [][] matrix = {{1,3,5,7},{10,13,16,20},{23,30,34,60}};
        int target = 13;
        System.out.println(searchMatrix(matrix,target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length-1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                col--;
            }
        }

        return false;
    }
}
