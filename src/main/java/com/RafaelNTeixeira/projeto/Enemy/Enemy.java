package com.RafaelNTeixeira.projeto.Enemy;

import com.RafaelNTeixeira.projeto.Element;
import com.RafaelNTeixeira.projeto.Enemy.Move.MoveStrategy;
import com.RafaelNTeixeira.projeto.Position;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Enemy extends Element {

    private final MoveStrategy moveStrategy;

    public Enemy(int x, int y) {
        super(x,y);
        this.moveStrategy = generateMoveStrategy();
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#CC0000"));
        graphics.enableModifiers(SGR.BORDERED);
        graphics.putString(new TerminalPosition(position.getX(),position.getY()),"M");
    }

    protected abstract MoveStrategy generateMoveStrategy();

    public Position move(){
        return moveStrategy.move(position);
    }
}
