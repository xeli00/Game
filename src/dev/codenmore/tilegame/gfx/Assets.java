package dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
    
    private final static int width = 32;

    private final static int height = 32;
    
    public static BufferedImage player, dirt, grass, stone, tree, cannon,ballBlue;
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
        player=ImageLoader.loadImage("/textures/test2.png");
        cannon=ImageLoader.loadImage("/textures/cannon.png");
        ballBlue=ImageLoader.loadImage("/textures/blu1.png");
        dirt=sheet.crop(width, 0, width, height);
        grass=sheet.crop(width*2, 0, width, height);
        stone=sheet.crop(width*3, 0, width, height);
        tree=sheet.crop(0, height, width, height);
    }

}
