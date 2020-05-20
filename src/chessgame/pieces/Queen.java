/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.pieces;

import chessgame.Board;
import chessgame.Box;
import chessgame.Piece;
import java.util.List;

/**
 *
 * @author namlb
 */
public class Queen extends Piece{
        public Queen(int color, String img, Box box) {
        super(color, img, box);
    }   

    @Override
    public List<Box> getMovableBox(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
