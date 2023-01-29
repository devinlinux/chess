/* Author: Michael Bobrowski  
   Final Project - Chess - Engine
*/   

public class Engine {

   //  main and main variables
   public ChessGame main;
   public int[][] gameArray;
   
   //  constructor
   public Engine(ChessGame game) {
      main = game;
      gameArray = main.gameArray;
   }

   //  verify pawn
   public boolean verifyPawn(int startRow, int startColumn, int newRow, int newColumn, int player) {
   
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
   
      if (player == 1) {
         //  kill
         if (rowDifference == 1) {
            if (columnDifference == 1 || columnDifference == -1) {
               if (gameArray[newColumn][newRow] == 2) {
                  return true;
               }
            }
         }
         //  two space move
         if (rowDifference == 2 && columnDifference == 0) {
            if (startRow == 2) {
               if (gameArray[newColumn][newRow] != 2) {
                  if (gameArray[newColumn - 1][newRow] != 2) {
                     return true;
                  }
               }
            }
         }
         //  normal one space move
         if (rowDifference == 1 && columnDifference == 0) {
            if (gameArray[newColumn][newRow] != 2) {
               return true;
            }
         } 
      }
      
      if (player == 2) {
         //  kill
         if (rowDifference == -1) {
            if (columnDifference == 1 || columnDifference == -1) {
               if (gameArray[newColumn][newRow] == 1) {
                  return true;
               }
            }
         }
         //  two space move
         if (rowDifference == -2 && columnDifference == 0) {
            if (startRow == 7) {
               if (gameArray[newColumn][newRow] != 1) {
                  if (gameArray[newColumn - 1][newRow] != 1) {
                     return true;
                  }
               }
            }
         }
         //  one space move
         if (rowDifference == -1 && columnDifference == 0) {
            if (gameArray[newColumn][newRow] != 1) {
               return true;
            }
         }  
      } 
      
   
      return false;
   
   }
   
   //  verify rook
   public boolean verifyRook(int startRow, int startColumn, int newRow, int newColumn, int player) {
   
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
      boolean valid = false;
      
      //  horizzontal move
      if (startRow == newRow) {
         // left
         if (columnDifference < 0) {
            for (int a = startColumn - 1; a > newColumn; a--) {
               if (gameArray[a][startRow] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  left by 1
         if (columnDifference == -1) {
            if (gameArray[newColumn][startRow] != player) {
               valid = true;
            }
         }
         //  right
         if (columnDifference > 0) {
            for (int b = startColumn + 1; b < newColumn; b++) {
               if (gameArray[b][startRow] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  right by 1
         if (columnDifference == 1) {
            if (gameArray[newColumn][startRow] != player) {
               valid = true;
            }
         }
      }
      //  vertical move
      if (startColumn == newColumn) {
         // down
         if (rowDifference < 0) {
            for (int c = startRow - 1; c > newRow; c--) {
               if (gameArray[startColumn][c] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  down by 1
         if (rowDifference == -1) {
            if (gameArray[startColumn][newRow] != player) {
               valid = true;
            }
         }
         //  up
         if (rowDifference > 0) {
            for (int d = startRow + 1; d < newRow; d++) {
               if (gameArray[startColumn][d] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  up by 1
         if (rowDifference == 1) {
            if (gameArray[startColumn][newRow] != player) {
               valid = true;
            }
         }
      }
      
      return valid;
   }   
   
   //  verify bishop
   public boolean verifyBishop(int startRow, int startColumn, int newRow, int newColumn, int player) {
   
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
      boolean valid = false;
      
      if (Math.abs(rowDifference) == Math.abs(columnDifference)) {
         //  up and right
         if (rowDifference > 0 && columnDifference > 0) {
            for (int a = 1; a < rowDifference; a++) {
               if (gameArray[startColumn + a][startRow + a] == 0) {
                  valid = true;
                  break;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  up and right by 1
         if (rowDifference == 1 && columnDifference == 1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  up and left
         if (rowDifference > 0 && columnDifference < 0) {
            for (int b = 1; b < rowDifference; b++) {
               if (gameArray[startRow + b][startColumn - b] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  up and left by 1
         if (rowDifference == 1 && columnDifference == -1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  down and right
         if (rowDifference < 0 && columnDifference > 0) {
            for (int c = 1; c < columnDifference; c++) {
               if (gameArray[startColumn + c][startRow - c] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  down and right by 1
         if (rowDifference == -1 && columnDifference == 1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  down and left
         if (rowDifference < 0 && columnDifference < 0) {
            for (int d = 1; d < Math.abs(rowDifference); d++) {
               if (gameArray[startColumn - d][startRow -d] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  down and left by 1
         if (rowDifference == -1 && columnDifference == -1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
      }

      
      return valid;
   }
   
   //  verify knight
   public boolean verifyKnight(int startRow, int startColumn, int newRow, int newColumn, int player) {
   
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
      
      if (rowDifference == 2 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      if (rowDifference == 2 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
   
      if (rowDifference == -2 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      if (rowDifference == -2 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      if (rowDifference == 1 && columnDifference == 2) {
         if (gameArray[newColumn][newRow] != player) {
            return false;
         }
      }
      
      if (rowDifference == 1 && columnDifference == -2) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      if (rowDifference == -1 && columnDifference == 2) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      if (rowDifference == -1 && columnDifference == -2) {
         if (gameArray[newColumn][newRow] != player) {
            return true;
         }
      }
      
      return false;
   
   }
   
   //  verify queen
   public boolean verifyQueen(int startRow, int startColumn, int newRow, int newColumn, int player) {
      //  variables
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
      boolean valid = false;
      
      if (Math.abs(rowDifference) == Math.abs(columnDifference)) {
         //  up and right
         if (rowDifference > 0 && columnDifference > 0) {
            for (int a = 1; a < rowDifference; a++) {
               if (gameArray[startColumn + a][startRow + a] == 0) {
                  valid = true;
                  break;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  up and right by 1
         if (rowDifference == 1 && columnDifference == 1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  up and left
         if (rowDifference > 0 && columnDifference < 0) {
            for (int b = 1; b < rowDifference; b++) {
               if (gameArray[startRow + b][startColumn - b] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  up and left by 1
         if (rowDifference == 1 && columnDifference == -1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  down and right
         if (rowDifference < 0 && columnDifference > 0) {
            for (int c = 1; c < columnDifference; c++) {
               if (gameArray[startColumn + c][startRow - c] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  down and right by 1
         if (rowDifference == -1 && columnDifference == 1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
         //  down and left
         if (rowDifference < 0 && columnDifference < 0) {
            for (int d = 1; d < Math.abs(rowDifference); d++) {
               if (gameArray[startColumn - d][startRow -d] == 0) {
                  valid = true;
               } else {
                  valid = false;
                  break;
               }
            }
         }
         //  down and left by 1
         if (rowDifference == -1 && columnDifference == -1) {
            if (gameArray[newColumn][newRow] != player) {
               valid = true;
            }
         }
      }

      //  up
      if (rowDifference > 0 && columnDifference == 0) {
         for (int e = 1; e < rowDifference; e++) {
            if (gameArray[startColumn][startRow + e] == 0) {
               valid = true;
            } else {
               valid = false;
               break;
            }
         }
      }
      //  up by 1
      if (rowDifference == 1 && columnDifference == 0) {
         if(gameArray[newColumn][newRow] != player) {
            valid = true;
         } else {
            valid = false;
         }
      }
      //  down
      if (rowDifference < 0 && columnDifference == 0) {
         for (int f = 1; f < Math.abs(rowDifference); f++) {
            if (gameArray[startColumn][startRow - f] == 0) {
               valid = true;
            } else {
               valid = false;
               break;
            }
         }
      }  
      //  down by 1
      if (rowDifference == -1 && columnDifference == 0) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         } else {
            valid = false;
         }
      }
      //  right
      if (rowDifference == 0 && columnDifference > 0) {
         for (int g = 1; g < columnDifference; g++) {
            if (gameArray[startColumn + g][startRow] == 0) {
               valid = true;
            } else {
               valid = false;
               break;
            }
         }
      }
      //  right by 1
      if (rowDifference == 0 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         } else {
            valid = false;
         }
      }
      //  left
      if (rowDifference == 0 && columnDifference < 0) {
         for (int h = 1; h < Math.abs(columnDifference); h++) {
            if (gameArray[startColumn - h][startRow] == 0) {
               valid = true;
            } else {
               valid = false;
               break;
            }
         }
      }
      //  left by 1
      if (rowDifference == 0 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         } else {
            valid = false;
         }
      }
         
      return valid;
   
   }
   
   //  verify king
   public boolean verifyKing(int startRow, int startColumn, int newRow, int newColumn, int player) {
   
      int rowDifference = newRow - startRow;
      int columnDifference = newColumn - startColumn;
      boolean valid = false;
      
      //  up by 1
      if (rowDifference == 1 && columnDifference == 0) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  down by 1
      if (rowDifference == -1 && columnDifference == 0) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  left by 1
      if (rowDifference == 0 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  right by 1
      if (rowDifference == 0 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  up and left
      if (rowDifference == 1 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  up and right
      if (rowDifference == 1 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  down and left
      if (rowDifference == -1 && columnDifference == -1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
      //  down and right
      if (rowDifference == -1 && columnDifference == 1) {
         if (gameArray[newColumn][newRow] != player) {
            valid = true;
         }
      }
            
      return valid;
   }
   
   //  in check white
   public boolean inCheckWhite() {
   
      if (main.pawnOne1.getAlive() == true) {
         if (verifyPawn(main.pawnOne1.getRow(), main.pawnOne1.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne2.getAlive() == true) {
         if (verifyPawn(main.pawnOne2.getRow(), main.pawnOne2.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne3.getAlive() == true) {
         if (verifyPawn(main.pawnOne3.getRow(), main.pawnOne3.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne3.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne4.getAlive() == true) {
         if (verifyPawn(main.pawnOne4.getRow(), main.pawnOne4.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne4.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne5.getAlive() == true) {
         if (verifyPawn(main.pawnOne5.getRow(), main.pawnOne5.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne5.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne6.getAlive() == true) {
         if (verifyPawn(main.pawnOne6.getRow(), main.pawnOne6.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne6.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne7.getAlive() == true) {
         if (verifyPawn(main.pawnOne7.getRow(), main.pawnOne7.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne7.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnOne8.getAlive() == true) {
         if (verifyPawn(main.pawnOne8.getRow(), main.pawnOne8.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.pawnOne8.getPlayer()) == true) {
            return true;
         }
      }
      if (main.rookOne1.getAlive() == true) {
         if (verifyRook(main.rookOne1.getRow(), main.rookOne1.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.rookOne1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.rookOne2.getAlive() == true) {
         if (verifyRook(main.rookOne2.getRow(), main.rookOne2.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.rookOne2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.knightOne1.getAlive() == true) {
         if (verifyKnight(main.knightOne1.getRow(), main.knightOne1.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.knightOne1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.knightOne2.getAlive() == true) {
         if (verifyKnight(main.knightOne2.getRow(), main.knightOne2.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.knightOne2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.bishopOne1.getAlive() == true) {
         if (verifyBishop(main.bishopOne1.getRow(), main.bishopOne1.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.bishopOne1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.bishopOne2.getAlive() == true) {
         if (verifyBishop(main.bishopOne2.getRow(), main.bishopOne2.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.bishopOne2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.queenOne.getAlive() == true) {
         if (verifyQueen(main.queenOne.getRow(), main.queenOne.getColumn(), main.kingTwo.getRow(), main.kingTwo.getColumn(), main.queenOne.getPlayer()) == true) {
            return true;
         }
      }
      
      return false;
   
   }
   
   //  in check black
   public boolean inCheckBlack() {
   
      if (main.pawnTwo1.getAlive() == true) {
         if (verifyPawn(main.pawnTwo1.getRow(), main.pawnTwo1.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo2.getAlive() == true) {
         if (verifyPawn(main.pawnTwo2.getRow(), main.pawnTwo2.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo3.getAlive() == true) {
         if (verifyPawn(main.pawnTwo3.getRow(), main.pawnTwo3.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo3.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo4.getAlive() == true) {
         if (verifyPawn(main.pawnTwo4.getRow(), main.pawnTwo4.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo4.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo5.getAlive() == true) {
         if (verifyPawn(main.pawnTwo5.getRow(), main.pawnTwo5.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo5.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo6.getAlive() == true) {
         if (verifyPawn(main.pawnTwo6.getRow(), main.pawnTwo6.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo6.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo7.getAlive() == true) {
         if (verifyPawn(main.pawnTwo7.getRow(), main.pawnTwo7.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo7.getPlayer()) == true) {
            return true;
         }
      }
      if (main.pawnTwo8.getAlive() == true) {
         if (verifyPawn(main.pawnTwo8.getRow(), main.pawnTwo8.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.pawnTwo8.getPlayer()) == true) {
            return true;
         }
      }
      if (main.rookTwo1.getAlive() == true) {
         if (verifyRook(main.rookTwo1.getRow(), main.rookTwo1.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.rookTwo1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.rookTwo2.getAlive() == true) {
         if (verifyRook(main.rookTwo2.getRow(), main.rookTwo2.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.rookTwo2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.knightTwo1.getAlive() == true) {
         if (verifyKnight(main.knightTwo1.getRow(), main.knightTwo1.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.knightTwo1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.knightTwo2.getAlive() == true) {
         if (verifyKnight(main.knightTwo2.getRow(), main.knightTwo2.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.knightTwo2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.bishopTwo1.getAlive() == true) {
         if (verifyBishop(main.bishopTwo1.getRow(), main.bishopTwo1.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.bishopTwo1.getPlayer()) == true) {
            return true;
         }
      }
      if (main.bishopTwo2.getAlive() == true) {
         if (verifyBishop(main.bishopTwo2.getRow(), main.bishopTwo2.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.bishopTwo2.getPlayer()) == true) {
            return true;
         }
      }
      if (main.queenTwo.getAlive() == true) {
         if (verifyQueen(main.queenTwo.getRow(), main.queenTwo.getColumn(), main.kingOne.getRow(), main.kingOne.getColumn(), main.queenTwo.getPlayer()) == true) {
            return true;
         }
      }
   
      return false;
   
   }
   
}
