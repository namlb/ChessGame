/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame.pieces;

import chessgame.Box;
import chessgame.Piece;

/**
 *
 * @author namlb
 */
public class Queen extends Piece{
        public Queen(int color, String img, Box box) {
        super(color, img, box);
    }   

    @Override
    public boolean checkMove(int sourceX, int sourceY, int destX, int destY) {
        return true;
    }
}
