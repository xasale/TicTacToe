import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Καλοσήρθατε στον κόσμο της Τρίλιζας!");
        System.out.println("πόσο επί ποσο θες να παιξεις Τρίλιζα?");
        Scanner keyboard = new Scanner(System.in);
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();
        //System.out.println(row + " και " + col);

        if (row == col) {
            String[][] mygameBoard = new String[row][col];

            initializeGameBoard(mygameBoard);
        }
        else {
            System.out.println("θα πρέπει οι αριθμοί να είναι ίδιοι");
        }


    }// end of main

    public static void runGame(){

    }// end runGame

    public static void initializeGameBoard(String[][] gameBoard){

//        gameBoard[0][0] = "00";
//        gameBoard[0][1] = "01";
//        gameBoard[0][2] = "02";
//        gameBoard[1][0] = "10";
//        gameBoard[1][1] = "11";
//        gameBoard[1][2] = "12";
//        gameBoard[2][0] = "20";
//        gameBoard[2][1] = "21";
//        gameBoard[2][2] = "22";

        //

        System.out.println("το μεγεθος του gameboard ειναι " + gameBoard.length + "x" + gameBoard.length);
        System.out.print("τα ονοματα στα τετραγωνα ειναι: ");
        for (int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard.length; col++){
                gameBoard[row][col] = row + "" + col;

                System.out.print(gameBoard[row][col] + ", ");
                //System.out.println(row + " kai " + col);

            }
        }

        System.out.println();

        for (int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard.length; col++){
                System.out.print(gameBoard[row][col]);
                if (col != gameBoard.length-1) {
                    System.out.print("|");
                }
            }
            System.out.println();


            if (row != gameBoard.length-1) {
                String k = "--+";

                String str = k.repeat(gameBoard.length);
                //System.out.println("Str " + str);
                System.out.println(str.substring(0, str.length()-1));

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