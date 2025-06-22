import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Καλοσήρθατε στον κόσμο της Τρίλιζας!");
        System.out.println("πόσο επί ποσο θες να παιξεις Τρίλιζα?");
        Scanner keyboard = new Scanner(System.in);
        int row = keyboard.nextInt();
        int col = keyboard.nextInt();

        if (row == col) {
            String[][] mygameBoard = new String[row][col];

            initializeGameBoard(mygameBoard);
            printInitializedBoard(mygameBoard);
            boolean x = true;
            getUserInput(x,mygameBoard);

        }
        else {
            System.out.println("θα πρέπει οι αριθμοί να είναι ίδιοι");
        }


    }// end of main

    //public static void runGame(){
    //}// end runGame

    public static void initializeGameBoard(String[][] gameBoard){

        System.out.println("το μεγεθος του gameboard ειναι " + gameBoard.length + "x" + gameBoard.length);
        System.out.print("τα ονοματα στα τετραγωνα ειναι: ");
        for (int row = 0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard.length; col++){
                gameBoard[row][col] = row + "" + col;
                System.out.print(gameBoard[row][col] + ", ");
            }
        }

        System.out.println();

    }// end initializeGameBoard

    public static void printInitializedBoard(String[][] gameBoard){

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

    }// end printInitializedBoard

    public static void getUserInput(boolean xTurn,String[][] gameBoard){
        int totalMoves = gameBoard.length * gameBoard.length;
        for (int i=1; i<=(totalMoves); i++) {
            //System.out.println("Μπηκε: " + i + " φορά");
            if (xTurn) {
                System.out.println("Παίζει ο παίχτης με το Χ");
                System.out.print("Σε ποιο τετράγωνο θες να παίξεις; ");
                System.out.println("Βάλε γραμμή και στήλη");
                Scanner keyboard = new Scanner(System.in);
                int myrow;

//                if (myrow>= gameBoard.length){
//                    System.out.println("Έδωσες λάθος γραμμή. Ξανα προσπάθησε.");
//                    getUserInput(xTurn, gameBoard);
//                }

                do {
                    System.out.print("Γράψε γραμμή: ");
                    myrow = keyboard.nextInt();
                    if (myrow < 0 || myrow >= gameBoard.length) {
                        System.out.println("Έδωσες λάθος γραμμή. Ξαναπροσπάθησε.");
                    }
                } while (myrow < 0 || myrow >= gameBoard.length);

                int mycol;

//                if (mycol>= gameBoard.length){
//                    System.out.println("Έδωσες λάθος στήλη. Ξανα προσπάθησε.");
//                    getUserInput(xTurn, gameBoard);
//                }

                do {
                    System.out.print("Γράψε στήλη: ");
                    mycol = keyboard.nextInt();
                    if (mycol < 0 || mycol >= gameBoard.length) {
                        System.out.println("Έδωσες λάθος στήλη. Ξαναπροσπάθησε.");
                    }
                } while (mycol < 0 || mycol >= gameBoard.length);

                if (cellAlreadyOccupied(myrow, mycol, gameBoard)) {

                        System.out.println("Δωσε ξανα. Εκει που θες να βαλεις εχει ηδη παιχτει.");
                        printCurrentBoard(gameBoard);
                        getUserInput(xTurn, gameBoard);

                } else {
                    gameBoard[myrow][mycol] = " X ";
                    printCurrentBoard(gameBoard);
                    if (isBoardFull(gameBoard)){
                        break;
                    }
                    if (Objects.equals(getWinner(myrow, mycol, gameBoard), "victory!")){
                        break;
                    }
                }

            } else {
                System.out.println("Παίζει ο παίχτης με το Y");
                System.out.print("Σε ποιο τετράγωνο θες να παίξεις; ");
                System.out.println("Βάλε γραμμή και στήλη");
                Scanner keyboard = new Scanner(System.in);
                int myrow;
                do {
                    System.out.print("Γράψε γραμμή: ");
                    myrow = keyboard.nextInt();
                    if (myrow < 0 || myrow >= gameBoard.length) {
                        System.out.println("Έδωσες λάθος γραμμή. Ξαναπροσπάθησε.");
                    }
                } while (myrow < 0 || myrow >= gameBoard.length);

                int mycol;
                do {
                    System.out.print("Γράψε στήλη: ");
                    mycol = keyboard.nextInt();
                    if (mycol < 0 || mycol >= gameBoard.length) {
                        System.out.println("Έδωσες λάθος στήλη. Ξαναπροσπάθησε.");
                    }
                } while (mycol < 0 || mycol >= gameBoard.length);

                if (cellAlreadyOccupied(myrow, mycol, gameBoard)) {

                        System.out.println("Δωσε ξανα. Εκει που θες να βαλεις εχει ηδη παιχτει.");
                        printCurrentBoard(gameBoard);
                        getUserInput(xTurn, gameBoard);

                } else {
                    gameBoard[myrow][mycol] = " Y ";
                    printCurrentBoard(gameBoard);
                    if (isBoardFull(gameBoard)){
                        break;
                    }
                    if (Objects.equals(getWinner(myrow, mycol, gameBoard), "victory!")){
                        break;
                    }
                }
            }
            xTurn = !xTurn;
        }



    }// end getUserInput

    public static void printCurrentBoard(String[][] gameBoard){
        printInitializedBoard(gameBoard);
        //System.out.println("μπηκε printCurrentBoard");
    }

    public static boolean cellAlreadyOccupied(int row, int col, String[][] gameBoard){

        if (Objects.equals(gameBoard[row][col], " X ") || Objects.equals(gameBoard[row][col], " Y ")){
            return true;
        }
        else {
            return false;
        }
    }// end cellAlreadyOccupied

    public static String getWinner(int selectedRow, int selectedCol, String[][] gameBoard){

        int length = gameBoard.length;
        String result = "";

        //checking the diagonials
        if ((selectedRow == selectedCol) || (selectedRow + selectedCol == gameBoard.length-1)) {

            boolean majorDiag = true;
            boolean minorDiag = true;


            String tempMaj = gameBoard[0][0];
            String tempMin = gameBoard[0][length - 1];

            // Check major diagonal, and update the boolean if our assumption is wrong.
            for (int i = 1; i < length; i++) {
                if (!Objects.equals(gameBoard[i][i], tempMaj)) {
                    majorDiag = false;
                    break;
                }
            }

            // Check minor diagonal, and update the boolean if our assumption is wrong.
            for (int i = 1, j = length - 2; i < length; i++, j--) {
                if (!Objects.equals(gameBoard[i][j], tempMin)) {
                    minorDiag = false;
                    break;
                }
            }



            if (majorDiag || minorDiag) {
                result = "victory!";
            } else {
                result = "";
            }
        }
        else {

            //checking the row & col
            String checkingPoint = gameBoard[selectedRow][selectedCol];
            boolean sameRow = true;
            boolean sameCol = true;

            //checking the Row
            for (int i = 0; i < length; i++) {
                if (!Objects.equals(gameBoard[selectedRow][i], checkingPoint)) {
                    sameRow = false;
                    break;
                }
            }

            //checking the Col
            for (int i = 0; i < length; i++) {
                if (!Objects.equals(gameBoard[i][selectedCol], checkingPoint)) {
                    sameCol = false;
                    break;
                }
            }
//            System.out.println(sameRow);
//            System.out.println(sameCol);
            if (sameRow || sameCol) {
                result = "victory!";
            } else {
                result = "παπαλα";
            }
        }

        System.out.println(result);
        return result;


    }// end getWinner

    public static boolean isBoardFull(String[][] gameBoard){

        int count = 0;
        int totalMoves = gameBoard.length * gameBoard.length;

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (Objects.equals(gameBoard[row][col], " X ") || Objects.equals(gameBoard[row][col], " Y ")) {
                    count++;
                }
            }
        }
        System.out.println("count: " + count);
        if (count == (totalMoves)) {
            System.out.println("Γέμισε το τερεν");
            return true;
        }
        else{
            return false;
        }

    }// end isBoardFull

}// end class