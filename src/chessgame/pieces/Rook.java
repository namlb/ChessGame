/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.pieces;

import chessgame.Board;
import chessgame.Box;
import chessgame.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author namlb
 */
public class Rook extends Piece{
        public Rook(int color, String img, Box box) {
        super(color, img, box);
    }   

    @Override
    public List<Box> getMovableBox(Board board) {
        movable = new ArrayList<>();
        Box[][] boxses = board.getBoxses();
        int x = this.getBox().getxNum();
        int y = this.getBox().getyNum();
        
        int i,j;
        i = x-1;
        j = y;
        
        while(i>=0) {
            if(boxses[i][j].getPiece()==null) {
                movable.add(boxses[i][j]);
            } else if(boxses[i][j].getPiece().getColor()==this.getColor()) {
                break;
            } else {
                movable.add(boxses[i][j]);
                break;
            }
            i--;
        }
        
        i = x+1;
        j = y;
        while(i<=7) {
            if(boxses[i][j].getPiece()==null) {
                movable.add(boxses[i][j]);
            } else if(boxses[i][j].getPiece().getColor()==this.getColor()) {
                break;
            } else {
                movable.add(boxses[i][j]);
                break;
            }
            i++;
        }
        
        i = x;
        j = y+1;
        while(j<=7) {
            if(boxses[i][j].getPiece()==null) {
                movable.add(boxses[i][j]);
            } else if(boxses[i][j].getPiece().getColor()==this.getColor()) {
                break;
            } else {
                movable.add(boxses[i][j]);
                break;
            }
            j++;
        }
        
        i = x;
        j = y-1;
        while(j>=0) {
            if(boxses[i][j].getPiece()==null) {
                movable.add(boxses[i][j]);
            } else if(boxses[i][j].getPiece().getColor()==this.getColor()) {
                break;
            } else {
                movable.add(boxses[i][j]);
                break;
            }
            j--;
        }
        return movable;
    }
}
