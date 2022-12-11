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

    public void setLastBullet(long time){
        lastBullet = time;
    }

    public boolean checkNextLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x > 33 || y > 23;
    }

    public boolean checkPrevLvl(Position position){
        int x = position.getX();
        int y = position.getY();
        return x <= 0 || y <= 0;
    }

    public void ShootSound(SoundControl instance){
        instance.stop(Sound.SHOOTING);
        instance.start(Sound.SHOOTING);
    }

    public void steplastBullet(Game game, KeyStroke key, SoundControl instance){
        if (key.getKeyType() == KeyType.ArrowRight) {
            ShootSound(instance);
            getModel().Shoot('r', getModel().getHero().getPosition(), true);
        }
        if (key.getKeyType() == KeyType.ArrowLeft) {
            ShootSound(instance);
            getModel().Shoot('l', getModel().getHero().getPosition(), true);
        }
        if (key.getKeyType() == KeyType.ArrowUp) {
            ShootSound(instance);
            getModel().Shoot('u', getModel().getHero().getPosition(), true);
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            ShootSound(instance);
            getModel().Shoot('d', getModel().getHero().getPosition(), true);
        }
    }

    public void stepVoidKey(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {
        int score = game.getScore();

        heroController.step(game, null, time);

        if(getModel().getLevel() == 6 && getModel().getBoss().getEnergy() <= 0){
            game.setState(new WinState(new Win(score)));
            return;
        }

        boolean canGoToNextLevel = checkNextLvl(getModel().getHero().getPosition());
        if (canGoToNextLevel){
            int N_lvl = getModel().getLevel() + 1;
            game.setState(new GameState(new Arena(34, 25, N_lvl)));
        }

        boolean canGoToPrevLevel = checkPrevLvl(getModel().getHero().getPosition());
        if (canGoToPrevLevel) {
            game.setState(new GameState(new Arena(34, 25, getModel().getLevel() - 1)));
        }

        bulletController.step(game, null, time);
        enemyController.step(game, null, time);

        if(getModel().getHero().getEnergy() <= 0){
            game.setState(new LoseState(new Lose(score)));
        }
    }

    public void stepNonVoid(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {
        int score = game.getScore();

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
            return;
        }
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'e') {
            game.setState(null);
            return;
        }
        if(time - lastBullet > 250 ){
            steplastBullet(game, key, instance);
            this.lastBullet = time;
        }

        if (key.getKeyType() == KeyType.Escape) {
            instance.stopAll();
            instance.start(Sound.MENUMUSIC);
            State state = game.getState();
            game.setOldState(state);
            game.setState(new PauseState(new Pause()));
        } else {
<<<<<<< HEAD
            heroController.step(game, key, time);
            enemyController.step(game, key, time);
        }
    }
=======
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
                    instance.stop(Sound.SHOOTING);
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('r', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowLeft) {
                    instance.stop(Sound.SHOOTING);
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('l', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowUp) {
                    instance.stop(Sound.SHOOTING);
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('u', getModel().getHero().position, true);
                }
                if (key.getKeyType() == KeyType.ArrowDown) {
                    instance.stop(Sound.SHOOTING);
                    instance.start(Sound.SHOOTING);
                    getModel().Shoot('d', getModel().getHero().position, true);
                }
                this.lastBullet = time;
            }
>>>>>>> 37a01ea344fb9ca472d9551ba988186e3519d2a6

    public void step(Game game, KeyStroke key, long time) throws IOException {
        SoundControl instance = SoundControl.getInstance();
        if (key == null) {
            stepVoidKey(game, null, time,instance );
        } else {
            stepNonVoid(game, key, time,instance );
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
