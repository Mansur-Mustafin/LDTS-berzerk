package com.RafaelNTeixeira.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Win {
    private final List<String> entries;
    private int currentEntry = 0;
    private int Score;

    public Win(int Score) {
        this.entries = Arrays.asList("menu", "Leader board", "Add Score to Leaderboard");
        this.Score = Score;
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
    public int getScore(){return Score;}
    public boolean isSelected(int i) {
        return currentEntry == i;
    }
    public int getCurrentEntry(){
        return currentEntry;
    }
    public boolean isSelectedMenu() {
        boolean menu = isSelected(0);
        return menu;
    }
    public boolean isSelectedLeaderBoard() {
        return isSelected(1);
    }
    public boolean isSelectedAddToLeaderBoard(){
        boolean addToLeaderBoard = isSelected(2);
        return addToLeaderBoard;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}
