package resources.font;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class PixelFont {
    public static final Font PIXEL_FONT;

    static {
        Font pixelFont;
        try {
            // loads font from file
            InputStream is = PixelFont.class.getResourceAsStream("pixel-1.ttf");
            if (is == null) {
                // fallback for local IDE testing...
                // or whatever that means (gemini copied code)
                is = new java.io.FileInputStream(new File("src/resources/font/pixel-1.ttf"));
            }

            pixelFont = Font.createFont(Font.TRUETYPE_FONT, is);

            // create font with specific size
            pixelFont = pixelFont.deriveFont(24f);

            // registers font to the graphics environment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont);
            
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            System.err.println("Custom font not loaded. Using default font.");
            pixelFont = new Font("SansSerif", Font.BOLD, 24);
        }

        PIXEL_FONT = pixelFont;
    }

    public static Font createFont(float size) {
        return PIXEL_FONT.deriveFont(size);
    }
}
