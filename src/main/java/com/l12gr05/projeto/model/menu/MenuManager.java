package com.l12gr05.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public abstract class MenuManager {

    public MenuManager(){
        entries = Arrays.asList("menu");
    }

    private final List<String> entries;
    private int currentEntry = 0;

    public void nextEntry(){
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
}
