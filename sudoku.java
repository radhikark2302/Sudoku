class Sudoku 
{
    public static boolean isSafe(int[][] board, int row, int col, int num)
    {
        for (int i=0; i<board.length; i++)
        {
            //Check if the input number is already present in that row, return false;
            if (board[row][i] == num){
                return false;
            }
        }

        //Column has unique number
        for (int j=0; j<board.length; j++){
            //Check if the input number is already present in that column, return false;
            if (board [j][col]== num){
                return false;
            }
        }

        //Corresponding square has unique number
        int sqrt = (int)Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r= boxRowStart; r < boxRowStart + sqrt; r++){
            for (int d= boxColStart; d < boxColStart + sqrt; d++){
                if (board[r][d]== num){
                    return false;
                }
            }
        }

        // if there is no clash, it's safe
        return true;
    }

    public static boolean solveSudoku( int [][] board, int n){
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i=0; i< n; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 0){
                    row = i;
                    col = j;

                  // If still some remaining missing values in Sudoku
                  isEmpty = false;
                  break;  
                }
            }
            if (!isEmpty){
                break;
            }
        }
        //No empty space left
        if(isEmpty){
            return true;
        }
        //Else for each-row backtrack
        for(int num = 1; num <=n; num++){
            if (isSafe(board, row, col, num)){
                board[row][col] = num;
                if (solveSudoku(board,n)){
                    return true;
                }
                else {
                    //replace it
                    board[row][col]= 0;
                }
            }
        }
        return false;
    }
    public static void print(int [][] board, int N){
        //print the answer
        for(int r=0; r<N ; r++){
            for(int d=0; d<N; d++){
                System.out.print(board [r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r+1)%(int)Math.sqrt(N) == 0){
                System.out.print("");
            }
        }
    }

    public static void main(String args[]){
        int [][] board = new int [][]{
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int N = board.length;

        if (solveSudoku(board, N)){
            print(board, N);
        }
        else {
            System.out.println("No solution");
        }
    }
}