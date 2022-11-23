package com.RafaelNTeixeira.projeto.model.game.elements.Enemy.Move;

import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.elements.Wall;

import java.util.*;

public class BFSMoveStrategy implements MoveStrategy{

    boolean canMove(Position position){
        if (position.getX() < 0 || position.getY() < 0 || position.getX() > 99 || position.getY() > 59)
            return false;
        return true;
    }

    boolean conteins(List<Wall> walls, Position position){
        for(Wall w: walls){
            if(w.getPosition().getX() == position.getX() && w.getPosition().getY() == position.getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public Position move(Position position, Position position_hero , List<Wall> walls){

        if(position.equals(position_hero)){
            return position;
        }

        List<Position> steps = new ArrayList<Position>() ;
        steps.add(new Position(1,0)); steps.add(new Position(-1,0));
        steps.add(new Position(0,-1)); steps.add(new Position(0,1));
        steps.add(new Position(1,1)); steps.add(new Position(-1,1));
        steps.add(new Position(1,-1)); steps.add(new Position(-1,-1));

        boolean[][]  used = new boolean[100][60];
        Position[][] parent = new Position[100][60];
        //int[][]  distance = new int[100][60];
        Queue<Position> q = new LinkedList<Position>();
        q.add(position);

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 60; j++){
                used[i][j] = false;
            }
        }

        //distance[position.getX()][position.getY()] = 0;
        used[position.getX()][position.getY()] = true;

        while(!q.isEmpty()){
            Position tmp = q.remove();
            for(Position step : steps){
                Position tmp2 = tmp.add(step);
                if(canMove(tmp2) ){
                    if(!conteins(walls, tmp2)){
                        if(!used[tmp2.getX()][tmp2.getY()]){
                            //distance[tmp2.getX()][tmp2.getY()] = distance[tmp.getX()][tmp.getY()] + 1;
                            used[tmp2.getX()][tmp2.getY()] = true;
                            q.add(tmp2);
                            parent[tmp2.getX()][tmp2.getY()] = new Position(tmp.getX(), tmp.getY());
                        }
                    }
                }
                if(tmp2.equals(position_hero)){
                    break;
                }
            }
        }

        if(!used[position_hero.getX()][position_hero.getY()]){
            return position;
        }

        Position tmp = new Position(position_hero.getX(), position_hero.getY());

        while(!parent[tmp.getX()][tmp.getY()].equals(position)){
            tmp = parent[tmp.getX()][tmp.getY()];
        }

        return new Position(tmp.getX(), tmp.getY());
    }
}
