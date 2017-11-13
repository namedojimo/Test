package towerbloxx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Block extends Pane {

    int blockX = 100;
    int blockY = 200;
    int blockWidth = 50;
    int blockHeight = 50;
    int blockSpeed = 10;
    int totalBlock = 0;
    int score = 0;
    boolean isDetach = false;

    int angle = 0;
    int rotation = 0;
    int radius = 150;

    int ovalX = 150;
    int ovalY = 150;
    int ovalWidth = 100;
    int ovalHeight = 100;
    int ovalCenterX = ovalX + ovalWidth / 2;
    int ovalCenterY = ovalY + ovalHeight / 2;

    int recX;
    int recY;
    int recWidth = 50;
    int recHeight = 50;
    int recCenterX;
    int recCenterY;

    int WORLD_SIZE_X = 6000;
    int WORLD_SIZE_Y = 6000;

    int camX;
    int camY;

    public Block() {
        try {
            InputStream block = Files.newInputStream(Paths.get("/Users/namedojimo/NetBeansProjects/Project/src/towerbloxx/box.png"));
            ImageView imgBlock = new ImageView(new Image(block));
            imgBlock.setFitWidth(blockWidth);
            imgBlock.setFitHeight(blockWidth);
            imgBlock.setTranslateX(blockX);
            getChildren().add(imgBlock);
        } catch (IOException e) {
            System.out.println("Cannot load box.png");
        }
    }

    public void move() {
        AnimationTimer blockMovement = new AnimationTimer() {
            public void handle(long arg0) {

                angle++;

//                
                  blockX += blockSpeed + Math.sin(Math.toRadians(angle)) * radius;
                  blockY += blockSpeed + Math.cos(Math.toRadians(angle)) * radius;

            }
        };
        blockMovement.start();
    }

    public void detach() {
        isDetach = true;
        totalBlock++;
        score += 10;
    }

    public Block makeNew() {
        Block newBlock = new Block();
        newBlock.blockX = 0;
        isDetach = false;
        return newBlock;
    }
}
