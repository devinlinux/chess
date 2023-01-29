/*  Author: Michael Bobrowski
    Final Project - Chess - Painter
 */

//  imports
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Arc2D;
import javax.swing.JPanel;

public class Painter extends JPanel {

    //  instance variables
   public static final Color BACKGROUND = Color.BLACK;

   private ChessGame chess;
   private Frame frame;
   private Board chessBoard;
    
   Painter(ChessGame chess) {
    //  main and main variables
      this.chess = chess;
      frame = chess.frame;
      chessBoard = chess.chessBoard;    
   
      Dimension d = new Dimension(700, 650);
      setMinimumSize(d);
      setPreferredSize(d);
      setMaximumSize(d);
   }
      
    //  paint component
   public void paintComponent(Graphics g) {
   
        //  casting
      Graphics2D g2D = (Graphics2D) g;
      int startX = 5, startY = 5;
        
        //  drawing background
      g.setColor(BACKGROUND);
      g.fillRect(0, 0, frame.getWidth(), frame.getHeight());
   
        //  drawing Chess Board
      for (int a = 0; a < chessBoard.getRows(); a++) {
         for (int b = 0; b < chessBoard.getColumns(); b++) {
            int x = startX + (b * 80);
            int y = startY + (a * 80);
         
                //  determining color
            if ((a + b) %2 != 0) {
               g.setColor(chessBoard.getSecondaryColor());
            }
            if ((a + b) %2 != 1) {
               g.setColor(chessBoard.getPrimaryColor());
            }
                //  drawing squares
            g.fillRect(x, y, 80, 80);
         }
      }
        //  drawing outline
      g.setColor(Color.WHITE);
      g.drawRect(startX, startY, 640, 640);
   
        //  drawing chess.pawns
      if (chess.pawnOne1.getAlive() == true) {
         drawPawn(chess.pawnOne1, chessBoard, g);
      }
      if (chess.pawnOne2.getAlive() == true) {
         drawPawn(chess.pawnOne2, chessBoard, g);
      }
      if (chess.pawnOne3.getAlive() == true) {
         drawPawn(chess.pawnOne3, chessBoard, g);
      }
      if (chess.pawnOne4.getAlive() == true) {
         drawPawn(chess.pawnOne4, chessBoard, g);
      }
      if (chess.pawnOne5.getAlive() == true) {
         drawPawn(chess.pawnOne5, chessBoard, g);
      }
      if (chess.pawnOne6.getAlive() == true) {
         drawPawn(chess.pawnOne6, chessBoard, g);
      }
      if (chess.pawnOne7.getAlive() == true) {
         drawPawn(chess.pawnOne7, chessBoard, g);
      }
      if (chess.pawnOne8.getAlive() == true) {
         drawPawn(chess.pawnOne8, chessBoard, g);
      }
      if (chess.pawnTwo1.getAlive() == true) {
         drawPawn(chess.pawnTwo1, chessBoard, g);
      }
      if (chess.pawnTwo2.getAlive() == true) {
         drawPawn(chess.pawnTwo2, chessBoard, g);
      }
      if (chess.pawnTwo3.getAlive() == true) {
         drawPawn(chess.pawnTwo3, chessBoard, g);
      }
      if (chess.pawnTwo4.getAlive() == true) {
         drawPawn(chess.pawnTwo4, chessBoard, g);
      }
      if (chess.pawnTwo5.getAlive() == true) {
         drawPawn(chess.pawnTwo5, chessBoard, g);
      }
      if (chess.pawnTwo6.getAlive() == true) {
         drawPawn(chess.pawnTwo6, chessBoard, g);
      }
      if (chess.pawnTwo7.getAlive() == true) {
         drawPawn(chess.pawnTwo7, chessBoard, g);
      }
      if (chess.pawnTwo8.getAlive() == true) {
         drawPawn(chess.pawnTwo8, chessBoard, g);
      }
        
        //  drawing chess.rooks
      if (chess.rookOne1.getAlive() == true) {
         drawRook(chess.rookOne1, chessBoard, g);
      }
      if (chess.rookOne2.getAlive() == true) {
         drawRook(chess.rookOne2, chessBoard, g);
      }
      if (chess.rookTwo1.getAlive() == true) {
         drawRook(chess.rookTwo1, chessBoard, g);
      }
      if (chess.rookTwo2.getAlive() == true) {
         drawRook(chess.rookTwo2, chessBoard, g);
      }
        
        //  drawing chess.knights
      if (chess.knightOne1.getAlive() == true) {
         drawKnight(chess.knightOne1, chessBoard, g);
      }
      if (chess.knightOne2.getAlive() == true) {
         drawKnight(chess.knightOne2, chessBoard, g);
      }
      if (chess.knightTwo1.getAlive() == true) {
         drawKnight(chess.knightTwo1, chessBoard, g);
      }
      if (chess.knightTwo2.getAlive() == true) {
         drawKnight(chess.knightTwo2, chessBoard, g);
      }
        
        //  drawing chess.bishops
      if (chess.bishopOne1.getAlive() == true) {
         drawBishop(chess.bishopOne1, chessBoard, g);
      }
      if (chess.bishopOne2.getAlive() == true) {
         drawBishop(chess.bishopOne2, chessBoard, g);
      }
      if (chess.bishopTwo1.getAlive() == true) {
         drawBishop(chess.bishopTwo1, chessBoard, g);
      }
      if (chess.bishopTwo2.getAlive() == true) {
         drawBishop(chess.bishopTwo2, chessBoard, g);
      }
        
        //  drawing chess.queens
      if (chess.queenOne.getAlive() == true) {
         drawQueen(chess.queenOne, chessBoard, g);
      }
      if (chess.queenTwo.getAlive() == true) {
         drawQueen(chess.queenTwo, chessBoard, g);
      }
        
        //  drawing chess.kings
      if (chess.kingOne.getAlive() == true) {
         drawKing(chess.kingOne, chessBoard, g);
      }
      if (chess.kingTwo.getAlive() == true) {
         drawKing(chess.kingTwo, chessBoard, g);
      }
        
        
      repaint();
   }

    //  draw piece methods:
    //  draw a pawn
   private void drawPawn(Piece pawn, Board board, Graphics g) {
      //  casting
      Graphics2D g2D = (Graphics2D) g;
      
      if (pawn.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
      
      //  get x, y from row, column in chess.pawn
      //  if I make the pieces 60x60 that gives 10 point padding on each side
      
      //  making x, y the bottom left of the 60x60 for the piece
      int x = pawn.getColumn() * 80;
      x -= 65;
      int row = pawn.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
      
      //  must draw piece in relation to x, y
      Rectangle base = new Rectangle(x, y - 10, 60, 10);
      g2D.fill(base);
      Rectangle base2 = new Rectangle(x + 5, y - 15, 50, 5);
      g2D.fill(base2);
      Rectangle base3 = new Rectangle(x + 15, y - 25, 30, 20);
      g2D.fill(base3); 
      Rectangle middle = new Rectangle(x + 20, y - 40, 20, 30);
      g2D.fill(middle);
      Rectangle topLine = new Rectangle(x + 17, y - 38, 26, 5);
      g2D.fill(topLine);
      Ellipse2D top = new Ellipse2D.Double(x + 14.5, y - 65, 30, 30);
      g2D.fill(top);
      
      
   }
    
   //  draw a rook 
   private void drawRook(Piece rook, Board board, Graphics g) {
      //  casting
      Graphics2D g2D = (Graphics2D) g;
      
      //  getting color
      if (rook.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
      
      //  making x, y the bottom left of the 60x60 for the piece
      int x = rook.getColumn() * 80;
      x -= 65;
      int row = rook.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
   
      Rectangle base = new Rectangle(x + 2, y - 10, 56, 10);
      g2D.fill(base); 
      Rectangle tower = new Rectangle(x + 10, y - 35, 40, 25);
      g2D.fill(tower);
      Rectangle castleBase = new Rectangle(x + 5, y - 45, 50, 10);
      g2D.fill(castleBase);
      Rectangle castle1 = new Rectangle(x + 5, y - 50, 9, 7);
      g2D.fill(castle1);
      Rectangle castle2 = new Rectangle(x + 24, y - 50, 12, 7);
      g2D.fill(castle2);
      Rectangle castle3 = new Rectangle(x + 46, y - 50, 9, 7);
      g2D.fill(castle3);
   
   }
    
   //  draw a knight 
   private void drawKnight(Piece knight, Board board, Graphics g) {
      //  casting
      Graphics2D g2D = (Graphics2D) g;
      
      //  getting color
      if (knight.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
      
      //  making x, y the bottom left of the 60x60 for the piece
      int x = knight.getColumn() * 80;
      x -= 65;
      int row = knight.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
      
      Rectangle base = new Rectangle(x, y - 10, 60, 10);
      g2D.fill(base);
      Polygon torso = new Polygon();
      torso.addPoint(x + 20, y - 10);
      torso.addPoint(x + 60, y - 10);
      torso.addPoint(x + 60, y - 40);
      torso.addPoint(x + 40, y - 40);
      g2D.fill(torso);
      Rectangle head1 = new Rectangle(x + 10, y - 50, 50, 10);
      g2D.fill(head1);
      Rectangle head2 = new Rectangle(x + 30, y - 60, 30, 10);
      g2D.fill(head2);
      Rectangle ear = new Rectangle(x + 50, y - 65, 10, 5);
      g2D.fill(ear);
      
    
    
   }
    
   //  draw a bishop 
   private void drawBishop(Piece bishop, Board board, Graphics g) {
       //  casting
      Graphics2D g2D = (Graphics2D) g;
       
       //  getting color
      if (bishop.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
       
      //  making x, y the bottom left of the 60x60 for the piece
      int x = bishop.getColumn() * 80;
      x -= 65;
      int row = bishop.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
    
      Rectangle base = new Rectangle(x, y - 10, 60, 10);
      g2D.fill(base); 
      Arc2D mitre = new Arc2D.Double(x, y - 50, 60, 40, 60, 335, Arc2D.PIE);
      g2D.fill(mitre);
    
   }
    
   //  draw a queen 
   private void drawQueen(Piece queen, Board board, Graphics g) {
       //  casting
      Graphics2D g2D = (Graphics2D) g;
       
       //  getting color
      if (queen.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
       
      //  making x, y the bottom left of the 60x60 for the piece
      int x = queen.getColumn() * 80;
      x -= 65;
      int row = queen.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
    
      Rectangle base = new Rectangle(x, y - 10, 60, 10);
      g2D.fill(base);
      Arc2D base2 = new Arc2D.Double(x + 5, y - 30, 50, 40, 0, 180, Arc2D.PIE);
      g2D.fill(base2);
      Polygon spike1 = new Polygon();
      spike1.addPoint(x + 5, y - 10);
      spike1.addPoint(x + 15, y - 10);
      spike1.addPoint(x - 5, y - 40);
      g2D.fill(spike1);
      Polygon spike2 = new Polygon();
      spike2.addPoint(x + 25, y - 10);
      spike2.addPoint(x + 35, y - 10);
      spike2.addPoint(x + 15, y - 45);
      g2D.fill(spike2);
      Polygon spike3 = new Polygon();
      spike3.addPoint(x + 20, y - 10);
      spike3.addPoint(x + 30, y - 10);
      spike3.addPoint(x + 40, y - 45);
      g2D.fill(spike3);
      Polygon spike4 = new Polygon();
      spike4.addPoint(x + 45, y - 10);
      spike4.addPoint(x + 55, y - 10);
      spike4.addPoint(x + 65, y - 40);
      g2D.fill(spike4);
      
   }
    
   //  draw a king 
   private void drawKing(Piece king, Board board, Graphics g) {
       //  casting
      Graphics2D g2D = (Graphics2D) g;
       
       //  getting color
      if (king.getPlayer() == 1) {
         g.setColor(board.getPlayerOneColor());
      } else {
         g.setColor(board.getPlayerTwoColor());
      }
    
      //  making x, y the bottom left of the 60x60 for the piece
      int x = king.getColumn() * 80;
      x -= 65;
      int row = king.getRow();
      int y = 0;
      switch (row) {
         case 1: y = 640;
            break;
         case 2: y = 560;
            break;
         case 3: y = 480;
            break;
         case 4: y = 400;
            break;
         case 5: y = 320;
            break;
         case 6: y = 240;
            break;
         case 7: y = 160;
            break;
         case 8: y = 80;
            break;
      }
      y -= 5;
      
      Rectangle base = new Rectangle(x, y - 10, 60, 10);
      g2D.fill(base);
      Rectangle center = new Rectangle(x + 25, y - 40, 10, 30);
      g2D.fill(center);
      Arc2D outline = new Arc2D.Double(x + 10, y - 25, 40, 40, 0, 180, Arc2D.CHORD);
      g2D.fill(outline);
      Rectangle horizontal = new Rectangle(x + 20, y - 35, 20, 5);
      g2D.fill(horizontal);
    
   }
    

}
