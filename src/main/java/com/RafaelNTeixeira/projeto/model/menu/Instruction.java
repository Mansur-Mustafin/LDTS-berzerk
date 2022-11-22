package com.RafaelNTeixeira.projeto.model.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Instruction {
    private final List<String> entries;
    private int currentEntry = 0;
    public Instruction() throws IOException {
        this.entries = Arrays.asList("Press Enter to go back to the menu");
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public boolean isSelectedEnter() {
        return true;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}