package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.LoseState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.States.PauseState;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;
    private final EnemyController EnemyController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.EnemyController = new EnemyController(arena);
    }

    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) {
            heroController.step(game, key, time);
            EnemyController.setPosition_hero(getModel().getHero().position);
            EnemyController.setWalls(getModel().getWalls());
            EnemyController.step(game, key, time);
            if(getModel().getHero().getEnergy() <= 0){
                game.setState(new LoseState(new Lose()));
            }
        } else {
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                game.setState(new MenuState(new Menu()));
            }
            if (getModel().getHero().getEnergy() <= 0) {
                game.setState(new LoseState(new Lose()));
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'e') {
                game.setState(null);
            }
            if (key.getKeyType() == KeyType.Escape) {
                game.setOldState(game.getState());
                game.setState(new PauseState(new Pause()));
            } else {
                heroController.step(game, key, time);
                EnemyController.setPosition_hero(getModel().getHero().position);
                EnemyController.setWalls(getModel().getWalls());
                EnemyController.step(game, key, time);
            }
        }
    }
}
