package me.mafrans.consolegame.areas;

import me.mafrans.consolegame.App;
import me.mafrans.consolegame.util.CommandRunnable;
import me.mafrans.consolegame.util.Description;

public class TitleScreen extends AbstractArea {
    @Override
    public Description getDescription() {
        String title =  "  /$$$$$$                                             \n" +
                        " /$$__  $$                                            \n" +
                        "| $$  \\__/  /$$$$$$  /$$$$$$/$$$$   /$$$$$$   /$$$$$$ \n" +
                        "| $$ /$$$$ |____  $$| $$_  $$_  $$ /$$__  $$ /$$__  $$\n" +
                        "| $$|_  $$  /$$$$$$$| $$ \\ $$ \\ $$| $$$$$$$$| $$  \\__/\n" +
                        "| $$  \\ $$ /$$__  $$| $$ | $$ | $$| $$_____/| $$      \n" +
                        "|  $$$$$$/|  $$$$$$$| $$ | $$ | $$|  $$$$$$$| $$      \n" +
                        " \\______/  \\_______/|__/ |__/ |__/ \\_______/|__/      \n" +
                        " \n" +
                        "  /$$$$$$                                  /$$    \n" +
                        " /$$__  $$                                | $$    \n" +
                        "| $$  \\ $$ /$$   /$$  /$$$$$$   /$$$$$$$ /$$$$$$  \n" +
                        "| $$  | $$| $$  | $$ /$$__  $$ /$$_____/|_  $$_/  \n" +
                        "| $$  | $$| $$  | $$| $$$$$$$$|  $$$$$$   | $$    \n" +
                        "| $$/$$ $$| $$  | $$| $$_____/ \\____  $$  | $$ /$$\n" +
                        "|  $$$$$$/|  $$$$$$/|  $$$$$$$ /$$$$$$$/  |  $$$$/\n" +
                        " \\____ $$$ \\______/  \\_______/|_______/    \\___/  ";

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : title.toCharArray()) {
            if(c == '$') {
                stringBuilder.append("@|cyan ").append(c).append("|@");
            }
            else {
                stringBuilder.append("@|blue ").append(c).append("|@");
            }
        }

        stringBuilder
                .append("\n")
                .append(Description.HORIZONTAL_LINE)
                .append("\nWelcome to Gamer Quest!")
                .append("\n(1) Start Game")
                .append("\n(2) Settings")
                .append(Description.HORIZONTAL_LINE)
                .append("\n\n\n");

        return new Description(stringBuilder.toString());
    }

    @Override
    public CommandRunnable getCommand() {
        return new CommandRunnable() {
            @Override
            public void run(String command, String[] args) {
                if(command.equals("1")) {
                    App.self.startRun();
                }
            }
        };
    }
}
