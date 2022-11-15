package com.RafaelNTeixeira.projeto.model.game.elements.Enemy;

import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MonsterMoveStrategy;
import com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move.MoveStrategy;

public class Monster extends Enemy{
    public Monster(int x, int y){
        super(x,y);
    }

    @Override
    protected MoveStrategy generateMoveStrategy(){
        return new MonsterMoveStrategy();
    }

}