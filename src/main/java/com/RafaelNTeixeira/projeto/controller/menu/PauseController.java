package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.Graphics.GUI;
import com.RafaelNTeixeira.projeto.States.GameState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.States.State;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Menu;
import com.RafaelNTeixeira.projeto.model.menu.Pause;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause) {
        super(pause);
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if(key == null){
            return;
        }
        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:
                boolean selectedExit = getModel().isSelectedExit();
                if (selectedExit) game.setState(null);

                SoundControl instance = SoundControl.getInstance();

                boolean selectedContinue = getModel().isSelectedContinue();
                if (selectedContinue) {
                    instance.start(Sound.CHANGETAB);
                    instance.stop(Sound.MENUMUSIC);
                    instance.start(Sound.SOUNDTRACK);
                    State oldState = game.getOldState();
                    game.setState(oldState);
                }

                boolean selectedNewGame = getModel().isSelectedNewGame();
                if (selectedNewGame) {
                    instance.start(Sound.CHANGETAB);
                    instance.start(Sound.SOUNDTRACK);
                    game.setState(new GameState(new Arena(34, 24, 1)));
                    game.setScore(0);
                }
                boolean selectedGoToMenu = getModel().isSelectedGoToMenu();
                if (selectedGoToMenu) {
                    instance.start(Sound.CHANGETAB);
                    game.setState(new MenuState(new Menu()));
                }
                break;
            case Character:
                if(key.getCharacter() == 'e'){
                    game.setState(null);
                }
                if(key.getCharacter() == 'q'){
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}

