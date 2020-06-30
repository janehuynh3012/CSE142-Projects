// Anh Kim Huynh
// 5/4/20
// CSE142
// TA: Harshal V Desai
// Assignment #4: Guess

// This is a guessing game in which a user tries to guess a particular
// number with a range of 1 to 100. The program reports the total number
// of guesses made and the overall results of the guesses.

import java.util.*;

public class Guess {
   public final static int GUESS_RANGE = 100; // change this to change the guessing range
   
   public static void main(String[] args) {
      intro();
      games();
   }
   
   // introduces the game to an user
   public static void intro() {  
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // returns the number of guesses to get the correct answer
   // by prompting until a number in proper range is entered
   public static int game(Scanner console) {
      System.out.println("I'm thinking of a number between 1 and 100...");
      System.out.print("Your guess? ");
      int guess = console.nextInt();
      int numGuesses = 1;
      int answer = (int) (Math.random() * 100) + 1;
      // gives hint until correct answer is reached
      while (guess != answer) {
         if (guess < answer) {
            System.out.println("It's higher.");
         } else { 
            System.out.println("It's lower.");
         }
         System.out.print("Your guess? ");
         guess = console.nextInt();
         numGuesses++;
      }
      System.out.println("You got it right in " + numGuesses + " guesses");
      return numGuesses;      
   }
     
   // uses the provided console Scanner to prompt for the user's result
   // asks if the user wants to continue playing
   public static void games() {
      Random r = new Random();
      Scanner sc = new Scanner(System.in);
      int i = 0;
      int totalGuesses = 0;
      int numberOfGames = 1;
      int guessesGame = 0;
      int bestGame = Integer.MAX_VALUE;
      while(i < numberOfGames) {
         int noGuesses = game(sc);
         totalGuesses += noGuesses;
         bestGame = Math.min(noGuesses, bestGame);
         System.out.print("Do you want to play again? ");
         String choice = sc.next().toLowerCase();
         if (choice.contains("y")) {
         numberOfGames++;
         } 
         i++;
         System.out.println();
      }
      overallResult(numberOfGames, totalGuesses, guessesGame, bestGame);
   }
  
   // reports the overall result of all the guesses in one game
   public static void overallResult(int numberOfGames, int totalGuesses, 
                                    double guessesGame, int bestGame) {
      System.out.println("Overall results:");
      System.out.println("    total games   = " + numberOfGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round1(totalGuesses / (double) numberOfGames));
      System.out.println("    best game     = " + bestGame);
   }
    
   // returns the result of rounding n to 1 digit after the decimal point  
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}