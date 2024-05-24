import java.util.Scanner;
import java.awt.Color;
public class N_puzzleLibrary {
	public static void options() {
		System.out.println("+-------------------------+");
		System.out.print("|");
		System.out.print("1. Interactive play");
		System.out.printf("%7s\n", "|");
		System.out.print("|");
		System.out.print("2. Automatic play "); // This method simply displays the available game options, such as
												// interactive play, automatic play, and exit.
		System.out.printf("%8s\n", "|");
		System.out.print("|");
		System.out.print("3. Exit ");
		System.out.printf("%18s\n", "|");
		System.out.println("+-------------------------+");
	}

	public static int[][] initializePuzzle(int N) {
		int[][] solvedPin = new int[N][N];
		int trackNumbers = 0; // This method initializes the puzzle with numbers in the correct order, just as
								// the N-puzzle should start. The empty cell is represented by the number 0.
		for (int i = 0; i < solvedPin.length; i++)
			for (int j = 0; j < solvedPin[i].length; j++) {
				solvedPin[i][j] = trackNumbers + 1;
				trackNumbers++;
				if ((j == solvedPin.length - 1) && (i == solvedPin.length - 1))
					solvedPin[i][j] = 0;
			}
		return solvedPin;

	}
	public static void shufflePuzzle(int[][] shufflePuzze, /*
															 * The shufflePuzzle function is responsible for shuffling
															 * the N-puzzle by making a series of random moves. The goal
															 * is to scramble the puzzle pieces to create a challenging
															 * initial state for the player to solve. Here's how this
															 * function works:
															 * 
															 * The function takes two parameters:
															 * 
															 * shufflePuzze: A 2D array representing the current state
															 * of the puzzle. k: An integer representing the number of
															 * random moves to perform to shuffle the puzzle. Inside the
															 * function, there is a loop that iterates k times. This
															 * loop ensures that the puzzle is shuffled the desired
															 * number of times.
															 * 
															 * For each iteration of the loop, the function does the
															 * following:
															 * 
															 * It searches for the position of the empty cell (usually
															 * represented by the number 0) in the shufflePuzze array.
															 * This is done by iterating through the rows and columns of
															 * the puzzle. Once the empty cell's position is determined,
															 * the function generates random directions for a possible
															 * move. These directions can include moving the empty cell
															 * up, down, left, or right. The probability of choosing
															 * each direction can be different.
															 * 
															 * Based on the random direction chosen, the function
															 * attempts to move the empty cell in that direction by
															 * swapping it with a neighboring tile. This effectively
															 * simulates a random move in the puzzle.
															 * 
															 * After making the move, the function repeats the process
															 * for the specified number of iterations (k times). Each
															 * time, a new random move is generated and executed.
															 * 
															 * By repeating this process, the shufflePuzzle function
															 * shuffles the puzzle in a random and unpredictable way,
															 * creating a starting point for the game where the tiles
															 * are in a random order. The degree of shuffle is
															 * determined by the value of k, with larger values of k
															 * leading to a more shuffled puzzle. The player then needs
															 * to solve the puzzle by rearranging the tiles to reach the
															 * sorted state, which is the ultimate objective of the
															 * N-puzzle game.
															 */
			int k) {

		int arithmosNekatomatos = 0, j0 = 0, i0 = 0;
		while (arithmosNekatomatos < k) {
			double random = Math.random();
			for (int i = 0; i < shufflePuzze.length; i++)
				for (int j = 0; j < shufflePuzze[i].length; j++)
					if (shufflePuzze[i][j] == 0) {
						i0 = i;
						j0 = j;
					}
			String randomR = "", randomL = "", randomU = "", randomD = "";

			if (j0 + 1 >= 0 && j0 + 1 <= shufflePuzze.length - 1)
				randomR = "random can move right";
			if (j0 - 1 >= 0 && j0 - 1 <= shufflePuzze.length - 1)
				randomL = "random can move left";
			if (i0 - 1 >= 0 && i0 - 1 <= shufflePuzze.length - 1)
				randomU = "random can move up";
			if (i0 + 1 >= 0 && i0 + 1 <= shufflePuzze.length - 1)
				randomD = "random can move down";
			int temp = 0;
			if (randomL.equals("random can move left") && randomU.equals("random can move up")) {
				if (random >= 0.0 && random < 0.5) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				} else if (random >= 0.5 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				}
				
			} else if (randomL.equals("random can move left") && randomU.equals("random can move up")
					&& randomR.equals("random can move right")) {
				if (random >= 0.0 && random < 0.3) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				} else if (random >= 0.3 && random < 0.6) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				}

				else if (random >= 0.6 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				}
			} else if (randomR.equals("random can move right") && randomU.equals("random can move up")) {
				if (random >= 0.0 && random < 0.5) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				} else if (random >= 0.5 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				}

			}

			else if (randomD.equals("random can move down") && randomU.equals("random can move up")
					&& randomR.equals("random can move right")) {
				if (random >= 0.0 && random < 0.3) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				} else if (random >= 0.3 && random < 0.6) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				}

				else if (random >= 0.6 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			} else if (randomR.equals("random can move right") && randomD.equals("random can move down")) {
				if (random >= 0.0 && random < 0.5) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				} else if (random >= 0.5 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			} else if (randomD.equals("random can move down") && randomL.equals("random can move left")
					&& randomR.equals("random can move right")) {
				if (random >= 0.0 && random < 0.3) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				} else if (random >= 0.3 && random < 0.6) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				} else if (random >= 0.6 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			} else if (randomL.equals("random can move left") && randomD.equals("random can move down")) {
				if (random >= 0.0 && random < 0.5) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				}

				else if (random >= 0.5 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			} else if (randomD.equals("random can move down") && randomL.equals("random can move left")
					&& randomU.equals("random can move up")) {
				if (random >= 0.0 && random < 0.3) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				}

				else if (random >= 0.3 && random < 0.6) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				} else if (random >= 0.6 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			}

			else if (randomD.equals("random can move down") && randomL.equals("random can move left")
					&& randomU.equals("random can move up") && randomR.equals("random can move right")) {
				if (random >= 0.0 && random < 0.25) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
					shufflePuzze[i0][j0 - 1] = temp;
				} else if (random >= 0.25 && random < 0.5) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
					shufflePuzze[i0 - 1][j0] = temp;
				} else if (random >= 0.5 && random < 0.75) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
					shufflePuzze[i0][j0 + 1] = temp;
				} else if (random >= 0.75 && random < 1) {
					temp = shufflePuzze[i0][j0];
					shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
					shufflePuzze[i0 + 1][j0] = temp;
				}
			}

			arithmosNekatomatos++;

		} // while
	}

	public static void isSolution(int[][] shufflePuzze, int[][] copyVersion,int d) {
		boolean found = false;
		int temps = 0;
		while (found == false) { // This method checks if the puzzle is solved. The user is required to make
									// moves until they find the correct solution.
			temps++;
			System.out.print("Give " + temps + " Move:");
			found = play(shufflePuzze, copyVersion,d);

		}
	}

	public static boolean play(int[][] shufflePuzze, /*
														 * Method Purpose:
														 * 
														 * The play method is responsible for managing a user's moves
														 * and checking whether a move leads to a solution in the
														 * N-puzzle game. Parameters:
														 * 
														 * shufflePuzze: This parameter represents the current state of
														 * the shuffled puzzle, with the grid of numbers. copyVersion:
														 * This parameter is a copy of the original, unshuffled puzzle.
														 * It's used to compare the current puzzle state with the
														 * original to determine if the puzzle has been solved.
														 * Functionality:
														 * 
														 * The method starts by calling the isValidMove(shufflePuzze)
														 * method, which checks if the user's desired move is valid. It
														 * returns a string indicating whether the move is feasible
														 * ("good to go") or not ("not good to go").
														 * 
														 * If the move is valid, the method proceeds to execute the move
														 * based on the user's input. For example, if the user wants to
														 * move a tile to the right, the method swaps the positions of
														 * the empty space (0) and the tile to the right of it in the
														 * shufflePuzze array. This simulates the user's move.
														 * 
														 * After executing the move, the method displays the updated
														 * puzzle grid using the displayPuzzle(shufflePuzze) method, so
														 * the user can see the current state of the puzzle.
														 * 
														 * The method also checks whether the current puzzle state
														 * matches the original, sorted puzzle stored in copyVersion. If
														 * they match, it means the puzzle has been solved, and it
														 * prints a "Congratulations, puzzle solved!" message.
														 * 
														 * Finally, the method returns a boolean value (didYouFindIt)
														 * that indicates whether the puzzle has been solved. If
														 * didYouFindIt is true, it means the puzzle is solved. If
														 * false, the puzzle is not yet solved, and the user can
														 * continue making moves.
														 * 
														 * Usage:
														 * 
														 * This method is called in the isSolution method, where the
														 * game loop iterates until a solution is found by repeatedly
														 * calling play with user moves. In summary, the play method
														 * manages the user's moves, checks their validity, updates the
														 * puzzle state, and determines whether the puzzle has been
														 * solved or not. It is a key part of the interactive gameplay
														 * in the N-puzzle game.
														 */

			int[][] copyVersion,int d) {
		String move = isValidMove(shufflePuzze);
		int temp = 0, i0 = 0, j0 = 0;
		boolean didYouFindIt = true;
		for (int i = 0; i < shufflePuzze.length; i++)
			for (int j = 0; j < shufflePuzze[i].length; j++)
				if (shufflePuzze[i][j] == 0) {
					i0 = i;
					j0 = j;
				}
		if (move.equals("good to go r")) {
			temp = shufflePuzze[i0][j0];
			shufflePuzze[i0][j0] = shufflePuzze[i0][j0 + 1];
			shufflePuzze[i0][j0 + 1] = temp;
		} else if (move.equals("good to go l")) {
			temp = shufflePuzze[i0][j0];
			shufflePuzze[i0][j0] = shufflePuzze[i0][j0 - 1];
			shufflePuzze[i0][j0 - 1] = temp;
		} else if (move.equals("good to go u")) {
			temp = shufflePuzze[i0][j0];
			shufflePuzze[i0][j0] = shufflePuzze[i0 - 1][j0];
			shufflePuzze[i0 - 1][j0] = temp;
		} else if (move.equals("good to go d")) {
			temp = shufflePuzze[i0][j0];
			shufflePuzze[i0][j0] = shufflePuzze[i0 + 1][j0];
			shufflePuzze[i0 + 1][j0] = temp;
		} else if (move.equals("not good to go r"))
			System.out.println("Can't go right!");

		else if (move.equals("not good to go l"))
			System.out.println("Can't go left!");

		else if (move.equals("not good to go u"))
			System.out.println("Can't go up!");

		else if (move.equals("not good to go d"))
			System.out.println("Can't go right down!");

		else if (move.equals("i want to stop")) {
			System.out.print("Shame on you!");

			return didYouFindIt;
		}
		displayPuzzle(shufflePuzze,d);

		for (int i = 0; i < shufflePuzze.length; i++)
			for (int j = 0; j < shufflePuzze[i].length; j++)
				if (shufflePuzze[i][j] != copyVersion[i][j])
					didYouFindIt = false;

		if (didYouFindIt)
			System.out.print("Congratulations, puzzle solved!!");

		return didYouFindIt;
	}

	public static String isValidMove(
			int[][] shufflePuzze) { /**
									 * isValidMove method checks if a user's move is valid and returns a string
									 * indicating the validity of the move. Here's how it works:
									 * 
									 * It first determines the current position (i0, j0) of the empty cell
									 * (represented by 0) within the puzzle grid.
									 * 
									 * It reads the user's input command using the getUserCommand method. The user
									 * typically inputs a command like "r" for right, "l" for left, "u" for up, "d"
									 * for down, or "e" to exit the game.
									 * 
									 * Depending on the user's input, the method checks whether the requested move
									 * is possible. It verifies that the move doesn't take the empty cell out of
									 * bounds of the puzzle grid. If the move is valid, it sets moveGoodToGo to
									 * "good to go" along with the direction ("r," "l," "u," or "d"). If the move is
									 * not valid, it sets moveGoodToGo to "not good to go."
									 * 
									 * If the user enters "e," it indicates the intention to stop the game.
									 * 
									 * Finally, the method returns moveGoodToGo, which is a string that indicates
									 * whether the user's move is feasible ("good to go") or not ("not good to go").
									 * This information is used in the play method to determine whether the user's
									 * move is allowed.
									 */
		int i0 = 0, j0 = 0;
		String moveGoodToGo = "";
		for (int i = 0; i < shufflePuzze.length; i++)
			for (int j = 0; j < shufflePuzze[i].length; j++)
				if (shufflePuzze[i][j] == 0) {
					i0 = i;
					j0 = j;
				}
		String xaraktiras = getUserCommand();
		if (xaraktiras.equals("r")) {
			if (j0 + 1 >= 0 && j0 + 1 <= shufflePuzze.length - 1)
				moveGoodToGo = "good to go r";
			else
				moveGoodToGo = "not good to go r";
		} else if (xaraktiras.equals("l")) {
			if (j0 - 1 >= 0 && j0 - 1 <= shufflePuzze.length - 1)
				moveGoodToGo = "good to go l";
			else
				moveGoodToGo = "not good to go l";
		} else if (xaraktiras.equals("u")) {
			if (i0 - 1 >= 0 && i0 - 1 <= shufflePuzze.length - 1)
				moveGoodToGo = "good to go u";
			else
				moveGoodToGo = "not good to go u";
		} else if (xaraktiras.equals("d")) {
			if (i0 + 1 >= 0 && i0 + 1 <= shufflePuzze.length - 1)
				moveGoodToGo = "good to go d";
			else
				moveGoodToGo = "not good to go d";
		} else if (xaraktiras.equals("e"))
			moveGoodToGo = "i want to stop";

		return moveGoodToGo;
	}

	public static void displayPuzzle(int[][] shufflePuzze,int d) { // This method displays the current state of the puzzle in
						if(d==1) 										// the terminal.
		        xorisGraffika(shufflePuzze);
						else if(d==2) 
							meGraffika(shufflePuzze);
						
	}
		public static void 	xorisGraffika(int[][] shufflePuzze) {
			
			System.out.println("*******************************");
			for (int i = 0; i < shufflePuzze.length; i++) {

				for (int p = 0; p < shufflePuzze.length; p++) {

					System.out.print("+-----");
					if (p == shufflePuzze.length - 1)
						System.out.print("+");
				}
				System.out.println();

				for (int j = 0; j < shufflePuzze[i].length; j++) {
					if (shufflePuzze[i][j] >= 0 && shufflePuzze[i][j] <= 9)
						System.out.print("!" + "  " + shufflePuzze[i][j] + "  ");
					else if (shufflePuzze[i][j] >= 10 && shufflePuzze[i][j] <= 99)
						System.out.print("!" + " " + shufflePuzze[i][j] + "  ");
					else if (shufflePuzze[i][j] >= 100 && shufflePuzze[i][j] <= 999)
						System.out.print("! " + shufflePuzze[i][j] + " ");
					else if (shufflePuzze[i][j] >= 1000 && shufflePuzze[i][j] <= 9999)
						System.out.print("!" + shufflePuzze[i][j] + " ");

					if (j == shufflePuzze.length - 1)
						System.out.print("!");
				}
				System.out.println();

			}
			for (int p = 0; p < shufflePuzze.length; p++) {
				System.out.print("+-----");
				if (p == shufflePuzze.length - 1)
					System.out.println("+");
			}

		}
		public static void meGraffika(int[][] shufflePuzze) {
			
 			        StdDraw.setCanvasSize(800, 600);
 			        StdDraw.clear(Color.BLACK);
 			       StdDraw.setPenColor(Color.BLUE);
			        StdDraw.setXscale(-1,shufflePuzze.length+1);
			        StdDraw.setYscale(-1, shufflePuzze[0].length+1);
			
			        for (int i = 0; i < shufflePuzze.length; i++) 
			            for (int j = 0; j < shufflePuzze.length; j++) {
			   
			                double x = j + 0.5;
			                double y = shufflePuzze.length - i - 0.5;
			                StdDraw.square(x, y, 0.5);
			                
			                StdDraw.text(x, y,shufflePuzze[i][j]+"");
			            }
			       
			  
			    }

	public static String getUserCommand() { /*
											 * This method is used to get user input for puzzle movement. It does the
											 * following:
											 * 
											 * It initializes a Scanner object to read input from the console. It reads
											 * a user-provided string, which is expected to be one of the following: "l"
											 * (left), "r" (right), "u" (up), "d" (down), or "e" (exit). It checks if
											 * the input is a valid move by using a while loop. If the input is not
											 * valid, it asks the user for another input until a valid one is provided.
											 * It returns the valid user move as a string.
											 */
		Scanner give = new Scanner(System.in);
		String move = give.next();
		while (!(move.equals("l")) && !(move.equals("r")) && !(move.equals("u")) && !(move.equals("d"))
				&& !(move.equals("e"))) {
			System.out.print("Wrong input give another one: ");
			move = give.next();
		}
		return move;
	}

	public static void initializePuzzleΚ(int[][] solvedPin,
			int[][] shuffeld) { /*
								 * This method is used to initialize a shuffled puzzle with the same
								 * configuration as the solved puzzle. It performs the following tasks:
								 * 
								 * It takes two 2D arrays as input: solvedPin (the solved puzzle) and shuffeld
								 * (the shuffled puzzle to be initialized). It uses nested loops to copy the
								 * values from the solvedPin array to the shuffeld array, effectively
								 * initializing the shuffled puzzle with the same initial state as the solved
								 * one.
								 */
		for (int i = 0; i < solvedPin.length; i++)
			for (int j = 0; j < solvedPin[i].length; j++)
				shuffeld[i][j] = solvedPin[i][j];
	}

	public static boolean didYouSolvedIt(int[][] copyVersion,
			int[][] shuffeld) { /*
								 * This method checks whether the puzzle has been solved. Here's how it works:
								 * 
								 * It takes two 2D arrays as input: copyVersion (the original solved puzzle) and
								 * shuffeld (the shuffled puzzle to be checked). It uses nested loops to compare
								 * the values of the two arrays. If any values differ, it returns false,
								 * indicating that the puzzle has not been solved. If all values match, it
								 * returns true, indicating that the puzzle has been solved.
								 */

		for (int i = 0; i < copyVersion.length; i++)
			for (int j = 0; j < copyVersion[i].length; j++)
				if (shuffeld[i][j] != copyVersion[i][j])
					return false;
		return true;
	}

	public static void solvePuzzleForBot(
			int[][] shufflePuzzle) { /*
										 * his method simulates a random move for a bot player in the puzzle. Here are
										 * the steps:
										 * 
										 * It finds the position of the empty cell (denoted by 0) in the shufflePuzzle
										 * array. It generates a random number to determine the direction of the move (0
										 * = up, 1 = down, 2 = left, 3 = right). It swaps the empty cell with a
										 * neighboring tile in the specified direction, simulating a random move. The
										 * method ensures that the move is within the bounds of the puzzle to prevent
										 * invalid moves.
										 */
		int i0 = 0, j0 = 0;
		for (int i = 0; i < shufflePuzzle.length; i++) {
			for (int j = 0; j < shufflePuzzle[i].length; j++) {
				if (shufflePuzzle[i][j] == 0) {
					i0 = i;
					j0 = j;
					break;
				}
			}
		}
		int randomDirection = (int) (Math.random() * 4);

		int temp = 0;

	
		if (randomDirection == 0 && i0 > 0) {
			temp = shufflePuzzle[i0][j0];
			shufflePuzzle[i0][j0] = shufflePuzzle[i0 - 1][j0];
			shufflePuzzle[i0 - 1][j0] = temp;
		} else if (randomDirection == 1 && i0 < shufflePuzzle.length - 1) {
			temp = shufflePuzzle[i0][j0];
			shufflePuzzle[i0][j0] = shufflePuzzle[i0 + 1][j0];
			shufflePuzzle[i0 + 1][j0] = temp;
		} else if (randomDirection == 2 && j0 > 0) {
			temp = shufflePuzzle[i0][j0];
			shufflePuzzle[i0][j0] = shufflePuzzle[i0][j0 - 1];
			shufflePuzzle[i0][j0 - 1] = temp;
		} else if (randomDirection == 3 && j0 < shufflePuzzle[0].length - 1) {
			temp = shufflePuzzle[i0][j0];
			shufflePuzzle[i0][j0] = shufflePuzzle[i0][j0 + 1];
			shufflePuzzle[i0][j0 + 1] = temp;
		}
	}

}
