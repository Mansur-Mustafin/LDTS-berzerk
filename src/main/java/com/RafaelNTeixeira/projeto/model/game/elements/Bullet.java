package com.RafaelNTeixeira.projeto.model.game.elements;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.*;
import com.github.javaparser.utils.Pair;

import java.util.List;

import static java.lang.Math.abs;

public class Bullet extends Element {
    private final MoveStrategy moveStrategy;
    private final boolean heroBullet;

    public Bullet(int x, int y, Character dir, boolean heroBullet){
        super(x,y);
        this.heroBullet = heroBullet;
        switch (dir){
            case 'r':
                moveStrategy =  new EMoveStrategy();
                break;
            case 'l':
                moveStrategy =  new OMoveStrategy();
                break;
            case 'u':
                moveStrategy =  new NMoveStrategy();
                break;
            case 'd':
                moveStrategy =  new SMoveStrategy();
                break;
            default:
                moveStrategy =  new NotMovingStrategy();
        }
    }

    public Position move(Position position_hero, List<Wall> walls){
        return moveStrategy.move(position, position_hero, walls);
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isHeroBullet() {
        return heroBullet;
    }
}