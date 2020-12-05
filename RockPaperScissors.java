/*
* This program plays rock paper scissors with a computer.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-04
* Class RockPaperScissors.
*/

import java.util.Scanner;

public class RockPaperScissors {
  
  /**
  * Function to determine the outcome of the rock paper scissors match. 
  * receives integer information from main and rolldie to decide match.
  */
  static int rpsLogicFunction(int userIntRps, int rolledInt) {
    // defines variable that will hold the outcome of the match
    int finalIntAns = 0;
    // computer and user tie
    if (rolledInt == userIntRps) {
      finalIntAns = 3;
    } else if ((userIntRps == 1) && (rolledInt == 3)) {
      // user wins rock over scissors
      finalIntAns = 1;
    } else if ((userIntRps == 2) && (rolledInt == 1)) {
      // user wins paper over rock
      finalIntAns = 1;
    } else if ((userIntRps == 3) && (rolledInt == 2)) {
      // user wins scissors over paper
      finalIntAns = 1;
    } else if ((userIntRps == 1) && (rolledInt == 2)) {
      // computer wins paper over rock
      finalIntAns = 2;
    } else if ((userIntRps == 2) && (rolledInt == 3)) {
      // computer wins scissors over paper
      finalIntAns = 2;
    } else if ((userIntRps == 3) && (rolledInt == 1)) {
      // computer wins rock over scissors
      finalIntAns = 2;
    }
    return finalIntAns;
  }

  /**
  * Function gets random number and states random generated numbers
  * correlating symbol in rock paper scissors. Also calls logic function.
  */
  static int rollDie(int userIntRps) {
    // generates random number
    final int rolledInt = (int) (Math.random() * 3 + 1);
    
    //determines whether the computer picked rock paper or scissors
    if (rolledInt == 1) {
      System.out.println("Computer chose Rock");
    } else if (rolledInt == 2) {
      System.out.println("Computer chose Paper");
    } else if (rolledInt == 3) {
      System.out.println("Computer chose Scissors");
    }
    
    // prints out user inputted number and computer generated number
    // System.out.println(userIntRps);
    // System.out.println(rolledInt);
    
    // Calls logic function
    int compAns = rpsLogicFunction(userIntRps, rolledInt);

    // returns integer answer from logic function
    return compAns;
  }

  /**
  * Main function receives users input in form of rock paper or scissors and 
  * converts it to integer data to send off to other function. Eventually receives
  * information that allows it to determine the outcome of the rock paper 
  * scissors match.
  */ 
  public static void main(String[] args) {

    // Create scanner object
    Scanner scan = new Scanner(System.in);
    
    // creates variable to store users data
    int userIntRps = 0;
    
    // prompts user to enter string input
    System.out.println("Welcome to rock paper scissors! Enter either rock, "
                       + "paper or scissors to play!");
    // Read user inputted string input
    String lowInputRps = scan.nextLine();
    // converts string to uppercase to catch misinputs of capitals
    String inputRps = lowInputRps.toUpperCase();
    
    // converts string input to data value
    if (inputRps.equals("ROCK")) {
      userIntRps = 1;
    } else if (inputRps.equals("PAPER")) {
      userIntRps = 2;
    } else if (inputRps.equals("SCISSORS")) {
      userIntRps = 3;
    } else {
      // catches invalid answers in same way as try catch
      System.out.println("Invalid Input");
      return;
    }

    // receives information from RollDie which itself receives info from rPS.
    int finalAns = rollDie(userIntRps);
    
    //prints outcome of match after receiving info from rpsLogicFunction
    if (finalAns == 1) {
      System.out.println("You Won!");
    } else if (finalAns == 2) {
      System.out.println("You Lost!");
    } else if (finalAns == 3) {
      System.out.println("You tied!");
    }
  }
}
