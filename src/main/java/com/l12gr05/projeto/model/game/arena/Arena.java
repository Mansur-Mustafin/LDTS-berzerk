package com.l12gr05.projeto.model.game.arena;

import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Bullet;
import com.l12gr05.projeto.model.game.elements.Enemy.Boss;
import com.l12gr05.projeto.model.game.elements.Enemy.King;
import com.l12gr05.projeto.model.game.elements.Enemy.Monster;
import com.l12gr05.projeto.model.game.elements.Health;
import com.l12gr05.projeto.model.game.elements.Hero;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Arena {
    private final int height;
    private final int width;

    private final int level;
    private Hero hero;

    private final List<Wall> walls = new ArrayList<>();
    private List<Monster> monsters = new ArrayList<>();
    private final List<King> kings = new ArrayList<>();
    private List<Bullet> bullets = new ArrayList<>();
    private List<Health> health = new ArrayList<>();

    private Boss boss;
    private int Score ;
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

        InputStream istream = ClassLoader.getSystemResourceAsStream(arenaPath);
        InputStreamReader istreamreader = new InputStreamReader(istream, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(istreamreader);
        try {
            int i = 0;
            for (String line; (line = reader.readLine()) != null; i++) {
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
                    if(c == 'f'){
                        boss = new Boss(j,i);
                    }
                    if(c == 'J'){
                        health.add(new Health(j,i));
                    }
                    j++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void spawnMonster(){
        monsters.add(new Monster(5,5));
        monsters.add(new Monster(20,20));
    }

    public void eraseBullet(int index){
        if(index < bullets.size()){
            bullets.remove(index);
        }
    }

    public void eraseMonster(int index){
        monsters.remove(index);
    }
    public void eraseKing(int index){
        kings.remove(index);
    }
    public void eraseHealth(int index){health.remove(index);
    }

    public boolean notContainsWall(int x, int y){
        Position position = new Position(x,y);
        for(Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        return true;
    }

    public void Shoot(char dir, Position position, boolean hero){
        int x = position.getX();
        int y = position.getY();

        switch (dir){
            case 'r':
                if(notContainsWall(x + 1,y)){
                    bullets.add(new Bullet(x + 1, y, dir ,hero));
                }
                break;
            case 'l':
                if(notContainsWall(x - 1,y)){
                    bullets.add(new Bullet(x - 1, y, dir, hero));
                }
                break;
            case 'd':
                if(notContainsWall(x,y+1)){
                    bullets.add(new Bullet(x , y + 1, dir, hero));
                }
                break;
            case 'u':
                if(notContainsWall(x,y-1)){
                    bullets.add(new Bullet( x , y - 1, dir, hero));
                }
                break;
            case 'q':
                if(notContainsWall(x - 1,y - 1)){
                    bullets.add(new Bullet(x -1  , y - 1, dir, hero));
                }
                break;
            case 't':
                if(notContainsWall(x + 1,y-1)){
                    bullets.add(new Bullet(x + 1,y-1, dir, hero));
                }
                break;
            case 'a':
                if(notContainsWall(x - 1,y+1)){
                    bullets.add(new Bullet(x - 1, y + 1, dir, hero));
                }
                break;
            case 'z':
                if(notContainsWall(x + 1,y+1)){
                    bullets.add(new Bullet(x + 1, y + 1, dir, hero));
                }
                break;
        }
    }

    public int getLevel(){
        return level;
    }
    public Hero getHero(){
        return hero;
    }
    public Boss getBoss() {return boss;}
    public List<Wall> getWalls(){
        return walls;
    }
    public List<Health> getHealth(){
        return health;
    }
    public List<Monster> getMonsters(){
        return monsters;
    }
    public List<King> getKings(){
        return kings;
    }
    public List<Bullet> getBullets(){
        return bullets;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getScore() {
        return Score;
    }
    public void setScore(int s) {
        Score = s;
    }
    public void setMonsters(List<Monster> m){
        monsters = m;
    }
    public void setBullets(List<Bullet> bullet_l) {bullets = bullet_l;}
    public void setHealth(List<Health> health_l) {health = health_l;}
}
