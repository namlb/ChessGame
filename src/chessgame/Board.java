/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import chessgame.pieces.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author namlb
 */
public class Board extends JPanel implements MouseListener, MouseMotionListener {
    
    private final MainFrame mainFrame;
    private final Box[][] boxses = new Box[8][8];
    private int currX;
    private int currY;
    private int turn = 0;
    private final CheckMate checkMate;
    private Piece currPiece;
    
    public Board(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(8, 8, 0, 0));
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                int xMod = x % 2;
                int yMod = y % 2;

                if ((xMod == 0 && yMod == 0) || (xMod == 1 && yMod == 1)) {
                    boxses[x][y] = new Box(this, Config.White.COLOR, x, y);
                    this.add(boxses[x][y]);
                } else {
                    boxses[x][y] = new Box(this, Config.Black.COLOR, x, y);
                    this.add(boxses[x][y]);
                }
            }
        }
        this.setSize(new Dimension(400, 400));
        initPieces();
        checkMate = new CheckMate((King) boxses[7][4].getPiece(), (King) boxses[0][4].getPiece(), this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Box box = boxses[y][x];
                box.paintComponent(g);
            }
        }

        if (currPiece != null) {
            if (currPiece.getColor() == turn) {
                final Image i = currPiece.getBufferedImage();
                g.drawImage(i, currX, currY, null);
            }
        }
    }
    
    public void initPieces(){
        for(int i = 0; i< 8; i++){
            boxses[1][i].setPiece(new Pawn(Config.Black.COLOR, Config.Black.PAWN_PNG, boxses[1][i]));
            boxses[6][i].setPiece(new Pawn(Config.White.COLOR, Config.White.PAWN_PNG, boxses[6][i]));
        }
        
        boxses[0][0].setPiece(new Rook(Config.Black.COLOR, Config.Black.ROOK_PNG, boxses[0][0]));
        boxses[0][7].setPiece(new Rook(Config.Black.COLOR, Config.Black.ROOK_PNG, boxses[0][7]));
        boxses[7][0].setPiece(new Rook(Config.White.COLOR, Config.White.ROOK_PNG, boxses[7][0]));
        boxses[7][7].setPiece(new Rook(Config.White.COLOR, Config.White.ROOK_PNG, boxses[7][7]));
        
        boxses[0][1].setPiece(new Knight(Config.Black.COLOR, Config.Black.KNIGHT_PNG, boxses[0][1]));
        boxses[0][6].setPiece(new Knight(Config.Black.COLOR, Config.Black.KNIGHT_PNG, boxses[0][6]));
        boxses[7][1].setPiece(new Knight(Config.White.COLOR, Config.White.KNIGHT_PNG, boxses[7][1]));
        boxses[7][6].setPiece(new Knight(Config.White.COLOR, Config.White.KNIGHT_PNG, boxses[7][6]));
        
        boxses[0][2].setPiece(new Bishop(Config.Black.COLOR, Config.Black.BISHOP_PNG, boxses[0][2]));
        boxses[0][5].setPiece(new Bishop(Config.Black.COLOR, Config.Black.BISHOP_PNG, boxses[0][5]));
        boxses[7][2].setPiece(new Bishop(Config.White.COLOR, Config.White.BISHOP_PNG, boxses[7][2]));
        boxses[7][5].setPiece(new Bishop(Config.White.COLOR, Config.White.BISHOP_PNG, boxses[7][5]));
        
        boxses[0][3].setPiece(new Queen(Config.Black.COLOR, Config.Black.QUEEN_PNG, boxses[0][3]));
        boxses[0][4].setPiece(new King(Config.Black.COLOR, Config.Black.KING_PNG, boxses[0][4]));
        
        boxses[7][3].setPiece(new Queen(Config.White.COLOR, Config.White.QUEEN_PNG, boxses[7][3]));
        boxses[7][4].setPiece(new King(Config.White.COLOR, Config.White.KING_PNG, boxses[7][4]));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currX = e.getX();
        currY = e.getY();
        Box box = (Box) this.getComponentAt(new Point(e.getX(), e.getY()));
        if(box.hasPiece()){
            currPiece = box.getPiece();
            if(currPiece.getColor() == turn) {
                box.setDispPiece(false);
            } else return;
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(currPiece.getColor() != turn) {
            return;
        }
        Box currentBox = currPiece.getBox();
        Box destBox = (Box) this.getComponentAt(new Point(e.getX(), e.getY()));
        Piece targetPiece = destBox.getPiece();
        if(currPiece.move(destBox)) {
            if(isKing(targetPiece)) {
                repaint();
                mainFrame.endGame(turn);
                return;
            }
            checkMate.checkMate(turn);
            turn = turn == 0 ? 1:0;
        } else {
            currentBox.setDispPiece(true);
        }
        currPiece = null;
        repaint();
    }
    
    public boolean isKing(Piece piece) {
        if(piece!=null) {
            return piece.getClass()==King.class;
        }
        return false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currX = e.getX() - 25;
        currY = e.getY() - 25;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public Box[][] getBoxses() {
        return boxses;
    }    
    
}
