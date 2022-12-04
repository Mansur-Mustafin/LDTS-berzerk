package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.*;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.RafaelNTeixeira.projeto.model.menu.Win;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class ArenaController extends GameController {
    private HeroController heroController;
    private EnemyController EnemyController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);
        this.EnemyController = new EnemyController(arena);
    }

    public boolean checkNextLvl(Position position){
        int x = getModel().getHero().getPosition().getX();
        int y = getModel().getHero().getPosition().getY();
        if(x > 33 || y > 24){
            return true;
        }
        return false;
    }

    public boolean checkPrevLvl(Position position){
        int x = getModel().getHero().getPosition().getX();
        int y = getModel().getHero().getPosition().getY();
        if(x < 0 || y < 0){
            return true;
        }
        return false;
    }


    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) {
            heroController.step(game, key, time);
            if(checkNextLvl(getModel().getHero().getPosition())){
                if(getModel().getlLevel() == 4){
                    game.setState(new WinState(new Win(game.getScore())));
                    return;
                }
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() + 1)));
            }

            if(checkNextLvl(getModel().getHero().getPosition())){
                if(getModel().getlLevel() == 4){
                    game.setState(new MenuState(new Menu()));
                    return;
                }
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() + 1)));
            }

            EnemyController.setPosition_hero(getModel().getHero().position);
            EnemyController.setWalls(getModel().getWalls());
            EnemyController.step(game, key, time);
            if(getModel().getHero().getEnergy() <= 0){
                game.setState(new LoseState(new Lose(game.getScore())));
            }
        } else {
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                game.setState(new MenuState(new Menu()));
                return;
            }
            if (this.getModel().getHero().getEnergy() <= 0) {
                game.setState(new LoseState(new Lose(game.getScore())));
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'e') {
                game.setState(null);
                return;
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


    public void setEnemyController(EnemyController e){
        EnemyController = e;
    }
    public void setHeroController(HeroController h){
        heroController = h;
    }
}
