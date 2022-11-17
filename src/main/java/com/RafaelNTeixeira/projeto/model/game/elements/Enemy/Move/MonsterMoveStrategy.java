package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.List;
import java.util.Random;

public class MonsterMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){
        Random random = new Random();
        int x = random.nextInt(3) - 1;
        int y = random.nextInt(3) - 1;
        return new Position(position.getX() + x, position.getY() + y);

    }
}
