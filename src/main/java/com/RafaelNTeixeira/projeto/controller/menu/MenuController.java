package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.GameState;
import com.RafaelNTeixeira.projeto.States.InstructionsState;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.game.arena.Arena;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
        SoundControl.getInstance().start(Sound.MENUMUSIC);
    }

    public void newGameMusic(SoundControl instance) {
        instance.start(Sound.CHANGETAB);
        instance.stop(Sound.MENUMUSIC);
        instance.start(Sound.SOUNDTRACK);
    }

    public void changeTabSound(SoundControl instance){
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, long time, SoundControl instance) throws IOException{

        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:

                boolean selectedExit = getModel().isSelectedExit();
                if (selectedExit) {
                    game.setState(null);
                }

                boolean selectedStart = getModel().isSelectedStart();
                if (selectedStart) {
                    newGameMusic(instance);
                    game.setState(new GameState(new Arena(34, 24, 1)));
                    game.setScore(0);
                }

                boolean selectedLeaderBoard = getModel().isSelectedLeaderBoard();
                if (selectedLeaderBoard) {
                    changeTabSound(instance);
                    game.setState(new LeaderBoardState(new Leader()));
                }

                boolean selectedInstructions = getModel().isSelectedInstructions();
                if (selectedInstructions) {
                    changeTabSound(instance);
                    game.setState(new InstructionsState((new Instruction())));
                }
                break;
            case Character:
                if (key.getCharacter() == 'e') {
                    instance.stopAll();
                    game.setState(null);
                }
                break;
        }

    }
    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) {
            return;
        }
        SoundControl instance = SoundControl.getInstance();
        stepNotNull(game, key, time, instance);
    }
}
