package com.RafaelNTeixeira.projeto.model.game.elements;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.*;


import java.util.List;


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
        Position move = moveStrategy.move(position, position_hero, walls);
        return move;
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