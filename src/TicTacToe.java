import java.util.Arrays;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Καλοσήρθατε στον κόσμο της Τρίλιζας!");

        String[][] gameBoard = new String[5][5];

        initializeGameBoard(gameBoard);


    }// end of main

    public static void runGame(){

    }// end runGame

    public static void initializeGameBoard(String[][] gameBoard){

        for (int row=0; row<=4; row++){
            if (row==0 || row==2 || row ==4) {
                for (int col = 0; col <= 4; col++) {
                    gameBoard[row][col] = "   |   |   ";
                    System.out.println();
                }
            }

            else{
                for (int col=0; col<=4; col++){
                gameBoard[row][col] = "---+---+---";
                System.out.println();
            }
            }
        }
        for (int row = 0; row <= 4; row++){
            for (int col = 0; col <= 4; col++){
                System.out.println(gameBoard[row][col]);
            }
        }



    }// end initializeGameBoard

    public static void printCurrentBoard(String[][] gameBoard){

    }// end printCurrentBoard

    public static void getUserInput(boolean xTurn,String[][] gameBoard){

    }// end getUserInput

    public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard){
        return false ;
    }// end cellAlreadyOccupied

    public static String getWinner(String[][] gameBoard){
        return "" ;
    }// end getWinner

    public static boolean isBoardFull(String[][] gameBoard){
        return false ;
    }// end isBoardFull

}// end class