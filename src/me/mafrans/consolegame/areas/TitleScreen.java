package me.mafrans.consolegame.areas;

import me.mafrans.consolegame.App;
import me.mafrans.consolegame.util.CommandRunnable;
import me.mafrans.consolegame.util.Description;
import me.mafrans.consolegame.util.image.AsciiArtGenerator;
import org.fusesource.jansi.Ansi;

public class TitleScreen extends AbstractArea {
    @Override
    public Description getDescription() {
        Ansi ansi = AsciiArtGenerator.createFrom("title");

        ansi.a("\n").a(Description.HORIZONTAL_LINE).a("\nWelcome to Gamer Quest!").a("\n(1) Start Game").a("\n(2) Settings").a(Description.HORIZONTAL_LINE).a("\n\n\n");

        return new Description(ansi.reset().toString());
    }

    @Override
    public CommandRunnable getCommand() {
        return new CommandRunnable() {
            @Override
            public void run(String command, String[] args) {
                if (command.equals("1")) {
                    App.self.startRun();
                }
            }
        };
    }
}
