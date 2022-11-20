package com.RafaelNTeixeira.projeto.model.menu;

import com.RafaelNTeixeira.projeto.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Leader {
    private List<Player> players = new ArrayList<Player>();

    public List<Player> getPlayers(){
        return players;
    }
    private List<String> entries;

    private int currentEntry = 0;
    public Leader() {
        this.entries = Arrays.asList("Press enter to Back Menu");

        InputStream istream = ClassLoader.getSystemResourceAsStream("Leaders");
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            String line;
            while((line = reader.readLine()) != null){
                String[] words = line.split("\\s");
                Player p = new Player (words[0], words[1]);
                if(players.contains(p)){
                    players.get(players.indexOf(p)).setScore(words[1]);
                }else{
                    players.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(players, new SortByScore());
    }
    public int getNumberOfplayers(){
        return players.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public void detEntries(List<String> entries){
        this.entries = entries;
    }
    public boolean isSelectedEnter() {
        return true;
    }
}

class SortByScore implements Comparator<Player> {
    // Used for sorting in ascending order of ID
    public int compare(Player a, Player b)
    {
        return Integer.parseInt(b.getScore()) - Integer.parseInt(a.getScore());
    }
}

