package com.RafaelNTeixeira.projeto.States;

import com.RafaelNTeixeira.projeto.controller.Controller;
import com.RafaelNTeixeira.projeto.controller.menu.InstructionController;
import com.RafaelNTeixeira.projeto.model.menu.Instruction;
import com.RafaelNTeixeira.projeto.viewer.InstructionViewer;
import com.RafaelNTeixeira.projeto.viewer.Viewer;


public class Instructions extends State<Instruction> {
    public Instructions(Instruction model) {
        super(model);
    }

    @Override
    protected Viewer<Instruction> getViewer() {
        return new InstructionViewer(getModel());
    }

    @Override
    protected Controller<Instruction> getController() {
        return new InstructionController(getModel());
    }
}