package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.List;

public class EMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){
        return new Position(position.getX() + 1, position.getY());
    }
}
