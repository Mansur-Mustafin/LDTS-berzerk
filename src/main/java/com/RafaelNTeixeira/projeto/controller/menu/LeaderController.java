package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.Leader;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class LeaderController extends Controller<Leader> {
    public LeaderController(Leader leader) {
        super(leader);
    }

    public void changeTabSound(SoundControl instance) {
        instance.stop(Sound.CHANGETAB);
        instance.start(Sound.CHANGETAB);
    }

    public void stepNotNull(Game game, KeyStroke key, long time, SoundControl instance) {

        switch (key.getKeyType()) {

            case Enter:
                changeTabSound(instance);

                boolean selectedEnter = getModel().isSelectedEnter();
                if (selectedEnter) {
                    game.setState(new MenuState(new Menu()));
                }
                game.setScore(0);
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
