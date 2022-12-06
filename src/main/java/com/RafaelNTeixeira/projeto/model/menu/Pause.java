package com.RafaelNTeixeira.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Pause {
    private final List<String> entries;
    private int currentEntry = 0;
    public Pause() {
        this.entries = Arrays.asList("Continue","New game", "Exit", "Exit to menu");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        boolean exit = isSelected(2);
        return exit;
    }

    public boolean isSelectedContinue() {
        boolean continue_ = isSelected(0);
        return continue_;
    }

    public boolean isSelectedNewGame() {
        boolean newGame = isSelected(1);
        return newGame;
    }
    public int getCurrentEntry(){
        return currentEntry;
    }
    public boolean isSelectedGoToMenu() {
        boolean menu = isSelected(3);
        return menu;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
