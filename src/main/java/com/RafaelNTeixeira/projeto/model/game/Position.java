package com.RafaelNTeixeira.projeto.model.game;

public class Position {
    private int x;
    private int y;

    public Position(int x , int y){
        this.x = x;
        this.y = y;
    }
    public Position(){
        this(10,10);
    }

    public int getX() { return x;}
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Position add(Position position){
        return new Position(this.x + position.x,this.y + position.y);
    }
    public double getDistance(Position pos2){
        return Math.sqrt((pos2.x-x)*(pos2.x-x) + (pos2.y-y)*(pos2.y-y));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.getX() && y == p.getY();
    }
}
