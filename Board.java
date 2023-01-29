/*  Author: Michael Bobrowski
    Final Project - Chess - Board
 */

//  imports
import java.awt.Color;

public class Board {

    //  fields
    private int rows, columns;
    private Color primaryColor, secondaryColor, playerOneColor, playerTwoColor;

    //  constructor
    public Board(int rows, int columns, Color primaryColor, Color secondaryColor, Color playerOneColor, Color playerTwoColor) {
        setRows(rows);
        setColumns(columns);
        setPrimaryColor(primaryColor);
        setSecondaryColor(secondaryColor);
        setPlayerOneColor(playerOneColor);
        setPlayerTwoColor(playerTwoColor);
    }

    //  setters
    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setPrimaryColor(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(Color secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
    
    public void setPlayerOneColor(Color playerOneColor) {
      this.playerOneColor = playerOneColor;
    }
    
    public void setPlayerTwoColor(Color playerTwoColor) {
      this.playerTwoColor = playerTwoColor;
    }

    //  getters
    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public Color getPrimaryColor() {
        return this.primaryColor;
    }

    public Color getSecondaryColor() {
        return this.secondaryColor;
    }
    
    public Color getPlayerOneColor() {
      return this.playerOneColor;
    }
    
    public Color getPlayerTwoColor() {
      return this.playerTwoColor;
    }

    //  toString
    public String toString() {
        return "Rows: " + rows + "\nColumns: " + columns + "\nPrimary Color: " + primaryColor + "\nSecondary Color: " + secondaryColor + "\nPlayer One Color: " + playerOneColor + "\nPlayer Two Color: " + playerTwoColor;
    }

}
