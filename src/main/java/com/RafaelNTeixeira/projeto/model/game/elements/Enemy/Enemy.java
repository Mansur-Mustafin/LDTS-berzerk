package com.RafaelNTeixeira.projeto.model.game.elements.Enemy;

import com.RafaelNTeixeira.projeto.model.game.elements.Element;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.Position;
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

    public void setPosition(Position position){
        this.position = position;
    }

    protected abstract MoveStrategy generateMoveStrategy();

    public Position move(){
        return moveStrategy.move(position);
    }
}
