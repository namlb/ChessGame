/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author namlb
 */
public abstract class Piece {
    private final int color;
    private final String img;
    private BufferedImage bufferedImage;
    private Box box;
    protected List<Box> movable;

    public Piece(int color, String img, Box box) {
        this.color = color;
        this.img = img;
        this.box = box;
        try {
            if (this.bufferedImage == null) {
                bufferedImage = ImageIO.read(getClass().getResource(".."+File.separator+".."+File.separator+"resources"+File.separator+img));
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
        
    public boolean checkMove(Box destBox) {
        getMovableBox(destBox.getBoard());
        System.out.println("dest: " + destBox.getxNum()+ " " + destBox.getyNum());
        for(int i = 0; i<movable.size(); i++) {
            Box tmp = movable.get(i);
            System.out.println("x: "+tmp.getxNum()+" y: "+tmp.getyNum());
            if(tmp.getxNum() == destBox.getxNum() && tmp.getyNum() == destBox.getyNum()) {
                return true;
            }
        }
        return false;
    }
    
    public abstract List<Box> getMovableBox(Board board);
    
    public boolean move(Box desBox) {
        if(checkMove(desBox)) {
            this.getBox().setPiece(null);
            this.getBox().setDispPiece(false);
            desBox.setPiece(this);
            this.setBox(desBox);
            desBox.setDispPiece(true);
            return true;
        } else return false;
    }
    
    public void display(Graphics g){
        int x = box.getX();
        int y = box.getY();
        g.drawImage(bufferedImage, x, y, null);
    }
    

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getColor(){
        return color;
    }
    
    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public List<Box> getMovable() {
        return movable;
    }

}
