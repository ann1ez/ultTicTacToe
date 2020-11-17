import java.util.Scanner;
import java.io.*;
class Main 
{
  private static TicTacToe ultBoard = new TicTacToe();
  private static int X = -1;
  private static int Y = -1;
  private static TicTacToe[][] t = new TicTacToe[3][3];

  public static void main(String[] args) throws FileNotFoundException 
  {
    // print intro
    for(int i=0; i< 50; i++)
      System.out.print('*');
    System.out.println("\n        Welcome to Ultimate TicTacToe!");
    for(int i=0; i< 50; i++)
      System.out.print('*');
    System.out.println("\nPlayer 1 will be x. Player 2 will be o. Good luck!\n");

    // Uncomment below to test cases
    //Scanner sc = new Scanner(new File("winX.dat"));
    Scanner sc = new Scanner(System.in);
    int currentPlayer = 0;

    //creating the boards
    for(int r=0; r<3; r++){
      for(int c=0; c<3; c++){
        t[r][c] = new TicTacToe();
      }
    }
    
    print();
    while(!ultBoard.checkWin()){
      int x = sc.nextInt();
      int y = sc.nextInt();
      if(X==-1 || (x/3 == X && y/3 == Y)){
        t[x/3][y/3].play(x%3, y%3, currentPlayer);
        updateBounds(x%3, y%3);
        currentPlayer = (currentPlayer+1)%2;
      }
      print();
    }
    sc.close();
  }
  
  public static void print(){
    //detailed board
    System.out.println("    0 1 2   3 4 5   6 7 8");
    System.out.println("  - - - - - - - - - - - - -");

    for(int row = 0; row<9;){
      for(int i=0; i<3; i++){
        System.out.print(row + " | ");
        System.out.print(t[row/3][0].print(i));
        System.out.print(t[row/3][1].print(i));
        System.out.println(t[row/3][2].print(i));
        row++;
      }
      System.out.println("  - - - - - - - - - - - - -");
    }
    
    //ultBoard
    System.out.println("Ultimate grid:");
    System.out.println("- - - - -");
    for(int row = 0; row<3; row++){
      System.out.println("| " + ultBoard.print(row));
    }
    System.out.println("- - - - -");
  }

  public static boolean validateInput(int x, int y){
    if(!(X==-1 || (x/3 == X && y/3 == Y)))
      return false;
    if(t[x/3][y/3].board(x%3, y%3)){

    }
  }

  public static void updateBounds(int x, int y){
    if(ultBoard.board[x][y] == ' '){
      X = x; Y = y;
    }
    else
      X = -1;
  }

}
