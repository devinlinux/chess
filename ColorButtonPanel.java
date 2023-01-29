/*  Author: Michael Bobrowski
    Final Project - Chess - ColorButton
 */

//  imports
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import javax.swing.JButton;

public class ColorButtonPanel extends JPanel {

   private Board board;

   //  variables
   public static Color color;
   public static Color currentChoice;

   //  constructor
   public ColorButtonPanel(String title, Color color, int type, Board board) {
      this.board = board;
      
      setBackground(Painter.BACKGROUND);
      setBackground(color);
      JButton colorButton = createButton(title, color);
      colorButton.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JColorChooser chooser = new JColorChooser();
               //ColorButton.color = chooser.showDialog(null, "Choose your color", color);
               Color newColor = chooser.showDialog(null, "Choose your color", Color.WHITE);
               if (newColor != null) {
                  setBackground(newColor);
                  ColorButtonPanel.color = newColor;
               
                  //  using type to determine what color to change
                  switch (type) {
                     case 1: board.setPrimaryColor(newColor);
                        break;
                     case 2: board.setSecondaryColor(newColor);
                        break;
                     case 3: board.setPlayerOneColor(newColor);
                        break;
                     case 4: board.setPlayerTwoColor(newColor);
                        break;    
                  }
                  repaint();
                  System.out.println(color);
               }
            }
         });
      add(colorButton);
   }

   //  create a button
   public JButton createButton(String name, Color color) {
      JButton button = new JButton(name);
      button.setFont(new Font("Bahnschrift", Font.PLAIN, 24));
      button.setForeground(Color.RED);
      button.setBackground(color);
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      return button;
   }
}
