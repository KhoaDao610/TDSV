package main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16;//16x16 tile
    final int scale=3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = maxScreenCol * tileSize; //768 pixels
    final int screenHeight = maxScreenRow * tileSize; //576 pixels

    //Player's information:
    int playerSpeed = 4;
    int playerX = screenWidth / 2;
    int playerY = screenHeight / 2;

    //FPS
    int FPS = 60;


    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player =new Player(this,keyHandler);

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        player.draw(g2d);

        g2d.dispose();

    }

    public void update() {

       player.update();

    }


    @Override
    public void run() {

        double drawInterval =1000000000 / FPS;// 0,16667s
        double delta = 0;
        long lastTime = System.nanoTime();//1e9 ns

        while(gameThread!=null) {

            long now = System.nanoTime();
            delta += (now - lastTime) / drawInterval;
            lastTime = now;

            while (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }
    }

}

