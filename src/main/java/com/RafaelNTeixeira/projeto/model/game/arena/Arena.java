package com.RafaelNTeixeira.projeto.model.game.arena;

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.King;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.RafaelNTeixeira.projeto.model.game.elements.Hero;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Arena {
    private int height;
    private int width;

    private int level;
    private Hero hero;

    private List<Wall> walls = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private List<King> kings = new ArrayList<>();
    public Arena(int x, int y, int lvl) {

        width = x;
        height = y;
        level = lvl;
        createElements();
    }


    private void createElements(){
        StringBuilder str = new StringBuilder();
        str.append("level");
        str.append(level);
        str.append(".txt");

        String arenaPath = str.toString();
        System.out.println(arenaPath);

        InputStream istream = ClassLoader.getSystemResourceAsStream(arenaPath);
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {
                System.out.println(line);
                int j = 0;
                for (char c: line.toCharArray()) {
                    if(c == 'h'){
                        hero = new Hero(j,i);
                    }
                    if(c == 'm'){
                        monsters.add(new Monster(j, i));
                    }
                    if(c == 'k'){
                        kings.add(new King(j, i));
                    }
                    if(c == 'w'){
                        walls.add(new Wall(j, i));
                    }
                    j++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getlLevel(){
        return level;
    }
    public Hero getHero(){
        return hero;
    }
    public List<Wall> getWalls(){
        return walls;
    }
    public List<Monster> getMonsters(){
        return monsters;
    }
    public List<King> getKings(){
        return kings;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

}