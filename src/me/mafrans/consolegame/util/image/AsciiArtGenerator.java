package me.mafrans.consolegame.util.image;

import me.mafrans.consolegame.Console;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AsciiArtGenerator {
    public String createFrom(String text, Image image) {
        BufferedImage bi = (BufferedImage)image;

        for (int y = 0; y < bi.getHeight(); y++) {
            for (int x = 0; x < bi.getWidth(); x++) {
                int  clr   = bi.getRGB(x, y);
                int  red   = (clr & 0x00ff0000) >> 16;
                int  green = (clr & 0x0000ff00) >> 8;
                int  blue  =  clr & 0x000000ff;

                Console.log(red + ", " + green + ", " + blue);
            }
        }
        return "";
    }

    public Image getIncludedImage(String name) {
        return null;
    }

    public String getIncludedText(String name) {
        return null;
    }
}
