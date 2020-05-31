/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import chessgame.pieces.King;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author namlb
 */
public class CheckMate {
    private final King whiteKing;
    private final King blackKing;
    private final Board board;

    public CheckMate(King whiteKing, King blackKing, Board board) {
        this.whiteKing = whiteKing;
        this.blackKing = blackKing;
        this.board = board;
    }
    
    public boolean checkMate(int turn) {
        List<Box> ableToEat = new ArrayList<>();
        Box[][] boxses = board.getBoxses();
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if(boxses[i][j].getPiece()!=null && boxses[i][j].getPiece().getColor()==turn) {
                    Piece piece = boxses[i][j].getPiece();
                    ableToEat.addAll(piece.getMovableBox(board));
                }
            }
        }
        King king;
        
        king = (turn == Config.White.COLOR) ? blackKing : whiteKing;
        int x = king.getBox().getxNum();
        int y = king.getBox().getyNum();
        for(int i=0; i<ableToEat.size(); i++) {
            if(x==ableToEat.get(i).getxNum() && y==ableToEat.get(i).getyNum()){
                String notif;
                if(turn == Config.White.COLOR){
                    notif = "Trắng chiếu tướng đen";
                } else notif = "Đen chiếu tướng trắng";
                System.out.println(notif);
                JOptionPane.showMessageDialog(board, notif);
                return true;
            }
        }
        return false;
    }
    
    
}
