import java.util.Scanner;
import java.io.*;
class Main 
{
  //private variables
  private static int X=-1, Y=-1, currentPlayer=0, x, y;
  private static TicTacToe ultBoard = new TicTacToe();
  private static TicTacToe[][] t = new TicTacToe[3][3];
  private static Scanner sc;
  private static String player1, player2;

  public static void main(String[] args) throws FileNotFoundException 
  {
    //testing cases
    //sc = new Scanner(new File("tie.dat"));
    sc = new Scanner(System.in);
    
    // print intro
    for(int i=0; i< 50; i++)
      System.out.print('*');
    System.out.println("\n        Welcome to Ultimate TicTacToe!");
    for(int i=0; i< 50; i++)
      System.out.print('*');
    System.out.println();
    System.out.println("What is the 1st player's name?");
    player1 = sc.nextLine();
    System.out.println("What is the 2nd player's name?");
    player2 = sc.nextLine();
    System.out.println("\n"+ player1 +" will be x. "+ player2 +" will be o. Good luck!\n");

    //creating the boards
    for(int r=0; r<3; r++){
      for(int c=0; c<3; c++){
        t[r][c] = new TicTacToe();
      }
    }
    print();

    //playing the game
    while(!ultBoard.checkWin() && !ultBoard.checkTie()){
      //print info on whose turn it is
      //print where they have to play
      if(currentPlayer == 0)
        System.out.println("It is " +player1+ "'s turn: x");
      else
        System.out.println("It is " +player2+ "'s turn: o");
      
      //record input
      validateInput(); X= x%3; Y = y%3;
      System.out.println("ultimate row: " + X);
      System.out.println("ultimate col: " + Y);
      t[x/3][y/3].play(x%3, y%3, currentPlayer);
      //check for wins
      if(t[x/3][y/3].checkWin()){
        ultBoard.play(x/3, y/3, currentPlayer);
      }
      else if(t[x/3][y/3].checkTie()){
        ultBoard.play(x/3, y/3, -1);
      }
      //update values
      //updateBounds(x%3, y%3);
      if(ultBoard.board[X][Y] != ' '){
        X = -1;
      }
      currentPlayer = (currentPlayer+1)%2;
      print();
    }
    sc.close();
    System.out.println(ultBoard.gameOver(currentPlayer, player1, player2));
    
  }
  
  public static void print(){
    //detailed board
    System.out.println("\n    0 1 2   3 4 5   6 7 8");
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

  //verifyng that the input is a number 0-8
  public static int verifyInput(){
    int x = -1;
    while(x == -1){
      String input = sc.next();
      try{
        x = Integer.parseInt(input);
        if(x<0||x>8){
          System.out.println("Re-enter a number between 0 and 8 inclusive: ");
          x = -1;
        }
      }
      catch(NumberFormatException e){
        System.out.print("Not a valid number. Please enter a number: ");
      }
    }
    return x;
  }

  //validating that the numbers are in an open spot
  public static void validateInput(){
    boolean pass = false;
    while(!pass){
      System.out.print("Enter row number: ");
      x = verifyInput();
      System.out.println(x);
      System.out.print("Enter column: ");
      y = verifyInput();
      System.out.println(y);

      if(ultBoard.board[x/3][y/3] != ' '){
        System.out.println("The spot you have chosen is in a square that already has a win/tie. Please re-enter. ");
      }
      else if(!(X==-1 || (x/3 == X && y/3 == Y))){
        System.out.println("The spot you have chosen is in the wrong area. Please re-enter. ");
      }
      else if(!(t[x/3][y/3].board[x%3][y%3] == ' ')){
        System.out.println("The spot is already taken. Please re-enter. ");
      }
      else{
        pass = true;
      }
    }
  }
}
