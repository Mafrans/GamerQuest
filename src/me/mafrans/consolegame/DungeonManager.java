package me.mafrans.consolegame;

import me.mafrans.consolegame.areas.Area;
import org.fusesource.jansi.Ansi;

import java.util.Random;

import static org.fusesource.jansi.Ansi.ansi;

public class DungeonManager {

    public float roomChance = 1;
    public String[][] availableRooms;
    public Area[][] areas;
    public String emptyTile = "-";

    public void generateAvailableRooms(String[][] map, float roomChance, float chanceModifier) {
        if(map != null) {
            fill2DArray(map, emptyTile);
            availableRooms = map;
            availableRooms[(int)Math.floor(map.length/2)][(int)Math.floor(map.length/2)] = "0";
            areas = new Area[map.length][map.length];
        }

        int xSize = availableRooms.length;
        int ySize = availableRooms[0].length;

        String[][] newRooms = cloneMap();
        Random rand = new Random();

        float corridorConstant = 0.2f;



        for(int x = 0; x < availableRooms.length; x++) {
            String[] row = availableRooms[x];

            for(int y = 0; y < row.length; y++) {
                String tile = row[y];

                if(tile.equals("0")) {
                    // Down
                    if(y < ySize-1) {

                        if(rand.nextFloat() < roomChance && newRooms[x][y+1].equals(emptyTile)) {
                            newRooms[x][y+1] = "D";
                        }
                    }

                    // Up
                    if(y > 0) {
                        if(rand.nextFloat() < roomChance && newRooms[x][y-1].equals(emptyTile)) {
                            newRooms[x][y-1] = "U";
                        }
                    }

                    // Right
                    if(x < xSize-1) {
                        if(rand.nextFloat() < roomChance && newRooms[x+1][y].equals(emptyTile)) {
                            newRooms[x+1][y] = "R";
                        }
                    }

                    // Left
                    if(x > 0) {
                        if(rand.nextFloat() < roomChance && newRooms[x-1][y].equals(emptyTile)) {
                            newRooms[x-1][y] = "L";
                        }
                    }
                }
                else if(tile.equals("D")) {

                    // Down
                    if(y < ySize-1) {
                        if(rand.nextFloat() < roomChance && newRooms[x][y+1].equals(emptyTile)) {
                            newRooms[x][y+1] = "D";
                        }
                    }

                    // Right
                    if(x < xSize-1) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x+1][y].equals(emptyTile)) {
                            newRooms[x+1][y] = "R";
                        }
                    }

                    // Left
                    if(x > 0) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x-1][y].equals(emptyTile)) {
                            newRooms[x-1][y] = "L";
                        }
                    }
                }
                else if(tile.equals("U")) {
                    // Up
                    if(y > 0) {
                        if(rand.nextFloat() < roomChance && newRooms[x][y-1].equals(emptyTile)) {
                            newRooms[x][y-1] = "U";
                        }
                    }

                    // Right
                    if(x < xSize-1) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x+1][y].equals(emptyTile)) {
                            newRooms[x+1][y] = "R";
                        }
                    }

                    // Left
                    if(x > 0) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x-1][y].equals(emptyTile)) {
                            newRooms[x-1][y] = "L";
                        }
                    }
                }
                else if(tile.equals("R")) {
                    // Right
                    if(x < xSize-1) {
                        if(rand.nextFloat() < roomChance && newRooms[x+1][y].equals(emptyTile)) {
                            newRooms[x+1][y] = "R";
                        }
                    }

                    // Down
                    if(y < ySize-1) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x][y+1].equals(emptyTile)) {
                            newRooms[x][y+1] = "D";
                        }
                    }

                    // Up
                    if(y > 0) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x][y-1].equals(emptyTile)) {
                            newRooms[x][y-1] = "U";
                        }
                    }
                }
                else if(tile.equals("L")) {
                    // Left
                    if(x > 0) {
                        if(rand.nextFloat() < roomChance && newRooms[x-1][y].equals(emptyTile)) {
                            newRooms[x-1][y] = "L";
                        }
                    }

                    // Down
                    if(y < ySize-1) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x][y+1].equals(emptyTile)) {
                            newRooms[x][y+1] = "D";
                        }
                    }

                    // Down
                    if(y > 0) {
                        if(rand.nextFloat() < roomChance*corridorConstant && newRooms[x][y-1].equals(emptyTile)) {
                            newRooms[x][y-1] = "D";
                        }
                    }
                }

                if(!tile.equals(emptyTile)) {
                    newRooms[x][y] = "?";
                }
            }
        }




        if(roomChance > 0.1) {
            availableRooms = newRooms;
            printMap();
            generateAvailableRooms(null, roomChance - chanceModifier, chanceModifier);
        }
    }

    public String[][] fill2DArray(String[][] array, String tile) {
        for(int x = 0; x < array.length; x++) {
            for(int y = 0; y < array[x].length; y++) {
                array[x][y] = tile;
            }
        }
        return array;
    }

    public void printMap() {
        Ansi ansi = ansi();
        ansi.reset();

        for(int x = 0; x < availableRooms.length; x++) {
            String[] row = availableRooms[x];

            for(int y = 0; y < row.length; y++) {
                String tile = availableRooms[y][x];

                if(tile.equals(emptyTile)) {
                    ansi.reset().fg(Ansi.Color.BLACK).a(emptyTile + " ");
                    continue;
                }

                if(tile.equals("#")) {
                    ansi.reset().fg(Ansi.Color.BLUE).a(tile + " ");
                }
                else {
                    if((y < row.length-1 && availableRooms[y + 1][x].equals("#")) ||
                            (y > 0 && availableRooms[y - 1][x].equals("#")) ||
                            (x < availableRooms.length-1 && availableRooms[y][x+1].equals("#")) ||
                            (x > 0 && availableRooms[y][x-1].equals("#"))) {

                        ansi.reset().fgBright(Ansi.Color.BLUE).a(tile + " ");
                    }
                }

            }
            ansi.a("\n");
        }

        Console.log(ansi);
    }

    private String[][] cloneMap() {
        String[][] out = new String[availableRooms.length][availableRooms[0].length];
        for(int x = 0; x < availableRooms.length; x++) {
            String[] row = availableRooms[x];

            for(int y = 0; y < row.length; y++) {
                String tile = row[y];

                out[x][y] = tile;
            }
        }

        return out;
    }

    public void startAt(int x, int y) {

    }
}
