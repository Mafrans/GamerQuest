package me.mafrans.consolegame.areas;

import me.mafrans.consolegame.util.CommandRunnable;
import me.mafrans.consolegame.util.Description;
import me.mafrans.consolegame.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private List<Area> attached;
    private int id;
    private String name;
    private boolean available;
    private Description description;
    private CommandRunnable commandRunnable;

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
        this.attached = new ArrayList<>();
    }

    public Area(int id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.attached = new ArrayList<>();
        this.available = available;
    }

    public Area(int id, String name, List<Area> attached) {
        this.id = id;
        this.name = name;
        this.attached = attached;
    }

    public Area(int id, String name, boolean available, List<Area> attached) {
        this.id = id;
        this.name = name;
        this.attached = attached;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }

    public Area attach(Area area) {
        attached.add(area);
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Description getDescription() {
        return description;
    }

    public Area setDescription(Description description) {
        this.description = description;
        return this;
    }

    public void setCommandRunnable(CommandRunnable commandRunnable) {
        this.commandRunnable = commandRunnable;
    }

    public void onCommand(String input) {
        String cmd = Util.getCommand(input);
        String[] args = Util.getArgs(input);

        commandRunnable.run(cmd, args);
    }
}
