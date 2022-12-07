package com.RafaelNTeixeira.projeto.model.menu;


import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;

    public Menu() {
        this.entries = Arrays.asList("Start", "Exit", "Leader board", "Instructions");
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
        boolean exit = isSelected(1);
        return exit;
    }

    public boolean isSelectedStart() {
        boolean start = isSelected(0);
        return start;
    }

    public boolean isSelectedInstructions() {
        boolean instructions = isSelected(3);
        return instructions;
    }
    public int getCurrentEntry(){
        return currentEntry;
    }
    public boolean isSelectedLeaderBoard() {
        boolean leaderBoard = isSelected(2);
        return leaderBoard;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
