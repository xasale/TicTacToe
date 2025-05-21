public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Καλοσήρθατε στον κόσμο της Τρίλιζας!");


    }// end of main

    public static void runGame(){

    }// end runGame

    public static void initializeGameBoard(String[][] gameBoard){

        String[][] gameboard = new String[5][5];

        for (int i=0; i<=5; i++){
            for (int j=0; j<=5; j++){

                //System.out.println();
            }//end for j
        }//end for i

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