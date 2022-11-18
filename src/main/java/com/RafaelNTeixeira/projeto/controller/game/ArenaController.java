package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final EnemyController EnemyController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.EnemyController = new EnemyController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() <= 0)
            game.setState(new MenuState(new Menu()));
        else if(action == GUI.ACTION.EXIT){
            game.setState(null);
        }
        else {
            heroController.step(game, action, time);
            EnemyController.setPosition_hero(getModel().getHero().position);
            EnemyController.setWalls(getModel().getWalls());
            EnemyController.step(game, action, time);
        }
    }
}
