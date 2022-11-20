package com.RafaelNTeixeira.projeto.Graphics;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface GUI {

    KeyStroke getNextAction() throws IOException;

    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawKing(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, EXIT, PAUSE, CHAR}
}
