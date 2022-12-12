package com.l12gr05.projeto.model.game.elements.Enemy;

import com.l12gr05.projeto.model.game.elements.Enemy.Move.KingMoveStrategy;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.Move;

public class Boss extends Enemy{

    public Boss(int x, int y){
        super(x,y);
    }
    @Override
    protected int generateEnergy(){
        return 12;
    }
    @Override
    protected Move generateMoveStrategy(){
        return new KingMoveStrategy();
    }
}
