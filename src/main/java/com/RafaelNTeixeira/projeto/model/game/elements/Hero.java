package com.RafaelNTeixeira.projeto.model.game.elements;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.RafaelNTeixeira.projeto.model.game.Position;

public class Hero extends Element {

    private int energy;

    public Hero(int x, int y) {
        super(x,y);
        energy = 15;
    }

    public Hero() {
        this(10, 10);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public void decreaseEnergy(int x) {
        this.energy -= x;
    }

    public void setEnergy(int x ){
        energy = x;
    }

    public int getEnergy() {
        return energy;
    }


    public Position moveUp() {
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveLeft() {
        return new Position(position.getX()-1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX()+1, position.getY());
    }

    public void setPosition( Position position_new){
        this.position.setY(position_new.getY());
        this.position.setX(position_new.getX());
    }

    public Position getPosition(){
        return position;
    }


}
