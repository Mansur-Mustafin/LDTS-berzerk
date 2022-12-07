package com.RafaelNTeixeira.projeto.model.menu;

import java.util.Arrays;
import java.util.List;

public class Lose {
    private final List<String> entries;
    private int currentEntry = 0;

    private final int Score;

    public Lose(int Score) {
        this.entries = Arrays.asList("menu", "Leader board", "Add Score to Leader board");
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

    public int getScore(){return Score;}
    public String getEntry(int i) {
        return entries.get(i);
    }
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
        boolean leaderboard = isSelected(1);
        return leaderboard;
    }
    public boolean isSelectedAddToLeaderBoard() {
        boolean addToLeaderBoard = isSelected(2);
        return addToLeaderBoard;
    }
    public int getNumberEntries() {
        return this.entries.size();
    }
}
