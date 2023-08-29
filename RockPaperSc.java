/**
 * Name: Elena Pashkova, N01587121;
 */

package com.humber.java.assignment1;

//importing 
import java.util.Scanner;
import java.util.Random;


public class RockPaperSc {
		
//		default scores values
	    private static int playerScore = 0;
	    private static int computerScore = 0;

	    public static void main(String[] args) {
	    	
//	    	promting input with scanner
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Welcome to Rock Paper Scissors!");
	        System.out.print("Enter your name: ");
	        String playerName = scanner.nextLine();

//	        default name for the opponent
	        String computerName = "Jiffy";

//	        looping starts
	        while (true) {
	            System.out.println("\n----- New Turn -----");
	            System.out.println("Player: " + playerName + " Score: " + playerScore);
	            System.out.println("Computer: " + computerName + " Score: " + computerScore);

	            System.out.print("\n" + playerName + ", choose (R)ock, (P)aper, (S)cissors, or (Q)uit: ");
	            String playerChoice = scanner.nextLine().toLowerCase();

	            if (playerChoice.equals("q")) {
	                break;
	            }

//	            error message prompt
	            if (!playerChoice.equals("r") && !playerChoice.equals("p") && !playerChoice.equals("s")) {
	                System.err.println("Invalid choice! Please enter R, P, S, or Q.");
	                continue;
	            }

	            String computerChoice = generateComputerChoice();

	            System.out.println("\n" + playerName + " chose: " + getChoiceName(playerChoice));
	            System.out.println(computerName + " chose: " + getChoiceName(computerChoice));

	            String result = determineWinner(playerChoice, computerChoice);

	            System.out.println("\n" + result);
	        }
	        //summary of the game
	        System.out.println("\n----- Final Score -----");
	        System.out.println("Player: " + playerName + " Score: " + playerScore);
	        System.out.println("Computer: " + computerName + " Score: " + computerScore);
	        System.out.println(getOverallWinner(playerName, computerName));
	    }

//	    opponent pc choises generator
	    private static String generateComputerChoice() {
	        Random random = new Random();
	        int choice = random.nextInt(3) + 1;

	        switch (choice) {
	            case 1:
	                return "r";
	            case 2:
	                return "p";
	            case 3:
	                return "s";
	            default:
	                return "";
	        }
	    }

//	    choises naming
	    private static String getChoiceName(String choice) {
	        switch (choice) {
	            case "r":
	                return "Rock";
	            case "p":
	                return "Paper";
	            case "s":
	                return "Scissors";
	            default:
	                return "";
	        }
	    }

//	    final message assembly
	    private static String determineWinner(String playerChoice, String computerChoice) {
//		    if tie
	        if (playerChoice.equals(computerChoice)) {
	            return "It's a tie!";
	        }

//	        if winner is a player
	        if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
	                (playerChoice.equals("p") && computerChoice.equals("r")) ||
	                (playerChoice.equals("s") && computerChoice.equals("p"))) {
	            playerScore++;
	            return "Congratulations, you win this round!";
	        }

	        computerScore++;
	        return "Sorry, you lose this round!";
	    }

//	    if pc winner, else tie
	    private static String getOverallWinner(String playerName, String computerName) {
	        if (playerScore > computerScore) {
	            return "Congratulations, " + playerName + " wins!";
	        } else if (computerScore > playerScore) {
	            return "Sorry, " + computerName + " wins!";
	        } else {
	            return "It's a tie! No overall winner.";
	        }
	    }
	}


