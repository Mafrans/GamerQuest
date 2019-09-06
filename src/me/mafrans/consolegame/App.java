package me.mafrans.consolegame;

import me.mafrans.consolegame.areas.AreaHandler;
import me.mafrans.consolegame.areas.TitleScreen;
import me.mafrans.consolegame.util.image.AsciiArtGenerator;
import org.fusesource.jansi.*;

import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Hello world!
 *
 */
public class App {

    public static App self;
    public static void main( String[] args ) {
        AnsiConsole.systemInstall();

        //AsciiArtGenerator.test();

        self = new App();
        Console.renderCurrent(true);
    }





    public AreaHandler areaHandler;
    public DungeonManager dungeonManager;
    public Scanner in;

    public App() {
        areaHandler = new AreaHandler();
        in = new Scanner(System.in);

        TitleScreen titleScreen = new TitleScreen();
        areaHandler.addArea(titleScreen.build());

        areaHandler.moveTo(titleScreen.getId());
    }

    public void startRun() {
        dungeonManager.generateAvailableRooms(new String[11][11], 0.8f, 0.05f);
    }
}
