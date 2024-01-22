package Week2;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }
        public static boolean isValidSudoku(char[][] b)
        {
            int r=9;
            int c=9;
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<9;j++)
                {
                    char ch=b[i][j];
                    if(ch!='.')
                    {
                        boolean rowcheck=isRowValid(b,i,b[i][j]);
                        boolean colcheck=isColValid(b,j,b[i][j]);
                        boolean mcheck=isMatrixValid(b,i,j,b[i][j]);
                        if(rowcheck==false || colcheck==false || mcheck==false)
                        {
                            return false;
                        }
                    }
                }
            }
            return true;

        }
        public static boolean isRowValid(char[][] a,int r,char ch)
        {
            int f=0;
            for(int i=0;i<9;i++)
            {
                char c=a[r][i];
                if(c==ch)
                {
                    f++;
                }
            }
            if(f==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static boolean isColValid(char[][] a,int c,char ch)
        {
            int f=0;
            for(int i=0;i<9;i++)
            {
                char p=a[i][c];
                if(p==ch)
                {
                    f++;
                }
            }
            if(f==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static boolean isMatrixValid(char[][] a, int r, int col, char ch)
        {
            int x=r/3*3;
            int y=col/3*3;
            int f=0;
            for(int i=x;i<x+3;i++)
            {
                for(int j=y;j<y+3;j++)
                {
                    if(a[i][j]==ch)
                    {
                        f++;
                    }
                }
            }
            if(f==1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

}
