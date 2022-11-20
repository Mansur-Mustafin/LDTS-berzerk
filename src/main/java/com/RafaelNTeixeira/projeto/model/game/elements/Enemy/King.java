package com.RafaelNTeixeira.projeto.model.game.elements.Enemy;

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.KingMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MonsterMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.NotMovingStrategy;

public class King extends Enemy{
    public King(int x, int y){
        super(x,y);
    }

    @Override
    protected MoveStrategy generateMoveStrategy(){
        return new NotMovingStrategy();
    }
}
