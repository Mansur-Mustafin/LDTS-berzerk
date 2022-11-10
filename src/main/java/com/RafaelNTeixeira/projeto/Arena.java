package com.RafaelNTeixeira.projeto;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int height;
    private int width;

    private final Hero hero;

    private List<Wall> walls = new ArrayList<>();

    private void createWalls() {

        InputStream istream = ClassLoader.getSystemResourceAsStream("level4.txt");
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
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<Monster> monsters;

    private List<Monster> createMonster() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 15; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }

    public Arena(int x, int y) {
        width = x;
        height = y;
        hero = new Hero(5, y / 2);

        createWalls();
        this.monsters = createMonster();
    }

    private boolean canHeroMove(Position position) {
        if (position.getX() < 0) return false;
        if (position.getY() < 0) return false;
        if (position.getX() > width - 1) return false;
        if (position.getY() > height - 1) return false;

        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) return false;

        return true;
    }

    public void verifyMonsterCollisions(Position position) {
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).position.equals(position)) {
                System.out.println("You died");
                System.exit(0);
            }
        }
    }

    public boolean canMonsterMove(Position position) {
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > width - 1 || position.getY() > height - 1)
            return false;
        for (Wall wall : walls) if (wall.getPosition().equals(position)) return false;
        return true;
    }

    public void moveMonster() {
        Random random = new Random();
        for (Monster monster : monsters) {
            int x = random.nextInt(3) - 1;
            int y = random.nextInt(3) - 1;
            Position position = new Position(monster.position.getX() + x, monster.position.getY() + y);
            if (canMonsterMove(position)) {
                monster.position.setX(position.getX());
                monster.position.setY(position.getY());
            }
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            verifyMonsterCollisions(position);
            hero.setPosition(position);
            moveMonster();
        }
    }

    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp) moveHero(hero.moveUp());
        if (key.getKeyType() == KeyType.ArrowDown) moveHero(hero.moveDown());
        if (key.getKeyType() == KeyType.ArrowLeft) moveHero(hero.moveLeft());
        if (key.getKeyType() == KeyType.ArrowRight) moveHero(hero.moveRight());
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
