package com.RafaelNTeixeira.projeto.model.game.arena;

import com.RafaelNTeixeira.projeto.Graphics.GUILaterna;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Monster;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
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

    private final Hero hero;

    private List<Wall> walls = new ArrayList<>();

    private List<Monster> monsters = new ArrayList<>();

    public Arena(int x, int y) {
        width = x;
        height = y;
        hero = new Hero(x / 2, y / 2);
        createWalls();
        createMonster();
    }

    private void createMonster() {
        InputStream istream = ClassLoader.getSystemResourceAsStream("level1.txt");
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {
                int j = 0;
                for (char c: line.toCharArray()) {
                    if(c == 'm'){
                        monsters.add(new Monster(j, i));
                    }
                    j++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createWalls() {
        InputStream istream = ClassLoader.getSystemResourceAsStream("level1.txt");
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {
                int j = 0;
                for (char c: line.toCharArray()) {
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

    public Hero getHero(){
        return hero;
    }

    public List<Wall> getWalls(){
        return walls;
    }

    public List<Monster> getMonsters(){
        return monsters;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

}