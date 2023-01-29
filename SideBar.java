/*  Author: Michael Bobrowski
    Final Project - Chess - SideBar
 */

//  imports
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SideBar extends JPanel {

   //  painter and variables
   public final Color BACKGROUND = Painter.BACKGROUND;

   //  main, board, and variables
   ChessGame chessBoard;
   Board board;
   Color boardPrimary;
   Color boardSecondary;

   //  constructor
   public SideBar(ChessGame game) {
      chessBoard = game;
      board = game.chessBoard;
      boardPrimary = board.getPrimaryColor();
      boardSecondary = board.getSecondaryColor();
      setBackground(BACKGROUND);
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      JPanel primaryBoard = new ColorButtonPanel("Primary Board Color", boardPrimary, 1, board);
      JPanel secondaryBoard = new ColorButtonPanel("Secondary Board Color", boardSecondary, 2, board);
      JPanel primaryPiece = new ColorButtonPanel("Player One Piece Color", Color.WHITE, 3, board);
      JPanel secondaryPiece = new ColorButtonPanel("Player Two Piece Color", Color.BLACK, 4, board);
     
      Dimension spacer = new Dimension(1, 20); 
      Dimension margin = new Dimension(1, 200);       
      add(Box.createVerticalGlue());
      add(Box.createRigidArea(margin));
      add(primaryBoard);
      add(Box.createRigidArea(spacer));
      add(secondaryBoard);
      add(Box.createRigidArea(spacer));
      add(primaryPiece);
      add(Box.createRigidArea(spacer));
      add(secondaryPiece);
      add(Box.createRigidArea(margin));
      add(Box.createVerticalGlue());
   }

}
