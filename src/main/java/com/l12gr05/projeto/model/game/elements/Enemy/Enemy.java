package com.l12gr05.projeto.model.game.elements.Enemy;

import com.l12gr05.projeto.model.game.elements.Element;
import com.l12gr05.projeto.model.game.elements.Enemy.Move.Move;
import com.l12gr05.projeto.model.game.Position;
import com.l12gr05.projeto.model.game.elements.Wall;

import java.util.List;

public abstract class Enemy extends Element {

    private Move move;
    private int energy;

    public Enemy(int x, int y) {
        super(x,y);
        Move move_ = generateMoveStrategy();
        int energy_ = generateEnergy();
        
        this.move = move_;
        energy = energy_;
    }

    public void decreaseEnergy(int x) {
        this.energy -= x;
    }
    public int getEnergy(){return energy; }
    public Move getMoveStrategy() {return move;}

    public void setMoveStrategy(Move strategy){
        move = strategy;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    protected abstract Move generateMoveStrategy();
    protected abstract int generateEnergy();

    public Position move(Position position_hero, List<Wall> walls){
        Position move = this.move.move(position, position_hero, walls);
        return move;
    }
}
