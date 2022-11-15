package com.RafaelNTeixeira.projeto.model.game.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.RafaelNTeixeira.projeto.model.game.Position;

public class Wall extends Element {


    public Wall(int x, int y){
        super(x,y);
    }

    public Position getPosition() {
        return position;
    }


    public void draw(TextGraphics graphics){

        graphics.setBackgroundColor(TextColor.Factory.fromString("#5C627F"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#5C627F"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "w");
    }
}