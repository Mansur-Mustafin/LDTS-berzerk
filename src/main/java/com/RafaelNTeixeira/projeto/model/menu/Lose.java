package com.RafaelNTeixeira.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Lose {
    private final List<String> entries;
    private int currentEntry = 0;
    public Lose() {
        this.entries = Arrays.asList("Press enter");
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

    public boolean isSelectedEnter() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
