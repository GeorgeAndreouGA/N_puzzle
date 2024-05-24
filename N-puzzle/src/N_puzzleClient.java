import java.util.Scanner;

/**
 * The N_puzzleClient class provides options for interacting with an N-puzzle game.
 * Users can choose to play the puzzle interactively or let a bot solve it automatically.
 * The puzzle must be solved by placing '0' in the bottom right corner and arranging
 * the other numbers in increasing order.In the args array give N(the length of the array)
 * and d must be 1.
 * 
 * <p>Author: Andreou Giorgos</p>
 * <p>Written: 23/10/2023</p>
 * <p>Last updated: 27/10/2023</p>
 * 
 * <p>Compilation: javac N_puzzleClient.java</p>
 * <p>Execution: java N_puzzleClient <input></p>
 *
 * <p>Options:</p>
 * <ul>
 *   <li>Option 1: Play and try to solve the puzzle interactively.</li>
 *   <li>Option 2: Let the bot solve the shuffled puzzle with specified tries and moves.</li>
 * </ul>
 */
public class N_puzzleClient {
    
    /**
     * Main method to start the N-puzzle game.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner give = new Scanner(System.in);
        int N = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int[][] copyVersion = new int[N][N];
        N_puzzleLibrary.options();
        System.out.print("Choose Option:");
        int epilogi = give.nextInt();
        if (epilogi == 0)
            return;
        System.out.println("*******************************");

        if (epilogi == 1&& d==1) {
            System.out.print("Give level of difficulty:");
            int k = give.nextInt();
            int[][] solvedPin = N_puzzleLibrary.initializePuzzle(N);

            for (int i = 0; i < solvedPin.length; i++)
                for (int j = 0; j < solvedPin[i].length; j++)
                    copyVersion[i][j] = solvedPin[i][j];

            N_puzzleLibrary.shufflePuzzle(solvedPin, k);
            N_puzzleLibrary.displayPuzzle(solvedPin,d);
            N_puzzleLibrary.isSolution(solvedPin, copyVersion,d);
            give.close();
        } else if (epilogi == 2 && d == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Dwse kmin: ");
            int kmin = scan.nextInt();
            System.out.print("Dwse kmax: ");
            int kmax = scan.nextInt();
            System.out.print("Dwse p: ");
            int p = scan.nextInt();
            System.out.print("Dwse q: ");
            int q = scan.nextInt();
            int[][] shuffeld = new int[N][N];
            scan.close();
            while (kmin <= kmax) {
                int tries = 0;
                int movesRemaining = 0;
                int wins = 0, allMoves = 0, sumMoves = 0;
                int[][] solvedPin = N_puzzleLibrary.initializePuzzle(N);

                for (int i = 0; i < solvedPin.length; i++)
                    for (int j = 0; j < solvedPin[i].length; j++)
                        copyVersion[i][j] = solvedPin[i][j];

                N_puzzleLibrary.shufflePuzzle(solvedPin, kmin);

                while (tries < p) {
                    N_puzzleLibrary.initializePuzzleΚ(solvedPin, shuffeld);
                    while (movesRemaining < q) {
                        N_puzzleLibrary.solvePuzzleForBot(shuffeld);
                        allMoves++;
                        if (N_puzzleLibrary.didYouSolvedIt(copyVersion, shuffeld)) {
                            wins++;
                            sumMoves += allMoves;
                            break;
                        } else
                            movesRemaining++;
                    }
                    allMoves = 0;
                    movesRemaining = 0;
                    tries++;
                }
                if (wins==0) {
                    System.out.print("Gia k= " + kmin + " ekane meso oro kiniseon ");
                    System.out.print("NaN");
                    System.out.print(" kai nikise ");
                    System.out.printf("%.2f", (double) wins * 100 / q);
                    System.out.print("% fores");
                } else {
                    System.out.print("Gia k= " + kmin + " ekane meso oro kiniseon ");
                    System.out.printf("%.2f", (double) sumMoves / wins);
                    System.out.print(" kai nikise ");
                    System.out.printf("%.2f", (double) wins * 100 / q);
                    System.out.print("% fores");
                }
                kmin++;
                System.out.println();
            }
        }
    }
}
