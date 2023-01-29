/*  Author: Michael Bobrowski
    Final Project - Chess - Frame
 */

//  imports
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    //  variables
   private int x;
   private int y;
   private int startRow;
   private int startColumn;
   private boolean firstTurn = true;
   private int turn;
   private int endRow;
   private int endColumn;
   private boolean validMove = false;
   private boolean inCheck;
   private int pieceToMove;
   private int pieceAt;
   private Piece piece;
   private Piece affectedPiece;
   private ChessGame game;
   private Engine engine;
   private int[][] gameArray;
   private int[][] idArray;

    //  actionPerformed
   @Override
    public void actionPerformed(ActionEvent e) {
   
   }


    //  constructor
   public Frame(String title, Engine engine, ChessGame game) {
      setTitle(title);
      this.game = game;
      this.engine = engine;
    //    game = new ChessGame();
      idArray = game.idArray;
      gameArray = game.gameArray;
      affectedPiece = game.test;
      setup();
      setVisible(true);
   }
   
   //  setup
   public void setup() {
   
        //  mouse listener
      MouseListener ml = 
         new MouseListener() {
         
            public void mousePressed(MouseEvent e) {
            
            }
         
            public void mouseReleased(MouseEvent e) {
            
            }
         
            public void mouseClicked(MouseEvent e) {
               x = e.getX();
               y = e.getY();
               int column = getColumn(x);
               int row = getRow(y);
               System.out.println("Row: " + row + " Column: " + column);
               if (firstTurn) {
               //  store row and column and make first turn false
                  startRow = row;
                  startColumn = column;
                  firstTurn = false;
               
               } else {
               //  check if row and column are the same if they are the same reset row and column and make first turn true otherwise grab the destination row and column perform the move
                  endRow = row;
                  endColumn = column;
                  if (startRow == endRow && endColumn == startColumn) {
                     startRow = 0;
                     startColumn = 0;
                     endRow = 0;
                     endColumn = 0;
                     pieceToMove = 0;
                  } else {
                     pieceToMove = idArray[startColumn][startRow];
                     pieceAt = idArray[endColumn][endRow];
                     System.out.println("Piece to Move: " + pieceToMove);
                     
                     //  converting pieceToMove to piece and verifying the move
                     switch (pieceToMove) {
                        case 1: validMove =  engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1); 
                           piece = game.pawnOne1;
                           break;
                        case 2: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne2;
                           break;        
                        case 3: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne3;
                           break;
                        case 4: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne4;
                           break;
                        case 5: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne5;
                           break;
                        case 6: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne6;
                           break;
                        case 7: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne7;
                           break;
                        case 8: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.pawnOne8;
                           break;
                        case 9: validMove = engine.verifyRook(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.rookOne1;
                           break;
                        case 10: validMove = engine.verifyRook(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.rookOne2;
                           break;
                        case 11: validMove = engine.verifyKnight(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.knightOne1;
                           break;
                        case 12: validMove = engine.verifyKnight(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.knightOne2;
                           break;
                        case 13: validMove = engine.verifyBishop(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.bishopOne1;
                           break;
                        case 14: validMove = engine.verifyBishop(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.bishopOne2;
                           break;
                        case 15: validMove = engine.verifyQueen(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.queenOne;
                           break;
                        case 16: validMove = engine.verifyKing(startRow, startColumn, endRow, endColumn, 1);
                           piece = game.kingOne;
                           break;
                        case 17: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo1;
                           break;
                        case 18: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo2;
                           break;
                        case 19: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo3;
                           break;
                        case 20: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo4;
                           break;
                        case 21: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo5;
                           break;
                        case 22: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo6;
                           break;
                        case 23: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo7;
                           break;
                        case 24: validMove = engine.verifyPawn(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.pawnTwo8;
                           break;
                        case 25: validMove = engine.verifyRook(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.rookTwo1;
                           break;
                        case 26: validMove = engine.verifyRook(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.rookTwo2;
                           break;                                                  
                        case 27: validMove = engine.verifyKnight(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.knightTwo1;
                           break;
                        case 28: validMove = engine.verifyKnight(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.knightTwo2;
                           break;
                        case 29: validMove = engine.verifyBishop(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.bishopTwo1;
                           break;
                        case 30: validMove = engine.verifyBishop(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.bishopTwo2;
                           break;                                                                                                                                                    
                        case 31: validMove = engine.verifyQueen(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.queenTwo;
                           break;
                        case 32: validMove = engine.verifyKing(startRow, startColumn, endRow, endColumn, 2);
                           piece = game.kingTwo;     
                           break;                                            
                     }
                     
                     //  converting pieceAt to affectedPiece
                     switch (pieceAt) {
                        case 1: 
                           affectedPiece = game.pawnOne1;
                           break;
                        case 2: 
                           affectedPiece = game.pawnOne2;
                           break;        
                        case 3: 
                           affectedPiece = game.pawnOne3; 
                           break;
                        case 4: 
                           affectedPiece = game.pawnOne4;
                           break;
                        case 5: 
                           affectedPiece = game.pawnOne5;
                           break;
                        case 6: 
                           affectedPiece = game.pawnOne6;
                           break;
                        case 7: 
                           affectedPiece = game.pawnOne7;
                           break;
                        case 8: 
                           affectedPiece = game.pawnOne8;
                           break;
                        case 9: 
                           affectedPiece = game.rookOne1;
                           break;
                        case 10: 
                           affectedPiece = game.rookOne2;
                           break;
                        case 11: 
                           affectedPiece = game.knightOne1;
                           break;
                        case 12: 
                           affectedPiece = game.knightOne2;
                           break;
                        case 13: 
                           affectedPiece = game.bishopOne1;
                           break;
                        case 14: 
                           affectedPiece = game.bishopOne2;
                           break;
                        case 15: 
                           affectedPiece = game.queenOne;
                           break;
                        case 16: 
                           affectedPiece = game.kingOne;
                           break;
                        case 17: 
                           affectedPiece = game.pawnTwo1;
                           break;
                        case 18: 
                           affectedPiece = game.pawnTwo2;
                           break;
                        case 19: 
                           affectedPiece = game.pawnTwo3;
                           break;
                        case 20: 
                           affectedPiece = game.pawnTwo4;
                           break;
                        case 21: 
                           affectedPiece = game.pawnTwo5;
                           break;
                        case 22: 
                           affectedPiece = game.pawnTwo6;
                           break;
                        case 23: 
                           affectedPiece = game.pawnTwo7;
                           break;
                        case 24: 
                           affectedPiece = game.pawnTwo8;
                           break;
                        case 25: 
                           affectedPiece = game.rookTwo1;
                           break;
                        case 26: 
                           affectedPiece = game.rookTwo2;
                           break;  
                        case 27: 
                           affectedPiece = game.knightTwo1;
                           break;
                        case 28: 
                           affectedPiece = game.knightTwo2;
                           break;
                        case 29: 
                           affectedPiece = game.bishopTwo1;
                           break;
                        case 30:
                           affectedPiece = game.bishopTwo2;
                           break;
                        case 31: 
                           affectedPiece = game.queenTwo; 
                           break;
                        case 32: 
                           affectedPiece = game.kingTwo;
                           break;                                  
                     }
                     //System.out.println(validMove);
                     System.out.println("p " + piece.getType());
                    // System.out.println(affectedPiece.getType());
                     
                     if ((piece.getPlayer() == 1 && turn % 2 == 0) || (piece.getPlayer() == 2 && turn % 2 == 1)) {                  
                        System.out.println("vm " + validMove);
                        if (validMove) {
                           affectedPiece.setAlive(false);
                           piece.setRow(endRow);
                           piece.setColumn(endColumn);
                           turn++;
                           gameArray[startColumn][startRow] = 0;
                           gameArray[endColumn][endRow] = piece.getPlayer();
                           idArray[startColumn][startRow] = 0;
                           idArray[endColumn][endRow] = piece.getPiece();
                           if (piece.getPlayer() == 1) {
                              inCheck = engine.inCheckBlack();
                           } else {
                              inCheck = engine.inCheckWhite();
                           }
                           System.out.println("ic " + inCheck);
                           // CHANGE THE ARRAYS
                           if (inCheck) {
                              affectedPiece.setAlive(true);                        
                              piece.setRow(startRow);
                              piece.setColumn(startColumn);
                              gameArray[startColumn][startRow] = piece.getPlayer();
                              gameArray[endColumn][endRow] = 0;
                              idArray[startColumn][startRow] = piece.getPiece();
                              idArray[endColumn][endRow] = 0;
                              affectedPiece = game.test;
                                //  REVERT THE CHANGES
                           }
                           if (validMove && !inCheck) {
                              //System.out.println(affectedPiece.getType());
                              //System.out.println(affectedPiece.getAlive());
                              affectedPiece = game.test;
                              piece = game.test;
                              repaint();
                              inCheck = false;
                           } else {
                              affectedPiece = game.test;
                              piece = game.test;
                              turn++;
                              inCheck = false;
                           }
                           
                        }                      
                        
                     }
                  }
                  firstTurn = true;     
                  affectedPiece = game.test;          
               }
            }
         
            public void mouseEntered(MouseEvent e) {
            }
         
            public void mouseExited(MouseEvent e) {
            }
         };
   
      MouseMotionListener mml = 
         new MouseMotionListener() {
         
            public void mouseMoved(MouseEvent e) {
            
            }
         
            public void mouseDragged(MouseEvent e) {
            
            }
         };
   
      setSize(1400, 800);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addMouseListener(ml);
      addMouseMotionListener(mml);
      setFocusable(true);
      requestFocus();
      setVisible(true);
   }
    
   //  get column from x 
   private static int getColumn(int x) {
      x -= 11;
      if (x <= 80) {
         return 1;
      } else if (x <= 160) {
         return 2;
      } else if (x <= 240) {
         return 3;
      } else if (x <= 320) {
         return 4;
      } else if (x <= 400) {
         return 5;
      } else if (x <= 480) {
         return 6;
      } else if (x <= 560) {
         return 7;
      } else if (x <= 640) {
         return 8;
      }
      
      return 0;
   }    
   
   //  get row from y
   private static int getRow(int y) { 
      y -= 34;
      if (y <= 80) {
         return 8;
      } else if (y <= 160) {
         return 7;
      } else if (y <= 240) {
         return 6;
      } else if (y <= 320) {
         return 5;
      } else if (y <= 400) {
         return 4;
      } else if (y <= 480) {
         return 3;
      } else if (y <= 560) {
         return 2;
      } else if (y <= 640) {
         return 1;
      }
      
      return 0;
   }
   

}
