package com.RafaelNTeixeira.projeto.model.game.elements.Enemy;

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NotMovingStrategy;

public class King extends Enemy{
    public King(int x, int y){
        super(x,y);
    }
    @Override
    protected int generateEnergy(){
        return 2;
    }
    @Override
    protected MoveStrategy generateMoveStrategy(){
        return new NotMovingStrategy();
    }
}
