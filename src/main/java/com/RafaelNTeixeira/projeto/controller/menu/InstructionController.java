package com.RafaelNTeixeira.projeto.controller.menu;

import com.RafaelNTeixeira.projeto.Game;
import com.RafaelNTeixeira.projeto.States.MenuState;
import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.model.menu.Menu;

import com.RafaelNTeixeira.projeto.model.sounds.Sound;
import com.RafaelNTeixeira.projeto.model.sounds.SoundControl;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.Enter;

public class InstructionController extends Controller<Instruction> {
    public InstructionController(Instruction instruction) {
        super(instruction);
    }

    public void stepNotNull(Game game, KeyStroke key, long time, SoundControl instance){
        switch (key.getKeyType()) {
            case Enter:
                instance.start(Sound.CHANGETAB);

                boolean selectedEnter = getModel().isSelectedEnter();
                if (selectedEnter) game.setState(new MenuState(new Menu()));
                break;
            case Character:
                if (key.getCharacter() == 'e'){
                    game.setState(null);
                }
                break;
        }
    }

    @Override
    public void step(Game game, KeyStroke key, long time) throws IOException {
        if (key == null) return;

        SoundControl instance = SoundControl.getInstance();
        stepNotNull(game, key, time, instance);
    }
}