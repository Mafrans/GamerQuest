package me.mafrans.consolegame.areas;

import me.mafrans.consolegame.util.CommandRunnable;
import me.mafrans.consolegame.util.Description;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArea {
    public int getId() {
        return 0;
    }
    public String getName() {
        return "";
    }
    public boolean isAvailable() {
        return true;
    }
    public List<Area> getAttachedAreas() {
        return Arrays.asList();
    }
    public Description getDescription() {
        return new Description();
    }
    public CommandRunnable getCommand() {
        return new CommandRunnable() {
            @Override
            public void run(String command, String[] args) {

            }
        };
    }

    public Area build() {
        Area area = new Area(getId(), getName(), isAvailable(), getAttachedAreas());
        area.setDescription(getDescription());
        area.setCommandRunnable(getCommand());
        return area;
    }
}
