package com.RafaelNTeixeira.projeto.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.RafaelNTeixeira.projeto.model.game.Position;

public abstract class Element {
    public Position position;

    public Element(int x, int y) {
        position = new Position(x,y);
    }

}
