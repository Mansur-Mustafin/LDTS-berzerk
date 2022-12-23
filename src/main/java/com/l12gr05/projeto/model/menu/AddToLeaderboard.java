package com.l12gr05.projeto.model.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class AddToLeaderboard {
    private final List<String> entries;
    private int currentEntry = 0;

    private PrintWriter out;

    private String name = new String();
    private int Score;
    public AddToLeaderboard(int Score) throws IOException {
        this.entries = Arrays.asList("menu", "leader board");
        this.Score = Score;
        openOut();
    }

    void setOut(PrintWriter out_) {
        out = out_;
    }

    void openOut() {
        try {
            //this.out = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/Leaders", true)));
            this.out = new PrintWriter(Files.newBufferedWriter(Paths.get("src/main/resources/Leaders"), UTF_8, CREATE, APPEND));
        }
        catch (IOException e) {
            System.err.println(e);
        }
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

    public void addChar(Character character) {
        name += character;
    }

    public void delChar() {
        name = name.substring(0, name.length()-1);
    }
    public void setName(String name) {this.name = name;}
    public String getName() {
        return name;
    }
    public int getScore() {return Score;}
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedMenu() {
        boolean selectedMenu = isSelected(0);
        return selectedMenu;
    }
    public boolean isSelectedLeaderBoard() {
        boolean selectedLeaderboard = isSelected(1);
        return selectedLeaderboard;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public void addScore() {
        addScore(out);
        closeScore(out);
    }

    private void closeScore(PrintWriter out) {
        if (out != null) {
            out.close();
        }
    }

    private void addScore(PrintWriter out) {
        if (name.isEmpty()){
            out.println("Noname;" + Score);
        }
        else {
            out.println( name + ";" + Score);
        }
    }
}
