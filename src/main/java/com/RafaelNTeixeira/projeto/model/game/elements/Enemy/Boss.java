package com.RafaelNTeixeira.projeto.model.game.elements.Enemy;

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.BFSMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NotMovingStrategy;

public class Boss extends Enemy{

    public Boss(int x, int y){
        super(x,y);
    }
    @Override
    protected int generateEnergy(){
        return 12;
    }
    @Override
    protected MoveStrategy generateMoveStrategy(){
        return new BFSMoveStrategy();
    }
}
