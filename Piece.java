/* Author: Michael Bobrowski
   Final Project - Chess - Peice
*/

public class Piece {

    //  fields
    private String type;
    private int row, column, value, player, piece;
    private boolean alive;

    //  constructor
    public Piece(String type, int row, int column, int value, int player, boolean alive, int piece) {

        setType(type);
        setRow(row);
        setColumn(column);
        setValue(value);
        setPlayer(player);
        setAlive(alive);
        setPiece(piece);

    }

    //  setters

    public void setType(String type) {
        this.type = type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public void setPiece(int piece) {
      this.piece = piece;
    }

    //  getters

    public String getType() {
        return this.type;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getValue() {
        return this.value;
    }

    public int getPlayer() {
        return this.player;
    }

    public boolean getAlive() {
        return this.alive;
    }
    
    public int getPiece() {
      return this.piece;
    }

    //  toString
    public String toString() {
        return "Type: " + type + "\nRow: " + row + "\nColumn: " + column + "\nValue: " + value + "\nPlayer: " + player + "\nAlive: " + alive + "\nPiece: " + piece;
    }

}
