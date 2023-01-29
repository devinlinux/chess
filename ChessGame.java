/*  Author: Michael Bobrowski
    Final Project - Chess - Main
 */

//  imports
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ChessGame {     
          
   //  id array to find what peice is at each location - fill with the type of each piece    
   public int[][] idArray;       

   //  frame and engine
   public Engine engine;
   public Frame frame;

   //  all pieces
   //  player 1
   public Piece pawnOne1;
   public Piece pawnOne2;
   public Piece pawnOne3;
   public Piece pawnOne4;
   public Piece pawnOne5;
   public Piece pawnOne6;
   public Piece pawnOne7;
   public Piece pawnOne8;
   public Piece rookOne1;
   public Piece rookOne2;
   public Piece knightOne1;
   public Piece knightOne2;
   public Piece bishopOne1;
   public Piece bishopOne2;
   public Piece queenOne;
   public Piece kingOne;
   //  player 2
   public Piece pawnTwo1;
   public Piece pawnTwo2;
   public Piece pawnTwo3;
   public Piece pawnTwo4;
   public Piece pawnTwo5;
   public Piece pawnTwo6;
   public Piece pawnTwo7;
   public Piece pawnTwo8;
   public Piece rookTwo1;
   public Piece rookTwo2;
   public Piece knightTwo1;
   public Piece knightTwo2;
   public Piece bishopTwo1;
   public Piece bishopTwo2;
   public Piece queenTwo;
   public Piece kingTwo;
   //  test
   public Piece test = new Piece("test", 0, 0, 0, 0, true, 33);

   public int[][] gameArray;

   //  chess board
   public Board chessBoard;  
   

  // Constructor
   public ChessGame() {
      createPiecesPlayerOne();
      createPiecesPlayerTwo();
      chessBoard = new Board(8, 8, new Color(153, 153, 153), new Color(102, 153, 0), Color.WHITE, Color.BLACK);
      gameArray = new int[9][9];
      idArray = new int[9][9];
   
      engine = new Engine(this);
      frame = new Frame("Chess", engine, this);
   
      JPanel painter = new Painter(this);
      SideBar bar = new SideBar(this);
      //  painter.setLayout(new BorderLayout());
      frame.add(bar, BorderLayout.EAST);
      
      //  filling arrays
      fillGameArray();
      fillIdArray();
   
      //  adding painter
      frame.add(painter, BorderLayout.CENTER);
      
      frame.pack();
      frame.setVisible(true);
   }

   //  main method
   public static void main(String[] args) {
   
      //  painter jpanel
      ChessGame m = new ChessGame();
      
   }
   
   //  create player one pieces
   private void createPiecesPlayerOne() {
      pawnOne1 = new Piece("Player one pawn 1", 2, 1, 1, 1, true, 1);
      pawnOne2 = new Piece("Player one pawn 2", 2, 2, 1, 1, true, 2);
      pawnOne3 = new Piece("Player one pawn 3", 2, 3, 1, 1, true, 3);
      pawnOne4 = new Piece("Player one pawn 4", 2, 4, 1, 1, true, 4);
      pawnOne5 = new Piece("Player one pawn 5", 2, 5, 1, 1, true, 5);
      pawnOne6 = new Piece("Player one pawn 6", 2, 6, 1, 1, true, 6);
      pawnOne7 = new Piece("Player one pawn 7", 2, 7, 1, 1, true, 7);
      pawnOne8 = new Piece("Player one pawn 8", 2, 8, 1, 1, true, 8);
      rookOne1 = new Piece("Player one rook 1", 1, 1, 5, 1, true, 9);
      rookOne2 = new Piece("Player one rook 2", 1, 8, 5, 1, true, 10);
      knightOne1 = new Piece("Player one knight 1", 1, 2, 3, 1, true, 11);
      knightOne2 = new Piece("Player one knight 2", 1, 7, 3, 1, true, 12);
      bishopOne1 = new Piece("Player one bishop 1", 1, 3, 3, 1, true, 13);
      bishopOne2 = new Piece("Player one bishop 2", 1, 6, 3, 1, true, 14);
      queenOne = new Piece("Player one queen", 1, 4, 9, 1, true, 15);
      kingOne = new Piece("Player one king", 1, 5, 0, 1, true, 16);
   }

   //  create player two pieces
   private void createPiecesPlayerTwo() {
   
      pawnTwo1 = new Piece("Player two pawn 1", 7, 1, 1, 2, true, 17);
      pawnTwo2 = new Piece("Player two pawn 2", 7, 2, 1, 2, true, 18);
      pawnTwo3 = new Piece("Player two pawn 3", 7, 3, 1, 2, true, 19);
      pawnTwo4 = new Piece("Player two pawn 4", 7, 4, 1, 2, true, 20);
      pawnTwo5 = new Piece("Player two pawn 5", 7, 5, 1, 2, true, 21);
      pawnTwo6 = new Piece("Player two pawn 6", 7, 6, 1, 2, true, 22);
      pawnTwo7 = new Piece("Player two pawn 7", 7, 7, 1, 2, true, 23);
      pawnTwo8 = new Piece("Player two pawn 8", 7, 8, 1, 2, true, 24);
      rookTwo1 = new Piece("Player two rook 1", 8, 1, 5, 2, true, 25);
      rookTwo2 = new Piece("Player two rook 2", 8, 8, 5, 2, true, 26);
      knightTwo1 = new Piece("Player two knight 1", 8, 2, 3, 2, true, 27);
      knightTwo2 = new Piece("Player two knight 2", 8, 7, 3, 2, true, 28);
      bishopTwo1 = new Piece("Player two bishop 1", 8, 3, 3, 2, true, 29);
      bishopTwo2 = new Piece("Player two bishop 2", 8, 6, 3, 2, true, 30);
      queenTwo = new Piece("Player two queen", 8, 4, 9, 2, true, 31);
      kingTwo = new Piece("Player two king", 8, 5, 0, 2, true, 32);
   
   }
   
   //  fill the game array
   private void fillGameArray() {
   
      //  filling game array
      gameArray[pawnOne1.getColumn()][pawnOne1.getRow()] = pawnOne1.getPlayer();
      gameArray[pawnOne2.getColumn()][pawnOne2.getRow()] = pawnOne2.getPlayer();
      gameArray[pawnOne3.getColumn()][pawnOne3.getRow()] = pawnOne3.getPlayer();
      gameArray[pawnOne4.getColumn()][pawnOne4.getRow()] = pawnOne4.getPlayer();
      gameArray[pawnOne5.getColumn()][pawnOne5.getRow()] = pawnOne5.getPlayer();
      gameArray[pawnOne6.getColumn()][pawnOne6.getRow()] = pawnOne6.getPlayer();
      gameArray[pawnOne7.getColumn()][pawnOne7.getRow()] = pawnOne7.getPlayer();
      gameArray[pawnOne8.getColumn()][pawnOne8.getRow()] = pawnOne8.getPlayer();
      gameArray[rookOne1.getColumn()][rookOne1.getRow()] = rookOne1.getPlayer();
      gameArray[rookOne2.getColumn()][rookOne2.getRow()] = rookOne2.getPlayer();
      gameArray[knightOne1.getColumn()][knightOne1.getRow()] = knightOne1.getPlayer();
      gameArray[knightOne2.getColumn()][knightOne2.getRow()] = knightOne2.getPlayer();
      gameArray[bishopOne1.getColumn()][bishopOne1.getRow()] = bishopOne1.getPlayer();
      gameArray[bishopOne2.getColumn()][bishopOne2.getRow()] = bishopOne2.getPlayer();
      gameArray[queenOne.getColumn()][queenOne.getRow()] = queenOne.getPlayer();
      gameArray[kingOne.getColumn()][kingOne.getRow()] = kingOne.getPlayer();
      gameArray[pawnTwo1.getColumn()][pawnTwo1.getRow()] = pawnTwo1.getPlayer();
      gameArray[pawnTwo2.getColumn()][pawnTwo2.getRow()] = pawnTwo2.getPlayer();
      gameArray[pawnTwo3.getColumn()][pawnTwo3.getRow()] = pawnTwo3.getPlayer();
      gameArray[pawnTwo4.getColumn()][pawnTwo4.getRow()] = pawnTwo4.getPlayer();
      gameArray[pawnTwo5.getColumn()][pawnTwo5.getRow()] = pawnTwo5.getPlayer();
      gameArray[pawnTwo6.getColumn()][pawnTwo6.getRow()] = pawnTwo6.getPlayer();
      gameArray[pawnTwo7.getColumn()][pawnTwo7.getRow()] = pawnTwo7.getPlayer();
      gameArray[pawnTwo8.getColumn()][pawnTwo8.getRow()] = pawnTwo8.getPlayer();
      gameArray[rookTwo1.getColumn()][rookTwo1.getRow()] = rookTwo1.getPlayer();
      gameArray[rookTwo2.getColumn()][rookTwo2.getRow()] = rookTwo2.getPlayer();
      gameArray[knightTwo1.getColumn()][knightTwo1.getRow()] = knightTwo1.getPlayer();
      gameArray[knightTwo2.getColumn()][knightOne2.getRow()] = knightTwo2.getPlayer();
      gameArray[bishopTwo1.getColumn()][bishopTwo1.getRow()] = bishopTwo1.getPlayer();
      gameArray[bishopTwo2.getColumn()][bishopTwo2.getRow()] = bishopTwo2.getPlayer();
      gameArray[queenTwo.getColumn()][queenTwo.getRow()] = queenTwo.getPlayer();
      gameArray[kingTwo.getColumn()][kingTwo.getRow()] = kingTwo.getPlayer();
   
   
   }
   
   //  fill the id array
   private void fillIdArray() {
      
      //  filling id array
      idArray[pawnOne1.getColumn()][pawnOne1.getRow()] = pawnOne1.getPiece();
      idArray[pawnOne2.getColumn()][pawnOne2.getRow()] = pawnOne2.getPiece();
      idArray[pawnOne3.getColumn()][pawnOne3.getRow()] = pawnOne3.getPiece();
      idArray[pawnOne4.getColumn()][pawnOne4.getRow()] = pawnOne4.getPiece();
      idArray[pawnOne5.getColumn()][pawnOne5.getRow()] = pawnOne5.getPiece();
      idArray[pawnOne6.getColumn()][pawnOne6.getRow()] = pawnOne6.getPiece();
      idArray[pawnOne7.getColumn()][pawnOne7.getRow()] = pawnOne7.getPiece();
      idArray[pawnOne8.getColumn()][pawnOne8.getRow()] = pawnOne8.getPiece();
      idArray[rookOne1.getColumn()][rookOne1.getRow()] = rookOne1.getPiece();
      idArray[rookOne2.getColumn()][rookOne2.getRow()] = rookOne2.getPiece();
      idArray[knightOne1.getColumn()][knightOne1.getRow()] = knightOne1.getPiece();
      idArray[knightOne2.getColumn()][knightOne2.getRow()] = knightOne2.getPiece();
      idArray[bishopOne1.getColumn()][bishopOne1.getRow()] = bishopOne1.getPiece();
      idArray[bishopOne2.getColumn()][bishopOne2.getRow()] = bishopOne2.getPiece();
      idArray[queenOne.getColumn()][queenOne.getRow()] = queenOne.getPiece();
      idArray[kingOne.getColumn()][kingOne.getRow()] = kingOne.getPiece();
      idArray[pawnTwo1.getColumn()][pawnTwo1.getRow()] = pawnTwo1.getPiece();
      idArray[pawnTwo2.getColumn()][pawnTwo2.getRow()] = pawnTwo2.getPiece();
      idArray[pawnTwo3.getColumn()][pawnTwo3.getRow()] = pawnTwo3.getPiece();
      idArray[pawnTwo4.getColumn()][pawnTwo4.getRow()] = pawnTwo4.getPiece();
      idArray[pawnTwo5.getColumn()][pawnTwo5.getRow()] = pawnTwo5.getPiece();
      idArray[pawnTwo6.getColumn()][pawnTwo6.getRow()] = pawnTwo6.getPiece();
      idArray[pawnTwo7.getColumn()][pawnTwo7.getRow()] = pawnTwo7.getPiece();
      idArray[pawnTwo8.getColumn()][pawnTwo8.getRow()] = pawnTwo8.getPiece();
      idArray[rookTwo1.getColumn()][rookTwo1.getRow()] = rookTwo1.getPiece();
      idArray[rookTwo2.getColumn()][rookTwo2.getRow()] = rookTwo2.getPiece();
      idArray[knightTwo1.getColumn()][knightTwo1.getRow()] = knightTwo1.getPiece();
      idArray[knightTwo2.getColumn()][knightTwo2.getRow()] = knightTwo2.getPiece();
      idArray[bishopTwo1.getColumn()][bishopTwo1.getRow()] = bishopTwo1.getPiece();
      idArray[bishopTwo2.getColumn()][bishopTwo2.getRow()] = bishopTwo2.getPiece();
      idArray[queenTwo.getColumn()][queenTwo.getRow()] = queenTwo.getPiece();
      idArray[kingTwo.getColumn()][kingTwo.getRow()] = kingTwo.getPiece();
   
   }
    
   
}