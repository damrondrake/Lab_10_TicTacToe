import java.util.*;
import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    // sets all the board elements to a space
    private static void clearBoard()
    {
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
                board[i][j] = " ";
        }
    }

    // shows the Tic Tac Toe game used as part of the prompt for the users move choice…
    private static void display()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]) ;

                if(j != 2)
                    System.out.print(" |");
            }

            if(i != 2)
                System.out.print("\n------------");
            System.out.println();
        }
        System.out.println();
    }

    // returns true if there is a space at the given proposed move coordinates which means it is a legal move.
    private static boolean isValidMove(int row, int col)
    {
        return(board[row][col].equals(" "));
    }

    // checks to see if there is a win state on the current board for the specified player (X or O)
// This method in turn calls three additional methods that break down the 3 kinds of wins that are possible.
    private static boolean isWin(String player)
    {
        return(isColWin(player) || isRowWin(player) || isDiagnalWin(player));
    }

    // checks for a col win for specified player
    private static boolean isColWin(String player)
    {
// loop to check if all the 3 rows of a column has player symbol
        for(int i=0;i<COL;i++)
        {
            if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player))
                return true;
        }

        return false;
    }

    // checks for a row win for the specified player
    private static boolean isRowWin(String player)
    {
// loop to check if all the columns of a row has player symbol
        for(int i=0;i<ROW;i++)
        {
            if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player))
                return true;
        }

        return false;
    }

    // checks for a diagonal win for the specified player
    private static boolean isDiagnalWin(String player)
    {
// check the main diagonal
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
            return true;
// check the other diagonal
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))
            return true;

        return false;
    }

    // checks for a tie condition: all spaces on the board are filled OR there is an X and an O
// in every win vector (i.e. all possible 8 wins are blocked by having both and X and an O in them.)
    private static boolean isTie()
    {
// loop to check if there are any empty space
        for(int i=0;i<ROW;i++)
        {
            for(int j=0;j<COL;j++)
            {
                if(board[i][j].equals(" "))
                    return false;
            }
        }

        return true;
    }

    // toggles the player i.e. if current player is "X" returns "O" else "X"
    private static String togglePlayer(String player)
    {
        if(player.equals("X"))
            return "O";
        else
            return "X";
    }

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String player;
        int row, col;
// loop continues till the user wants to play
        do
        {
            clearBoard(); // clear the board
            player = "X"; // initialize player to X

// loop continues till a player wins, or it ends in a tie
            while(!isWin("X") && !isWin("O") && !isTie())
            {
// display the board
                display();

// input of row and column for the move
                row = SafeInput.getRangedInt(console, "Player "+player+", enter row number: ", 1, ROW);
                col = SafeInput.getRangedInt(console, "Player "+player+", enter column number: ", 1, COL);

// validate the move and re-prompt until valid
                while(!isValidMove(row-1,col-1))
                {
                    System.out.println("The position is already occupied. Please re-enter");
                    row = SafeInput.getRangedInt(console, "Player "+player+", enter row number: ", 1, ROW);
                    col = SafeInput.getRangedInt(console, "Player "+player+", enter column number: ", 1, COL);
                }

                board[row-1][col-1] = player; // set the location to player
// check if it results in player winning
                if(isWin(player))
                    break; // if player wins exit the loop
// change the current player
                player = togglePlayer(player);
            }
// display the final board
            display();
// determine the result
            if(!isTie())
                System.out.println("Player "+player +" wins!");
            else
                System.out.println("Its a tie!");
            System.out.println();

        }while(SafeInput.getYNConfirm(console, "Do you want to play another game (Y/N)? "));

    }

}