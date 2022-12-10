package com.RafaelNTeixeira.projeto.Graphics;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.github.javaparser.utils.Pair;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;
import java.util.List;

public interface GUI {

    KeyStroke getNextAction() throws IOException;

    void drawHeart(Position position);
    void drawHeartBoss(Position position);
    void drawHero(Position position);

    //List<Pair<Integer, Integer>> getPressedMause();

    //void clickReleased();
    void drawWall(Position position);

    void drawMonster(Position position);
    void drawBoss(Position position);
    void drawKing(Position position);
    void drawHeroBullet(Position position);
    void drawEnemyBullet(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, EXIT, PAUSE, CHAR}
}
