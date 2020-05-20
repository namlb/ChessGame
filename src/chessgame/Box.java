/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author namlb
 */
public class Box extends JComponent{
    private final Board board;
    private final int color;
    private final int xNum;
    private final int yNum;
    private Piece piece;
    private boolean dispPiece = true;

    public Box(Board board, int color, int xNum, int yNum) {
        this.color = color;
        this.xNum = xNum;
        this.yNum = yNum;
        this.board = board;
    }
   
    
    @Override
    public void paintComponent(Graphics g) {
        if (this.color == Config.White.COLOR) {
            g.setColor(new Color(221,192,127));
        } else {
            g.setColor(new Color(101,67,33));
        }
        
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if(piece != null && this.dispPiece) {
            piece.display(g);
        }
    }
    
    public boolean hasPiece(){
        return piece != null;
    }
    
    public int getColor() {
        return this.color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getxNum() {
        return xNum;
    }

    public int getyNum() {
        return yNum;
    }

    public boolean isDispPiece() {
        return dispPiece;
    }

    public void setDispPiece(boolean dispPiece) {
        this.dispPiece = dispPiece;
    }

    public Board getBoard() {
        return board;
    }
        
}
