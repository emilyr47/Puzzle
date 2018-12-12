public class Puzzle {
    // Emily Raper, 5480576, raper003@umn.edu
    // 15-Puzzle Implementation

// from Project 2
  public static int randomInt(int min, int max) {
      return (int)((Math.random()*((max-min)+1))+min);
  }  // randomInt

  // from lab
  static void initSolution(int[][] p) {
      // initialize the array p to a completed 15-puzzle
          int row, col;
          for (row = 0; row < p.length; row++)
              for (col = 0; col < p[row].length; col++)  {
                  p[row][col] = row * p[row].length + col + 1;
              }
          p[p.length - 1][p[p.length - 1].length - 1] = 0;

      }  // initToSolve

  public static void initializer(int[][] p) {
      // initialize puzzle to a randomly scrambled puzzle

      // *** my code goes here ***

      // declarations
        int row1;
        int col1;
        int row2;
        int col2;

    initSolution(p);

  for (int i = 0; i < 7; i++) {
      row1 = randomInt(0 , 3);
      col1 = randomInt(0 , 3);
      row2 = randomInt(0 , 3);
      col2 = randomInt(0 , 3);

      swap(p, row1, col1, row2, col2);

    } // for

  }  // initializer

  // from Lab
  static void printPuzzle(int[][] p) {
      // print out the puzzle
          int row, col;
          System.out.println();
          for (row = 0; row < p.length; row++) {
              for (col = 0; col < p[row].length; col++)
                  System.out.printf("%4d   ", p[row][col]);
              System.out.println();
          }
          System.out.println();
      }  // printPuzzle

  // from Lab
  public static boolean puzzleEqual(int[][] puzzle, int[][] anotherPuzzle) {
      // returns true if both puzzles contain exactly the same information
      // returns false otherwise
      for (int row = 0; row < puzzle.length; row++)
          for (int col = 0; col < puzzle[row].length; col++)
              if (puzzle[row][col] != anotherPuzzle[row][col])
                return false;
      return true;
  }  // puzzleEqual

  public static void swap(int[][] p, int row1, int col1, int row2, int col2) {
      // swaps elements at p[row1][col1] and p[row2][col2]

      int temp;

      temp = p[row1][col1];
      p[row1][col1] = p[row2][col2];
      p[row2][col2] = temp;
  }  // swap


  public static boolean swapper(int[][] p, int n) {
      // swaps tile n with the open spot in puzzle p
      // verifies that n is in range and adjacent to open spot
      // returns true if swap successful, false otherwise

      int row, col;
      if (n < 1 || n > 15)
        return false;
      for (row = 0; row < p.length; row++)
          for (col = 0; col < p[row].length; col++)
              if (p[row][col] == n) { // found n
                if (row + 1 < p.length && p[row + 1][col] == 0)  {
                    swap(p, row, col, row + 1, col);
                    return true;
                  }
                else if (row > 0 && p[row - 1][col] == 0) {
                         swap(p, row, col, row - 1, col);
                         return true;
                       }
                else if (col + 1 < p[row].length && p[row][col + 1] == 0) {
                         swap(p, row, col, row, col + 1);
                         return true;
                       }
                else if (col > 0 && p[row][col - 1] == 0) {
                         swap(p, row, col, row, col - 1);
                         return true;
                       }
                } // found n
      return false;
  }  // swapper

  public static void playLoop(int[][] p, int[][] sol) {

    // *** my code goes here ***

    printPuzzle(p);

    System.out.println ("Please enter a number between 1 and 15 to move the tile or enter -1 to quit");

    while (puzzleEqual (p, sol)== false) {
      System.out.println("Enter tile to move:");
      int n = TextIO.getInt();
      printPuzzle(p);


    if (n == -1) {
      System.out.println("Bye");
      return;
      } // if

    else {
      swapper (p, n);
    } // else

  } // while

  if (puzzleEqual(p, sol)==true) {
    System.out.println("Congratulations, you solved the puzzle!");
    return;
  } // if

} // playLoop

  // given
  public static void main(String[] args) {
      final int NROWS = 4;
      final int NCOLS = 4;

      int[][] puzzle = new int[NROWS][NCOLS];
      int[][] solution = new int[NROWS][NCOLS];

      initSolution(solution);
      initializer(puzzle);

      System.out.println("\nWelcome to the 15-Puzzle");

      playLoop(puzzle, solution);

  }  // main

}  // Project 3
