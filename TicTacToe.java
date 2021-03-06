public class TicTacToe
{
  // declare instance variables below
  public char[][] board;

  //no-arguement constructor
  public TicTacToe()
  {
    board = new char[3][3];
    for(int r=0; r<3; r++){
      for(int c=0; c<3; c++){
        board[r][c] = ' ';
      }
    }
  }

  // prints
  public String print(int r)
  {
    return board[r][0] + " " + board[r][1] + " " + board[r][2] + " | ";
  }

  public void play(int xcoor, int ycoor, int playernum)
  {
    if(playernum == 0){
      board[xcoor][ycoor] = 'x';
    }
    else if (playernum == 1){
      board[xcoor][ycoor] = 'o';
    }
    else{
      board[xcoor][ycoor] = '~';
    }
  }
  
  // checks for win
  public boolean checkWin(){
    for(int i=0; i<3; i++){
      //check row
      if(board[0][i] != ' ' && (board[0][i]==board[1][i] && board[1][i]==board[2][i]))
        return true;
      //check column
      else if(board[i][0] != ' ' && (board[i][0]==board[i][1] && board[i][1]==board[i][2]))
        return true;
    }

    //check diagonals
    if(board[1][1] != ' '){
      if(board[1][1]==board[0][0] && board[1][1]==board[2][2])
        return true;
      else if(board[1][1]==board[0][2] && board[1][1]==board[2][0])
        return true;
    }
    return false;
  }

  public boolean checkTie(){
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        if(board[i][j] == ' ')
          return false;
      }
    }
    return true;
  }

  public String gameOver(int currentPlayer, String player1, String player2){
    if(checkTie())
      return "Game over: tie!";
    else if(currentPlayer==1)
      return "Game over: " + player1 + " (x) wins!";
    else
      return "Game over: " + player2 + " (o) wins!";
  }
}
