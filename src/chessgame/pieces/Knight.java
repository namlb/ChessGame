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
public class Knight extends Piece{
        public Knight(int color, String img, Box box) {
        super(color, img, box);
    }   

    @Override
    public List<Box> getMovableBox(Board board) {
        movable = new ArrayList<>();
        Box[][] boxses = board.getBoxses();
        int x = this.getBox().getxNum();
        int y = this.getBox().getyNum();

        checkPosition(boxses, movable, x-2, y-1);
        checkPosition(boxses, movable, x-2, y+1);
        checkPosition(boxses, movable, x-1, y+2);
        checkPosition(boxses, movable, x+1, y+2);
        checkPosition(boxses, movable, x+2, y+1);
        checkPosition(boxses, movable, x+2, y-1);
        checkPosition(boxses, movable, x+1, y-2);
        checkPosition(boxses, movable, x-1, y-2);
        
        return movable;
    }
    
    public void checkPosition(Box[][] boxses, List<Box> movableList, int i, int j) {
        if( i>=0&&i<=7
            &&j>=0&&j<=7
            &&(boxses[i][j].getPiece()==null || boxses[i][j].getPiece().getColor()!=this.getColor())) {
            movableList.add(boxses[i][j]);
        }
    }
}
