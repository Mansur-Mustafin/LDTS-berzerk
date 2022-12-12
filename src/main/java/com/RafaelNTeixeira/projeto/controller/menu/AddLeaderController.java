package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.LeaderBoardState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.AddLeader;
import com.RafaelNTeixeira.projeto.model.menu.Leader;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class AddLeaderController extends Controller<AddLeader> {
    public AddLeaderController(AddLeader lose) {
        super(lose);
    }

    public void stepNotNull(Game game, KeyStroke key, long time, SoundControl instance) throws IOException {

        pressedEnter(game, key, instance);
        writeName(key);

        if(key.getKeyType() == KeyType.Backspace){
            if(getModel().getName().length() == 0){
                return;
            }
            getModel().delChar();
        }
    }

    private void writeName(KeyStroke key) {
        if (key.getKeyType() == KeyType.Character) {
            getModel().addChar(key.getCharacter());
        }
    }

    private void pressedEnter(Game game, KeyStroke key, SoundControl instance) throws IOException {
        if (key.getKeyType() == KeyType.Enter) {
            instance.start(Sound.CHANGETAB);
            getModel().addScore();
            game.setState(new LeaderBoardState(new Leader()));
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
