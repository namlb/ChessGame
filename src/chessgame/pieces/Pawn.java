/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.pieces;

import chessgame.Board;
import chessgame.Box;
import chessgame.Config;
import chessgame.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author namlb
 */
public class Pawn extends Piece{
    
    private boolean firstMove = true;

    public Pawn(int color, String img, Box box) {
        super(color, img, box);
    }   

    @Override
    public boolean move(Box desBox) {
        if(checkMove(desBox)) {
            firstMove = false;
            this.getBox().setPiece(null);
            this.getBox().setDispPiece(false);
            desBox.setPiece(this);
            this.setBox(desBox);
            desBox.setDispPiece(true);
            return true;
        } else return false;
    }

    @Override
    public List<Box> getMovableBox(Board board) {
        movable = new ArrayList<>();
        Box[][] boxses = board.getBoxses();
        int x = this.getBox().getxNum();
        int y = this.getBox().getyNum();
        //and movable boxses
        if(this.getColor() == Config.White.COLOR) {
            if(x>0 && boxses[x-1][y].getPiece()==null) {
                movable.add(boxses[x-1][y]);
            }
        
            if(firstMove && boxses[x-2][y].getPiece()==null && boxses[x-1][y].getPiece()==null) {
               movable.add(boxses[x-2][y]);
            }
            
            if(x>0 && y>0 && boxses[x-1][y-1].getPiece()!=null) {
                movable.add(boxses[x-1][y-1]);
            }
            
            if(x>0 && y<7 && boxses[x-1][y+1].getPiece()!=null) {
                movable.add(boxses[x-1][y+1]);
            }
        } else {
            if(x<7 && boxses[x+1][y].getPiece()==null) {
                movable.add(boxses[x+1][y]);
            }
        
            if(firstMove && boxses[x+1][y].getPiece()==null && boxses[x+2][y].getPiece()==null) {
               movable.add(boxses[x+2][y]);
            }
            
            if(x<7 && y>0 && boxses[x+1][y-1].getPiece()!=null) {
                movable.add(boxses[x+1][y-1]);
            }
            
            if(x<7 && y< 7 && boxses[x+1][y+1].getPiece()!=null) {
                movable.add(boxses[x+1][y+1]);
            }
        }
        return movable;
    }
    
}
