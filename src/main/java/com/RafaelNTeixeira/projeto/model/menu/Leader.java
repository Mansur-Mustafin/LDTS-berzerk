package com.RafaelNTeixeira.projeto.model.menu;

import com.RafaelNTeixeira.projeto.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Leader {
    private final List<Player> players = new ArrayList<>();

    public List<Player> getPlayers(){
        return players;
    }
    private List<String> entries;

    private int currentEntry = 0;
    public Leader() throws IOException {
        this.entries = Arrays.asList("Press enter to Back menu");

        InputStream istream = ClassLoader.getSystemResourceAsStream("Leaders");
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s");
                Player p = new Player (words[0], words[1]);
                boolean contains = Contains(players, p);

                if (contains) {
                    int index = Index(players, p);
                    players.get(index).setScore(words[1]);
                }
                else {
                    players.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        reader.close();
        Collections.sort(players, new SortByScore());
    }

    public int Index(List<Player> lst, Player p) {
        for (int i = 0; i < lst.size(); i++) {
            String name = lst.get(i).getName();
            if (name.equals(p.getName())) {
                return i;
            }
        }
        return -1;
    }
    public boolean Contains(List<Player> lst, Player p) {
        for (Player player : lst) {
            String name = player.getName();
            if (name.equals(p.getName())) {
                return true;
            }
        }
        return false;
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
    public int compare(Player a, Player b)
    {
        return Integer.parseInt(b.getScore()) - Integer.parseInt(a.getScore());
    }
}
