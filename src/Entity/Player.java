package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    //Set default values for player:
    public void setDefaultValues() {

        x=100;
        y=100;
        speed=4;
        direction = "down";

    }

    //getPlayerImageMethod:
    public void getPlayerImage(){
        try{

            oriDown =ImageIO.read(getClass().getResource("/player/OriginalDown.png"));
            oriUp =ImageIO.read(getClass().getResource("/player/OriginalUp.png"));
            oriLeft =ImageIO.read(getClass().getResource("/player/OriginalLeft.png"));
            oriRight =ImageIO.read(getClass().getResource("/player/OriginalRight.png"));
            up1 =ImageIO.read(getClass().getResource("/player/up1.png"));
            up2 =ImageIO.read(getClass().getResource("/player/up2.png"));
            down1 =ImageIO.read(getClass().getResource("/player/down1.png"));
            down2 =ImageIO.read(getClass().getResource("/player/down2.png"));
            left1 =ImageIO.read(getClass().getResource("/player/left1.png"));
            left2 =ImageIO.read(getClass().getResource("/player/left2.png"));
            right1 =ImageIO.read(getClass().getResource("/player/right1.png"));
            right2 =ImageIO.read(getClass().getResource("/player/right2.png"));


        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    //UpdateMethod:
    public void update() {

        if (keyHandler.up || keyHandler.down||keyHandler.left||keyHandler.right) {
            if (keyHandler.up) {
                direction = "up";
                y -= speed;
            }
            else if (keyHandler.down){
                direction = "down";
                y += speed;
            }
            else if (keyHandler.left){
                direction = "left";
                x -= speed;
            }
            else if (keyHandler.right){
                direction = "right";
                x += speed;
            }

            //spriteConter:
            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 3;
                } else if (spriteNumber == 3) {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }

        }


    }
    //DrawMethod:
    public void draw(Graphics2D g2d)    {


        BufferedImage img = null;

        switch(direction){
            case "up":
               if(spriteNumber==1) img = oriUp;
               if(spriteNumber==2) img = up1;
               if(spriteNumber==3) img = up2;
                break;
            case "down":
                if(spriteNumber==1) img = oriDown;
                if(spriteNumber==2) img = down1;
                if(spriteNumber==3) img = down2;
                break;
            case "left":
                if(spriteNumber==1) img = oriLeft;
                if(spriteNumber==2) img = left1;
                if(spriteNumber==3) img = left2;
                break;
            case "right":
                if(spriteNumber==1) img = oriRight;
                if(spriteNumber==2) img = right1;
                if(spriteNumber==3) img = right2;
                break;
        }
        g2d.drawImage(img,x,y,gp.tileSize,gp.tileSize,null);

    }
}
