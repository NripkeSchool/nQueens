

public class nQueens
{
    static int maxRow = 4;
    static int board[][] = new int[maxRow][maxRow];
    public static void main(String[] args)
    {
        maxRow = Integer.parseInt(args[0]);
        if(findQueen(0))
        {
            printBoard();
        }
    }
    
    public static boolean findQueen(int row)
    {
        if (row==maxRow) //Row starts at 0
        {
            return true;
        }
        for (int col = 0; col < maxRow; col++)
        {
            if (isSafe(row, col))
            {
              addQueen(row, col);
              if(findQueen(row+1))
              {
                  return true;
              }
              removeQueen(row, col);
            }
        }
        return false;
    }
    
    public static boolean isSafe(int row, int col)
    {
        //Check downwards
        for (int i = row; i<maxRow; i++)
        {
            if (board[i][col] == 1)
            {
                return false;
            }
        }
        
        //Check upwards
        for (int i = row; i>-1; i--)
        {
            if (board[i][col] == 1)
            {
                return false;
            }
        }
        
        //Check to the right
        for (int i = col; col<maxRow; i++)
        {
            if (board[row][i] == 1)
            {
                return false;
            }
        }
        
        //Check to the left
        for (int i = col; col>-1; i--)
        {
            if (board[row][i] == 1)
            {
                return false;
            }
        }
        
        //Check the Upper left
        
        return true;
    }
    
    public static void addQueen(int row, int col)
    {
        board[row][col] = 1; //1 Represents a Queen
    }
    
    public static void removeQueen(int row, int col)
    {
        board[row][col] = 0; //0 Represents an empty square
    }
    
    public static void printBoard()
    {
        for (int row = 0; row < maxRow; row++)
        {
            for (int col = 0; col < maxRow; col++)
            {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
