package data;

import pages.PagesContext;

public class PlayModel {
    
    // tile data
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;

    // board data
    public final int GAME_WIDTH = 15;
    public final int GAME_HEIGHT = 15;
    public final int GAME_GAP = 3;
    public final int[][] BOARD = new int[GAME_HEIGHT][GAME_WIDTH];

    // "enums" for cells
    public final int EMPTY = 0;
    public final int HEAD = 1;
    public final int BODY = 2;
    public final int APPLE = 4;

    // player data
    public int playerHeadX = 100;
    public int playerHeadY = 100;
    public int playerTailX;
    public int playerTailY;
    public int playerSpeed;

    public PlayModel(PagesContext context) {

    }
}
