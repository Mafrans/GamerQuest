package me.mafrans.consolegame.areas;

import java.util.ArrayList;
import java.util.List;

public class AreaHandler {
    List<Area> areas;

    public Area currentArea;

    public AreaHandler() {
        this.areas = new ArrayList<>();
    }

    public AreaHandler(List<Area> areas) {
        this.areas = areas;
    }

    public void addArea(Area area) {
        areas.add(area);
    }

    public void moveTo(int id) {
        for(Area a : areas) {
            if(a.getId() == id) {
                currentArea = a;
            }
        }
    }
}
