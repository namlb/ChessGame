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
public class Bishop extends Piece{
        public Bishop(int color, String img, Box box) {
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
        j = y-1;
        while(i>=0&&j>=0) {
            if(boxses[i][j].getPiece() == null) {
                movable.add(boxses[i][j]);
                i--;
                j--;
            } else {
                if(getColor() != boxses[i][j].getPiece().getColor()) {
                    movable.add(boxses[i][j]);
                }
                break;
            }
        } 
        
        i = x+1;
        j = y+1;
        while(i<=7&&j<=7) {
            if(boxses[i][j].getPiece() == null) {
                movable.add(boxses[i][j]);
                i++;
                j++;
            } else {
                if(getColor() != boxses[i][j].getPiece().getColor()) {
                    movable.add(boxses[i][j]);
                }
                break;
            }
        }
        
        i = x+1;
        j = y-1;
        while(i<=7&&j>=0) {
            if(boxses[i][j].getPiece() == null) {
                movable.add(boxses[i][j]);
                i++;
                j--;
            } else {
                if(getColor() != boxses[i][j].getPiece().getColor()) {
                    movable.add(boxses[i][j]);
                }
                break;
            }
        }
        
        i = x-1;
        j = y+1;
        while(i>=0&&j<=7) {
            if(boxses[i][j].getPiece() == null) {
                movable.add(boxses[i][j]);
                i--;
                j++;
            } else {
                if(getColor() != boxses[i][j].getPiece().getColor()) {
                    movable.add(boxses[i][j]);
                }
                break;
            }
        }
        
        
        return movable;
    }
}
