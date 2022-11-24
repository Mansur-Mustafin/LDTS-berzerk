package com.RafaelNTeixeira.projeto.model.menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class AddLeader {
    private final List<String> entries;
    private int currentEntry = 0;

    private String Name = new String();
    private int Score = 999;
    public AddLeader(int Score) {
        this.entries = Arrays.asList("menu", "leader board");
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

    public void addChar(Character character){
        Name += character;
    }

    public void delChar(){
        Name = Name.substring(0,Name.length()-1);
    }
    public String getName(){
        return Name;
    }
    public int getScore(){return Score;}
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedMenu() {
        return isSelected(0);
    }
    public boolean isSelectedLeaderBoard() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }


    public void addScore(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/Leaders", true)));
            if(Name.isEmpty()){
                out.println("Noname" + " 999");
            }else {
                out.println( Name + " " + Score);
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
