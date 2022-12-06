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
import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.io.IOException;

public class ArenaController extends GameController {
    private HeroController heroController;
    private EnemyController enemyController;
    private final BulletController bulletController;
    private long lastBullet;

    public ArenaController(Arena arena) {
        super(arena);
        this.heroController = new HeroController(arena);
        this.enemyController = new EnemyController(arena);
        this.bulletController = new BulletController(arena);
    }

    public boolean checkNextLvl(){
        int x = getModel().getHero().getPosition().getX();
        int y = getModel().getHero().getPosition().getY();
        return x > 33 || y > 24;
    }

    public boolean checkPrevLvl(){
        int x = getModel().getHero().getPosition().getX();
        int y = getModel().getHero().getPosition().getY();
        return x < 0 || y < 0;
    }

    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) {
            heroController.step(game, null, time);
            if(checkNextLvl()){
                if(getModel().getlLevel() == 4){
                    game.setState(new WinState(new Win(game.getScore())));
                    return;
                }
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() + 1)));
            }

            if(checkPrevLvl()){
                game.setState(new GameState(new Arena(34, 25, getModel().getlLevel() - 1)));
            }

            bulletController.step(game, null, time);
            enemyController.step(game, null, time);

            if(getModel().getHero().getEnergy() <= 0){
                game.setState(new LoseState(new Lose(game.getScore())));
            }
        } else {
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                SoundControl.getInstance().stop(Sound.SOUNDTRACK);
                SoundControl.getInstance().start(Sound.MENUMUSIC);
                game.setState(new MenuState(new Menu()));
                return;
            }
            if (this.getModel().getHero().getEnergy() <= 0) {
                SoundControl.getInstance().start(Sound.HERODEATH);
                SoundControl.getInstance().stop(Sound.SOUNDTRACK);
                SoundControl.getInstance().start(Sound.MENUMUSIC);
                game.setState(new LoseState(new Lose(game.getScore())));
            }
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'e') {
                game.setState(null);
                return;
            }
            if(time - lastBullet > 250 ){
                if(key.getKeyType() == KeyType.ArrowRight){
                    SoundControl.getInstance().start(Sound.SHOOTING);
                    getModel().Shoot('r', getModel().getHero().position, true);
                }
                if(key.getKeyType() == KeyType.ArrowLeft){
                    SoundControl.getInstance().start(Sound.SHOOTING);
                    getModel().Shoot('l', getModel().getHero().position, true);
                }
                if(key.getKeyType() == KeyType.ArrowUp){
                    SoundControl.getInstance().start(Sound.SHOOTING);
                    getModel().Shoot('u', getModel().getHero().position, true);
                }
                if(key.getKeyType() == KeyType.ArrowDown){
                    SoundControl.getInstance().start(Sound.SHOOTING);
                    getModel().Shoot('d', getModel().getHero().position, true);
                }
                this.lastBullet = time;
            }


            if (key.getKeyType() == KeyType.Escape) {
                SoundControl.getInstance().stopAll();
                SoundControl.getInstance().start(Sound.MENUMUSIC);
                game.setOldState(game.getState());
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
}
