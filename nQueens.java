

public class nQueens
{
    static int maxRow;
    static int board[][];
    public static void main(String[] args)
    {
        maxRow = Integer.parseInt(args[0]);
        board = new int[maxRow][maxRow];
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
        for (int i = col; i<maxRow; i++)
        {
            if (board[row][i] == 1)
            {
                return false;
            }
        }
        
        //Check to the left
        for (int i = col; i>-1; i--)
        {
            if (board[row][i] == 1)
            {
                return false;
            }
        }
        
        //Check the Upper left
        for (int i = 1; i<=row; i++)
        {
           if (inBoard(row-i, col-i)) //If it's still inside the board
           {
               if (board[row-i][col-i] == 1)
               {
                 return false;
               }
           }else {break;}
        }
        
        //Check the Upper right
        for (int i = 1; i<=row; i++)
        {
           if (inBoard(row-i, col+i)) //If it's still inside the board
           {
               if (board[row-i][col+i] == 1)
               {
                 return false;
               }
           }else {break;}
        }
        
        //Check the Bottom right
        for (int i = 1; i<(maxRow-row); i++)
        {
           if (inBoard(row+i, col+i)) //If it's still inside the board
           {
               if (board[row+i][col+i] == 1)
               {
                 return false;
               }
           }else {break;}
        }
        
        //Check the Bottom left
        for (int i = 1; i<(maxRow-row); i++)
        {
           if (inBoard(row+i, col-i)) //If it's still inside the board
           {
               if (board[row+i][col-i] == 1)
               {
                 return false;
               }
           }else {break;}
        }
        return true;
    }
    
    public static boolean inBoard(int row, int col)
    {
        return ((row>-1 && row<maxRow) && (col>-1 && col<maxRow));
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
                if (board[row][col] == 0)
                {
                  System.out.print("_ ");   
                }else {
                  System.out.print("Q ");  
                }
            }
            System.out.println();
        }
    }
}
