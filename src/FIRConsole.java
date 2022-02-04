import java.util.Scanner;
/**
 * Four in a row: Two-player console, non-graphics
 * @author relkharboutly
 * @date 1/22/2020
 *
 * Modified by Emily Balboni
 * SER 210 Assignment 1
 * February 4th 2021
 */
public class FIRConsole  {
                                                     
   public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static FourInARow FIRboard = new FourInARow();

   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
       //initializing the computer's move
       int computerMove = -1;

       //initializing the computer state to be playing initially
	   int currentState = FourInARow.PLAYING;
       //initializing the user input
	   String userInput = "";
       //initializing the game state
       int gameState = 4;
        int checkWinnerOne = -1;
        int checkWinnerTwo = -1;

       //the game loop
	   do {
           //asks user to enter their move
           System.out.println("Enter move");
           //TODO:::: add an exception
           gameState = in.nextInt();

           //checks to see if the user move is in bounds (between 0 and 35)
           //user automatically is color blue
           if((gameState >= 0) && (gameState <= 35)){
               FIRboard.setMove(IGame.BLUE, gameState);
           }else{
               //gives user an error message when they choose a placement out of bounds
               System.out.println("Error, placement out of bounds. Choose number between 0 and 35");
           }

           //prints board with updated move
           FIRboard.printBoard();

           //call check winner after player has made their move
           checkWinnerOne = FIRboard.checkForWinner();

           //lets user know this is computer move
           System.out.println("Computer move!");

           //setting the computer move
           computerMove = FIRboard.getComputerMove();
           FIRboard.setMove(IGame.RED,computerMove);

           //printing updated board
           FIRboard.printBoard();

           //call check winner after computer has made move
           checkWinnerTwo = FIRboard.checkForWinner();

           //prompting the user to keep them updated about game status
            if(checkWinnerTwo == IGame.RED){
               System.out.println("Sorry! The computer won!");
               currentState = IGame.RED_WON;
           }else if(checkWinnerOne == IGame.BLUE){
               System.out.println("You won the game!");
               currentState = IGame.BLUE_WON;
           }else if(checkWinnerOne == IGame.RED && checkWinnerTwo == IGame.BLUE){
               System.out.println("You have tied with the computer.");
               currentState = IGame.TIE;
           }else{
                System.out.println("You are still playing. Press q to quit.");
                currentState = IGame.PLAYING;
            }



         /** TODO implement the game loop 
          * 	1- accept user move
          *     2- call getComputerMove
          *     3- Check for winner
          *     4- Print game end messages in case of Win , Lose or Tie !
          * */

      } while ((currentState == IGame.PLAYING) && (!userInput.equals("q"))); // repeat if not game-over

       System.out.println("You have finished the game!");

   }


 
     
}