package com.RafaelNTeixeira.projeto.controller.game;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.*;
import com.RafaelNTeixeira.projeto.model.game.Position;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Lose;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Pause;
import com.RafaelNTeixeira.projeto.model.menu.Win;
import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;

public class ArenaController extends GameController {
    private HeroController heroController;
    private EnemyController enemyController;
    private BulletController bulletController;
    private long lastBullet;

    public ArenaController(Arena arena) {
        super(arena);
        this.heroController = new HeroController(arena);
        this.enemyController = new EnemyController(arena);
        this.bulletController = new BulletController(arena);
    }

    public boolean checkNextLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x > 33 || y > 24;
    }

    public boolean checkPrevLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x < 0 || y < 0;
    }

    public void step(Game game, KeyStroke key, long time) throws IOException {
        int score = game.getScore();
        if (key == null) {
            heroController.step(game, null, time);
            boolean canGoToNextLevel = checkNextLvl(getModel().getHero().getPosition());
            if (canGoToNextLevel){
                if (getModel().getlLevel() == 4) {
                    game.setState(new WinState(new Win(score)));
                    return;
                }
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() + 1)));
            }

            boolean canGoToPrevLevel = checkPrevLvl(getModel().getHero().getPosition());
            if (canGoToPrevLevel) {
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() - 1)));
            }

            bulletController.step(game, null, time);
            enemyController.step(game, null, time);

            if(getModel().getHero().getEnergy() <= 0){
                game.setState(new LoseState(new Lose(score)));
            }
        } else {
            SoundControl instance = SoundControl.getInstance();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                instance.stop(Sound.SOUNDTRACK);
                instance.start(Sound.MENUMUSIC);
                game.setState(new MenuState(new Menu()));
                return;
            }
            if (this.getModel().getHero().getEnergy() <= 0) {
                instance.start(Sound.HERODEATH);
                instance.stop(Sound.SOUNDTRACK);
                instance.start(Sound.MENUMUSIC);
                game.setState(new LoseState(new Lose(score)));
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'e') {
                game.setState(null);
                return;
            }
            if(time - lastBullet > 250 ){
                if (key.getKeyType() == KeyType.ArrowRight) {
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('r', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowLeft) {
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('l', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowUp) {
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('u', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowDown) {
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('d', getModel().getHero().position, true);
                }
                this.lastBullet = time;
            }

            if (key.getKeyType() == KeyType.Escape) {
                instance.stopAll();
                instance.start(Sound.MENUMUSIC);
                State state = game.getState();
                game.setOldState(state);
                game.setState(new PauseState(new Pause()));
            } else {
                heroController.step(game, key, time);
                enemyController.step(game, key, time);
            }
        }
    }

    public void setEnemyController(EnemyController e){
        enemyController = e;
    }
    public void setHeroController(HeroController h){
        heroController = h;
    }
    public void setBulletController(BulletController h){
        bulletController = h;
    }
}
