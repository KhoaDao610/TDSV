package Entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends entity {
    GamePanel gp;
    KeyHandler keyHandler;

    public Player(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
    }

    public void setDefaultValues() {

        x=100;
        y=100;
        speed=4;

    }
    public void update() {

        if (keyHandler.up) {
            y -= speed;
        }
        else if (keyHandler.down){
            y += speed;
        }
        else if (keyHandler.left){
            x -= speed;
        }
        else if (keyHandler.right){
            x += speed;
        }


    }
    public void draw(Graphics2D g2d)    {

        g2d.setColor(Color.WHITE);

        g2d.fillRect(x,y, gp.tileSize, gp.tileSize);

    }
}
