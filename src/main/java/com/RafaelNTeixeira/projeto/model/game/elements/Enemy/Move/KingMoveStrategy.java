package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;

import java.util.Random;

public class KingMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position){
        Random random = new Random();
        int x = random.nextInt(5) - 2;
        int y = random.nextInt(5) - 2;
        return new Position(position.getX() + x, position.getY() + y);
    }
}
