import java.util.Scanner;

public class domuzOyun {
	static int dice1;
	static int dice2;
	static Scanner userInput = new Scanner(System.in);
	static boolean humanTurn = true;
	static boolean computerTurn = true;
	static int humanTurnPoints = 0;
	static int computerTurnPoints = 0;
	static int humanTotalPoints = 0;
	static int computerTotalPoints = 0;
	static int newDice;
	private static Scanner keyboard;
	
	public static void roll() {// rolls the dice
		dice1 = (int) (Math.random()*6) + 1;
		dice2 = (int) (Math.random()*6) + 1;
		
			
	}
	public static void theChoice() {// the prompt for the plater to choose between holding or rolling again
		System.out.println("You can chose to hold or roll again.");
		System.out.println("To roll again press 'r' or 'h' to hold.");
		keyboard = new Scanner(System.in);
		String choice = keyboard.nextLine();

		if (choice.equalsIgnoreCase("R")) {
			System.out.println("You get to roll again.");
			roll();
	}
		else if (!choice.equalsIgnoreCase("H"))  {
				System.out.println("You have to press 'r' to continue");
				theChoice();
	}
		else if (choice.equalsIgnoreCase("H")) {
			System.out.println("You pressed 'h' decided to end your turn by holding.");
			System.out.println("Your total score is: " + humanTotalPoints);
			humanTurnZero();
			computerGame();
		}
		
	}
	public static int humanTurnScore() {// calculates the turn score 
		humanTurnPoints = dice1 + dice2+ humanTurnPoints;
		System.out.println("You have rolled " + dice1 + " and " + dice2);
		
		System.out.println("You have accumulated " + humanTurnPoints + " points this turn");
		return humanTurnPoints;
	}
	public static int computerTurnScore() {
		computerTurnPoints = dice1 + dice2 + computerTurnPoints;
		System.out.println("Computer has rolled " + dice1 + " and " + dice2);
		
		System.out.println("Computer has accumulated " + computerTurnPoints + " points this turn");
		return computerTurnPoints;
		
	}
	public static void humanTurnZero() {// sets the turn score to 0
		humanTurnPoints = 0;
	}
	public static void computerTurnZero() {
		computerTurnPoints = 0;
	}
	public static int humanGame() {// where the player plays the game
		do {
			roll();
			if((dice1 == 6)||(dice2 == 6)){// if you roll a six.
				System.out.println("You rolled a 6 and have lost your turn.");
				System.out.println("Your turn score is set to 0");
				System.out.println("The computer's total score is: " + computerTotalPoints);
				humanTurnZero();
				computerGame();

			}else if ((dice1 == 6) && (dice2 == 6)){// if you roll two sixes.
				System.out.println("You rolled two sixes and your total score is set to 0");
				System.out.println("You have lost your turn");
				humanTotalPoints = 0;


			}else if (humanTotalPoints >= 100) {// if you score over 100.
				System.out.println("You rolled: " + dice1 + " and " + dice2);
				System.out.println("Your total score is: " + humanTotalPoints);
				System.out.println("Congratulations, you win!");
				System.exit(0);

			}else if (dice1 == dice2){// if you roll a double.
				newDice = (dice1+dice2)*2;
				humanTotalPoints = newDice + humanTotalPoints;
				System.out.println("You rolled " + dice1 + " and " + dice2);
				System.out.println("You rolled doubles!");
				System.out.println("You will receive double the points!");
				System.out.println("Your total score is: " + humanTotalPoints);
				theChoice();


			}else {
				humanTotalPoints = dice1 + dice2 + humanTotalPoints;
				humanTurnScore();
				System.out.println("Your total score is: " + humanTotalPoints);
				System.out.println("The computer's total score is: " + computerTotalPoints);
				theChoice();

			}
		} while (humanTurn);// this boolean returns the dices.

		return dice1 + dice2;
	}
	public static int computerGame() {
		do {
			roll();
			if((dice1 == 6)||(dice2 == 6)){// if you roll a six.
				System.out.println("Computer rolled a 6 and has lost its turn.");
				System.out.println("Computer turn score is set to 0");
				computerTurnZero();
				System.out.println("The computer's total score is: " + computerTotalPoints);
				humanGame();

			}else if ((dice1 == 6) && (dice2 == 6)){// if you roll two sixes.
				System.out.println("Computer rolled two sixes and your total score is set to 0");
				System.out.println("Computer has lost its turn");
				computerTotalPoints = 0;


			}else if (computerTotalPoints >= 100) {// if you score over 100.
				System.out.println("Computer rolled: " + dice1 + " and " + dice2);
				System.out.println("Computer's total score is: " + humanTotalPoints);
				System.out.println("Congratulations Computer! you win!");
				System.exit(0);

			}else if (dice1 == dice2){// if you roll a double.
				newDice = (dice1+dice2)*2;
				computerTotalPoints = newDice + computerTotalPoints;
				System.out.println("Computer rolled " + dice1 + " and " + dice2);
				System.out.println("Computer rolled doubles!");
				System.out.println("Computer will receive double the points!");
				System.out.println("Computer's total score is: " + humanTotalPoints);
				computerGame();


			}else {
				computerTotalPoints = dice1 + dice2 + computerTotalPoints;
				computerTurnScore();
				System.out.println("Computer's total score is: " + computerTotalPoints);
				System.out.println("The computer's total score is: " + computerTotalPoints);
				computerGame();

			}if(computerTurnPoints >= 20) {
				System.out.println("Computer scored " + computerTurnPoints + " its turn ends now.");
				System.out.println("Now it is your turn to roll!");
				humanGame();
		}
		}while (computerTurn);// this boolean returns the dices.
		
		return dice1 + dice2;
		
	}
	
	
	public domuzOyun(){
		
		try {
			System.out.println("Welcome to Pig Game!");
			System.out.println("You will be playing against a computer and the first player to reach "
					+ "100 points or more wins the whole game");
			System.out.println("Do you understand the game? Please say yes or no.");
			String firstChoice = userInput.nextLine();
			if(!firstChoice.equalsIgnoreCase("YES")) {
				System.out.println("That is okay too, Please come back when you have a brain.");	
			}
			System.out.println("If you are ready to play please press 'r'");
			String choice = userInput.nextLine();
			if(choice.equalsIgnoreCase("R")){
				humanGame();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
}
	public static void main(String[] args) {
		new domuzOyun();
		
		
	}
		
}	
