package entity;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValue();
        getPlayerImage();
    }

    public void getPlayerImage() {
        try {

            up0 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-neutral-up.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-up-1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-up-2.png"));
            down0 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-neutral-down.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-down-1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-down-2.png"));
            left0 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-neutral-left.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-left-1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-left-2.png"));
            right0 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-neutral-right.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-right-1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/white-wizard-walk-right-2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValue() {
        x = 100;
        y = 100;
        speed = 4;
        direction = Direction.DOWN;
    }

    public void update() {
        if (keyH.isPressed()) {
            if (keyH.upPressed) { 
                direction = Direction.UP;
                y -= speed; 
            }
            if (keyH.downPressed) { 
                direction = Direction.DOWN;
                y += speed; 
            }
            if (keyH.leftPressed) { 
                direction = Direction.LEFT;
                x -= speed; 
            }
            if (keyH.rightPressed) { 
                direction = Direction.RIGHT;
                x += speed; 
            }
    
            spriteCounter++;
            if (spriteCounter > 13) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g) {
        // g.setColor(Color.white);
        // g.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null; 
        if (keyH.isPressed()) {
            image = switch (direction) {
                case Direction.UP: yield switch (spriteNum) {
                    case 1: yield up1;
                    case 2: yield up2;
                    default: yield null;
                };
                case Direction.DOWN: yield switch (spriteNum) {
                    case 1: yield down1;
                    case 2: yield down2;
                    default: yield null;
                };
                case Direction.LEFT: yield switch (spriteNum) {
                    case 1: yield left1;
                    case 2: yield left2;
                    default: yield null;
                };
                case Direction.RIGHT: yield switch (spriteNum) {
                    case 1: yield right1;
                    case 2: yield right2;
                    default: yield null;
                };
            };
        }
        else {
            image = switch (direction) {
                case Direction.UP: yield up0;
                case Direction.DOWN: yield down0;
                case Direction.LEFT: yield left0;
                case Direction.RIGHT: yield right0;
            };
        }
        g.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
