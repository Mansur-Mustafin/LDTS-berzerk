package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.AddLeaderState;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.*;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;


public class LoseController extends Controller<Lose> {
    public LoseController(Lose lose) {
        super(lose);
        SoundControl instance = SoundControl.getInstance();
        startMenuMusic(instance);
    }

    public void startMenuMusic(SoundControl instance){
        instance.stop(Sound.SOUNDTRACK);
        instance.start(Sound.MENUMUSIC);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {

        switch (key.getKeyType()) {
            case ArrowUp:
                getModel().previousEntry();
                break;
            case ArrowDown:
                getModel().nextEntry();
                break;
            case Enter:

                changeTabSound(instance);

                boolean selectedMenu = getModel().isSelectedMenu();
                if (selectedMenu) {
                    game.setState(new MenuState(new Menu()));
                }

                boolean selectedLeaderBoard = getModel().isSelectedLeaderBoard();
                if (selectedLeaderBoard) {
                    game.setState(new LeaderBoardState( new Leader()));
                }

                boolean selectedAddToLeaderBoard = getModel().isSelectedAddToLeaderBoard();
                if (selectedAddToLeaderBoard) {
                    int score = getModel().getScore();
                    game.setState(new AddLeaderState(new AddLeader(score)));
                }
                break;
            case Character:
                if(key.getCharacter() == 'e'){
                    game.setState(null);
                }
                break;
        }

    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if(key == null){
            return;
        }

        SoundControl instance = SoundControl.getInstance();

        stepNotNull(game, key, time, instance);

    }
}
