package com.RafaelNTeixeira.projeto.Graphics;

import com.RafaelNTeixeira.projeto.model.game.Position;

import java.io.IOException;

public interface GUI {

    ACTION getNextAction() throws IOException;
    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawKing(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, EXIT}
}
