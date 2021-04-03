import java.util.Scanner;
class Main {
   //function sets up a board that is 8 by 8
   public static char[][] setup(int dim) {
       char[][] arr = new char[dim][dim];
       for (int row = 0; row < arr.length; row++) {
           for (int col = 0; col < arr[row].length; col++) {
               arr[row][col] = '-';
           }
       }
       arr[dim / 2 - 1][dim / 2 - 1] = 'W';
       arr[dim / 2 - 1][dim / 2] = 'B';
       arr[dim / 2][dim / 2 - 1] = 'B';
       arr[dim / 2][dim / 2] = 'W';
       return(arr);
   }
   //function takes in a 2D array and displays it with spaces
   public static void display(char[][] arr) {
       String c = "";
       for (int i = 0; i < arr.length; i++) {
         c = c + " " + i;
       }
       System.out.println(" " + c);
       for (int row = 0; row < arr.length; row++) {
            String str = Integer.toString(row); // Change one thing here
           for (int col = 0; col < arr[row].length; col++) {
               str = str + " " + arr[row][col];
           }
           System.out.println(str);
       }
   }
 
   public static boolean checkDirection(char[][] board, int row, int col, char p, String direc) {
       char oppPlayer;
       if (p == 'B') {
           oppPlayer = 'W';
       } else {
           oppPlayer = 'B';
       }
       boolean seenOppPlayer = false;
       if (direc == "right") {
           //scan right right Horizontally for "W"
           for (int i = col + 1; i < board.length; i++) {
               if (board[row][i] == '-') {
                   break;
               } else if (board[row][i] == oppPlayer) {
                   seenOppPlayer = true;
               } else {
                   if (seenOppPlayer == true) {
                       return(true); 
                   } 
               }
           } 
           return(false);
       } else if (direc == "left") {
           //scans left side Horizontally for "W"
           for (int i = col - 1; i >= 0; i--) {
               if (board[row][i] == '-') {
                   break;
               } else if (board[row][i] == oppPlayer) {
                   seenOppPlayer = true;
               } else {
                   if (seenOppPlayer == true) {
                       return(true); 
                   } 
               }
           }
           return(false);
       } else if (direc == "up") {
           //Scans vertically up for "w"
           for (int i = row - 1; i >= 0; i--) {
               if (board[i][col] == '-') {
                   break;
               } else if (board[i][col] == oppPlayer) {
                   seenOppPlayer = true;
               } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   }
               }
           }
           return(false);
           //vertically down
       } else if (direc == "down") {
           for (int i = row + 1; i < board.length; i++) {
               if (board[i][col] == '-') {
                   break;
               } else if (board[i][col] == oppPlayer) {
                   seenOppPlayer = true;
               } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   }
               }
           }
           return(false);
       } else if (direc == "upRight") {
           int i = row - 1;
           int j = col + 1;
           while (i >= 0 && j < board.length) {
               if (board[i][j] == '-') {
                   break;
                   } else if (board[i][j] == oppPlayer) {
                   seenOppPlayer = true;
                   } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   } 
               }
               i--;
               j++;
           }
           return(false); 
       } else if (direc == "upLeft") {
           int i = row - 1;
           int j = col - 1;
           while (i >= 0 && j >= 0) {
             if (board[i][j] == '-') {
                   break;
             } else if (board[i][j] == oppPlayer) {
                   seenOppPlayer = true;
             } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   } 
            }
            i--;
            j--;
          }
          return(false);
       } else if (direc == "downLeft") {
           int i = row + 1;
           int j = col - 1;
           while (i < board.length && j >= 0) {
               if (board[i][j] == '-') {
                   break;
               } else if (board[i][j] == oppPlayer) {
                   seenOppPlayer = true;
               } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   } 
               }
               i++;
               j--;
           }
           return(false);
       } else if (direc == "downRight") {
           int i = row + 1;
           int j = col + 1;
           seenOppPlayer = false;
           while (i < board.length && j < board.length) {
               if (board[i][j] == '-') {
                   break;
                   } else if (board[i][j] == oppPlayer) {
                   seenOppPlayer = true;
                   } else {
                   if (seenOppPlayer == true) {
                       return(true);
                   } 
               }
               i++;
               j++;
           }
           return(false); 
       } else {
           System.out.println("Not a valid direction");
           return(false);
       }
   }
 
   //this function changes the board with Ws or Bs according to the user's input(coordinates of the array)
   public static char[][] moves(char[][] board, int row, int col, char p) {
       char oppPlayer;
       if (p == 'B') {
           oppPlayer = 'W';
       } else {
           oppPlayer = 'B';
       }
       if (checkDirection(board, row, col, p, "left") == true) {
           for (int i = col - 1; i >= 0; i--) {
               if (board[row][i] == p) {
                   break;
               } else {
                   board[row][i] = p;
               }
           }
           board[row][col] = p;
       }
       if (checkDirection(board, row, col, p, "right") == true) {
           for (int i = col + 1; i < board.length; i++) {
               if (board[row][i] == p) {
                   break;
               } else {
                   board[row][i] = p;
               }
           }
           board[row][col] = p;
       }
       if (checkDirection(board, row, col, p, "up") == true) {
           for (int i = row - 1; i < board.length; i--) {
               if (board[i][col] == p) {
                   break;
               } else {
                   board[i][col] = p;
               }
           }
           board[row][col] = p;
       }
       if (checkDirection(board, row, col, p, "down") == true) {
           for (int i = row + 1; i < board.length; i++) {
               if (board[i][col] == p) {
                   break;
               } else {
                   board[i][col] = p;
               }
           }
           board[row][col] = p;
       }
       if (checkDirection(board, row, col, p, "downRight") == true) {
           int i = row + 1;
           int j = col + 1;
           while (i < board.length && j < board.length) {
               if (board[i][j] == p) {
                 break;
               } else {
                 board[i][j] = p;
               }
               i++;
               j++;
           }
           board[row][col] = p;
       } 
       if (checkDirection(board, row, col, p, "upLeft") == true) {
           int i = row - 1;
           int j = col - 1;
           while (i >= 0 && j >= 0) {
               if (board[i][j] == p) {
                    break;
               } else {
                 board[i][j] = p;
               }
               i--;
               j--;
           }
           board[row][col] = p;
       }   
       if (checkDirection(board, row, col, p, "downLeft") == true) {
           int i = row + 1;
           int j = col - 1;
           while (i < board.length && j >= 0) {
               if (board[i][j] == p) {
                    break;
               } else {
                 board[i][j] = p;
               }
               i++;
               j--;
           }
           board[row][col] = p;
       } 
       if (checkDirection(board, row, col, p, "upRight") == true) {
           int i = row - 1;
           int j = col + 1;
           while (i >= 0 && j < board.length) {
               if (board[i][j] == p) {
                    break;
               } else {
                 board[i][j] = p;
               }
               i--;
               j++;
           }
           board[row][col] = p;
       } 
       return(board);
   }  
   //function that checks if the player's move is valid or not
   public static boolean isvalidmove(char[][] board, int row, int col, char p) {
       int boardSize = board.length;
       // If the user gives a coordinate outside the bounds, then return false
       if (row >= boardSize || col >= boardSize || row < 0 || col < 0) {
            return(false);
       }
       if (board[row][col] != '-') {
           return(false);
       }
 
       boolean boolFlag = false;
       String[] directions = {"left", "right", "up", "down", "upRight", "upLeft", "downRight", "downLeft"};
       for (int k = 0; k < directions.length; k++) {
         if (checkDirection(board, row, col, p, directions[k])) {
              boolFlag = true;
         }
       }
 
       return(boolFlag);
   }
 
   //function will determine on which player will win depending on how many "W" or "B"
   public static void win(char[][] display) {
       int W = 0;
       int B = 0;
       for (int row = 0; row < display.length; row++) {
           for (int col = 0; col < display[row].length; col++) {
               if (display[row][col] == 'W') {
                     W++;
               } else if (display[row][col] == 'B') {
                     B++;
               }
           }     
       }
       System.out.println("B has " + B);
       System.out.println("W has " + W);
       if (B < W) {
             System.out.println("W Wins");
           } else if (B > W) {
             System.out.println("B Wins");
           } else {
             System.out.println("It's a Draw");
       } 
   }
//function determines if there's a valid move or not
 public static boolean anyValidMoves(char[][] board, char p) {
   for (int row = 0; row < board.length; row++) {
     for (int col = 0; col < board[row].length; col++) {
       if (board[row][col] == '-') {
         if (isvalidmove(board, row, col, p) == true) {
              return(true);
         } 
       }
     }
   }
   return(false);
 }
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter Board Size");
       int boardSize = sc.nextInt();
       char[][] board = setup(boardSize);
       display(board);
    
     
       int turn = 0;
       char curPlayer = 'B';
       int numTurnSkip = 0;
       while(true) {
           if (turn % 2 == 0) {
               curPlayer = 'B';
           } else {
               curPlayer = 'W';
           }
           if (anyValidMoves(board, curPlayer) == false) {
             System.out.println(curPlayer + " has no valid moves");
             turn++;
             numTurnSkip++;
             if (numTurnSkip == 2) {
                 break;
             }
             continue;
           }    
           System.out.println("It's " + curPlayer + "'s turn. Make your move");
           display(board);
         
           int r = sc.nextInt();
           int c = sc.nextInt();
           while(!isvalidmove(board, r, c, curPlayer)) {
               System.out.println("Invalid Move");
               r = sc.nextInt();
               c = sc.nextInt();
           }
           board = moves(board, r, c, curPlayer);
           turn++;
       }
       win(board);
   }
}
 